package com.sohlman.liferay.bfdms.cache.proxy;

import com.liferay.configuration.admin.definition.ConfigurationFieldOptionsProvider;
import com.sohlman.liferay.bfdms.store.BinaryStoreCache;

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
        "configuration.pid=com.sohlman.liferay.bfdms.cache.proxy.BinaryStoreCacheConfiguration",
        "configuration.field.name=cacheType"
    },
    service = ConfigurationFieldOptionsProvider.class
)
public class BinaryStoreCacheTypeOptionsProvider
    implements ConfigurationFieldOptionsProvider {

    @Override
    public List<Option> getOptions() {
        List<Option> options = new ArrayList<>();

        for (String type : _cacheTypes) {
            final String cacheType = type;

            options.add(new Option() {

                @Override
                public String getLabel(Locale locale) {
                    return cacheType;
                }

                @Override
                public String getValue() {
                    return cacheType;
                }

            });
        }

        return options;
    }

    @Reference(
        cardinality = ReferenceCardinality.MULTIPLE,
        policy = ReferencePolicy.DYNAMIC,
        policyOption = ReferencePolicyOption.GREEDY,
        target = "(cache.type=*)",
        bind = "_addCache",
        unbind = "_removeCache"
    )
    protected void _addCache(BinaryStoreCache cache, Map<String, Object> props) {
        _cacheTypes.addIfAbsent((String) props.get("cache.type"));
    }

    protected void _removeCache(BinaryStoreCache cache, Map<String, Object> props) {
        _cacheTypes.remove(props.get("cache.type"));
    }

    private final CopyOnWriteArrayList<String> _cacheTypes =
        new CopyOnWriteArrayList<>();

}