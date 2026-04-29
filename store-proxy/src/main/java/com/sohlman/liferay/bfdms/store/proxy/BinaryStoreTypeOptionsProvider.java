package com.sohlman.liferay.bfdms.store.proxy;

import com.liferay.configuration.admin.definition.ConfigurationFieldOptionsProvider;

import com.sohlman.liferay.bfdms.store.BinaryStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(
	property = {
		"configuration.pid=com.sohlman.liferay.bfdms.store.proxy.BinaryStoreConfiguration",
		"configuration.field.name=binaryStoreType"
	},
	service = ConfigurationFieldOptionsProvider.class
)
public class BinaryStoreTypeOptionsProvider
	implements ConfigurationFieldOptionsProvider {

	@Override
	public List<Option> getOptions() {
		List<Option> options = new ArrayList<>();

		for (String type : _types) {
			final String storeType = type;

			options.add(
				new Option() {

					@Override
					public String getLabel(Locale locale) {
						return storeType;
					}

					@Override
					public String getValue() {
						return storeType;
					}

				});
		}

		return options;
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(binary.store.type=*)",
		bind = "_addStore",
		unbind = "_removeStore"
	)
	protected void _addStore(
		BinaryStore store, Map<String, Object> properties) {

		_types.addIfAbsent((String)properties.get("binary.store.type"));
	}

	protected void _removeStore(
		BinaryStore store, Map<String, Object> properties) {

		_types.remove(properties.get("binary.store.type"));
	}

	private final CopyOnWriteArrayList<String> _types =
		new CopyOnWriteArrayList<>();

}
