package com.sohlman.liferay.bfdms.store.impl;

import com.liferay.configuration.admin.definition.ConfigurationFieldOptionsProvider;
import com.sohlman.liferay.bfdms.store.StorageNamingStrategy;

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
        "configuration.pid=com.sohlman.liferay.bfdms.configuration.StorageNamingStrategyConfiguration",
        "configuration.field.name=namingStrategyType"
    },
    service = ConfigurationFieldOptionsProvider.class
)
public class StorageNamingStrategyTypeOptionsProvider
    implements ConfigurationFieldOptionsProvider {

    @Override
    public List<Option> getOptions() {
        List<Option> options = new ArrayList<>();

        for (String type : _strategyTypes) {
            final String strategyType = type;

            options.add(new Option() {

                @Override
                public String getLabel(Locale locale) {
                    return strategyType;
                }

                @Override
                public String getValue() {
                    return strategyType;
                }

            });
        }

        return options;
    }

    @Reference(
        cardinality = ReferenceCardinality.MULTIPLE,
        policy = ReferencePolicy.DYNAMIC,
        policyOption = ReferencePolicyOption.GREEDY,
        target = "(naming.strategy.type=*)",
        bind = "_addStrategy",
        unbind = "_removeStrategy"
    )
    protected void _addStrategy(StorageNamingStrategy strategy, Map<String, Object> props) {
        _strategyTypes.addIfAbsent((String) props.get("naming.strategy.type"));
    }

    protected void _removeStrategy(StorageNamingStrategy strategy, Map<String, Object> props) {
        _strategyTypes.remove(props.get("naming.strategy.type"));
    }

    private final CopyOnWriteArrayList<String> _strategyTypes =
        new CopyOnWriteArrayList<>();

}
