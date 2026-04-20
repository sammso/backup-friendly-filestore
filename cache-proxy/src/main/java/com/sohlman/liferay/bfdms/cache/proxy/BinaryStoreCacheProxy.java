package com.sohlman.liferay.bfdms.cache.proxy;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.sohlman.liferay.bfdms.store.BinaryStoreCache;

import java.io.IOException;
import java.io.InputStream;
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
    configurationPid = "com.sohlman.liferay.bfdms.cache.proxy.BinaryStoreCacheConfiguration",
    immediate = true,
    property = "service.ranking:Integer=1000",
    service = BinaryStoreCache.class
)
public class BinaryStoreCacheProxy implements BinaryStoreCache {

    @Override
    public InputStream get(long companyId, String path) throws IOException {
        return _getActive().get(companyId, path);
    }

    @Override
    public InputStream wrap(long companyId, String path, InputStream source)
        throws IOException {

        return _getActive().wrap(companyId, path, source);
    }

    @Override
    public void invalidate(long companyId, String path) throws IOException {
        _getActive().invalidate(companyId, path);
    }

    @Override
    public void invalidateAll(long companyId) throws IOException {
        _getActive().invalidateAll(companyId);
    }

    @Override
    public String getType() {
        return "proxy";
    }

    @Activate
    @Modified
    protected void activate(Map<String, Object> props) {
        _activeCacheType = ConfigurableUtil.createConfigurable(
            BinaryStoreCacheConfiguration.class, props
        ).cacheType();
    }

    @Reference(
        cardinality = ReferenceCardinality.AT_LEAST_ONE,
        policy = ReferencePolicy.DYNAMIC,
        policyOption = ReferencePolicyOption.GREEDY,
        target = "(cache.type=*)",
        bind = "_addCache",
        unbind = "_removeCache"
    )
    protected void _addCache(BinaryStoreCache cache, Map<String, Object> props) {
        _caches.put((String) props.get("cache.type"), cache);
    }

    protected void _removeCache(BinaryStoreCache cache, Map<String, Object> props) {
        _caches.remove((String) props.get("cache.type"));
    }

    private BinaryStoreCache _getActive() {
        BinaryStoreCache cache = _caches.get(_activeCacheType);
        return (cache != null) ? cache : _caches.get("noop");
    }

    private final ConcurrentHashMap<String, BinaryStoreCache> _caches =
        new ConcurrentHashMap<>();

    private volatile String _activeCacheType = "noop";

}
