package com.sohlman.liferay.bfdms.store.proxy;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sohlman.liferay.bfdms.store.BinaryStore;

import java.io.IOException;
import java.io.InputStream;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(
	configurationPid = "com.sohlman.liferay.bfdms.store.proxy.BinaryStoreConfiguration",
	immediate = true,
	property = "service.ranking:Integer=1000",
	service = BinaryStore.class
)
public class BinaryStoreProxy implements BinaryStore {

	@Override
	public void store(long companyId, String path, InputStream inputStream)
		throws IOException {

		_getActive().store(companyId, path, inputStream);
	}

	@Override
	public InputStream retrieve(long companyId, String path) throws IOException {
		return _getActive().retrieve(companyId, path);
	}

	@Override
	public void delete(long companyId, String path) throws IOException {
		_getActive().delete(companyId, path);
	}

	@Override
	public boolean exists(long companyId, String path) throws IOException {
		return _getActive().exists(companyId, path);
	}

	@Override
	public void forEach(long companyId, PathConsumer consumer)
		throws IOException {

		_getActive().forEach(companyId, consumer);
	}

	@Override
	public String getType() {
		return "proxy";
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		BinaryStoreConfiguration configuration =
			ConfigurableUtil.createConfigurable(
				BinaryStoreConfiguration.class, properties);

		_activeType = configuration.binaryStoreType();

		if (_log.isInfoEnabled()) {
			_log.info(
				StringBundler.concat(
					"BinaryStoreProxy active type: ", _activeType));
		}
	}

	@Reference(
		cardinality = ReferenceCardinality.AT_LEAST_ONE,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(binary.store.type=*)",
		bind = "_addStore",
		unbind = "_removeStore"
	)
	protected void _addStore(
		BinaryStore store, Map<String, Object> properties) {

		_stores.put((String)properties.get("binary.store.type"), store);
	}

	protected void _removeStore(
		BinaryStore store, Map<String, Object> properties) {

		_stores.remove(properties.get("binary.store.type"));
	}

	private BinaryStore _getActive() {
		BinaryStore store = _stores.get(_activeType);

		if (store != null) {
			return store;
		}

		store = _stores.get("filesystem");

		if (store != null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					StringBundler.concat(
						"No BinaryStore registered for binary.store.type=",
						_activeType, "; falling back to filesystem"));
			}

			return store;
		}

		Iterator<BinaryStore> iterator = _stores.values().iterator();

		if (iterator.hasNext()) {
			BinaryStore fallback = iterator.next();

			if (_log.isWarnEnabled()) {
				_log.warn(
					StringBundler.concat(
						"No BinaryStore registered for binary.store.type=",
						_activeType,
						" and no filesystem store available; falling back to ",
						fallback.getType()));
			}

			return fallback;
		}

		throw new IllegalStateException("No BinaryStore service is registered");
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BinaryStoreProxy.class);

	private volatile String _activeType = "filesystem";
	private final ConcurrentHashMap<String, BinaryStore> _stores =
		new ConcurrentHashMap<>();

}
