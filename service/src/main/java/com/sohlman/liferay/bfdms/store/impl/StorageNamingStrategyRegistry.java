package com.sohlman.liferay.bfdms.store.impl;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.sohlman.liferay.bfdms.configuration.StorageNamingStrategyConfiguration;
import com.sohlman.liferay.bfdms.model.FileInfo;
import com.sohlman.liferay.bfdms.store.FolderFile;
import com.sohlman.liferay.bfdms.store.StorageNamingStrategy;

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
    configurationPid = "com.sohlman.liferay.bfdms.configuration.StorageNamingStrategyConfiguration",
    immediate = true,
    service = StorageNamingStrategyRegistry.class
)
public class StorageNamingStrategyRegistry {

    public FolderFile generate(FileInfo fileInfo, String fingerPrint) {
        return _getActive().generate(fileInfo, fingerPrint);
    }

    public String resolvePath(String storedName, String fingerPrint) {
        return _getActive().resolvePath(storedName, fingerPrint);
    }

    @Activate
    @Modified
    protected void activate(Map<String, Object> props) {
        _activeType = ConfigurableUtil.createConfigurable(
            StorageNamingStrategyConfiguration.class, props
        ).namingStrategyType();
    }

    @Reference(
        cardinality = ReferenceCardinality.AT_LEAST_ONE,
        policy = ReferencePolicy.DYNAMIC,
        policyOption = ReferencePolicyOption.GREEDY,
        target = "(naming.strategy.type=*)",
        bind = "_addStrategy",
        unbind = "_removeStrategy"
    )
    protected void _addStrategy(StorageNamingStrategy strategy, Map<String, Object> props) {
        _strategies.put((String) props.get("naming.strategy.type"), strategy);
    }

    protected void _removeStrategy(StorageNamingStrategy strategy, Map<String, Object> props) {
        _strategies.remove((String) props.get("naming.strategy.type"));
    }

    private StorageNamingStrategy _getActive() {
        StorageNamingStrategy strategy = _strategies.get(_activeType);
        return (strategy != null) ? strategy : _strategies.get("default");
    }

    private final ConcurrentHashMap<String, StorageNamingStrategy> _strategies =
        new ConcurrentHashMap<>();

    private volatile String _activeType = "default";

}
