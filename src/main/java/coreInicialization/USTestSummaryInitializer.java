package coreInicialization;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.Set;

import interfaces.TSProvider;
import interfaces.USTestSummary;

public class USTestSummaryInitializer {

    private Properties properties;
    private RepositoryProviderFinder RPFinder;

    public USTestSummaryInitializer(Properties properties, RepositoryProviderFinder tspFinder) {
        this.properties = properties;
        this.RPFinder = tspFinder;
    }

    public USTestSummary initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException, MalformedURLException {
        Set<TSProvider> providers = findUSTestSummaryProviders();
        ObservableTSFactory factory = createObservableUSTSFactory();
        return factory.create(providers);
    }

    private Set<TSProvider> findUSTestSummaryProviders() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException, MalformedURLException {
        return new TSProviderFinder().find(getPluginPath());
    }

    private ObservableTSFactory createObservableUSTSFactory() throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {
        return new ObservableTSFactory(properties, RPFinder);
    }

    private String getPluginPath() {
        return properties.getProperty("pluginPath");
    }
}
