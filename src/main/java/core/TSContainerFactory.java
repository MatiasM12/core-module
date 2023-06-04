package core;

import Interfaces.TestSummary;

import java.util.Map;
import java.util.Properties;

public class TSContainerFactory {
    private final Properties properties;
    private final TSProviderStrategy TSProviderStrategy;

    public TSContainerFactory(Properties properties) {
        this.properties = properties;
        this.TSProviderStrategy = new TSProviderStrategy(properties);
    }
    public TSContainer creat() {
        TSProvider provider = this.TSProviderStrategy.getTSProvider();
        Map<String, TestSummary> map = provider.getData();
        TSContainer container = new TSContainer(map, updater);
        TSContainerUpdater updater = new TSContainerUpdater(provider, container);

        return container;
    }
}
