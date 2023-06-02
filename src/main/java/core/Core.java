package core;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Properties;

import coreInicialization.RepositoryProviderFinder;
import coreInicialization.USTestSummaryInitializer;
import interfaces.USTestSummary;

public class Core {

    private final String DEFAULT_PLUGIN_PATH = "plugins";
    private static final String DEFAULT_PLUGIN_ELEGIDO = "DefaultTSProvider";
    protected Properties properties;

    
    public USTestSummary init(Properties properties) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException, MalformedURLException {
    	configureDefaultProperties(properties);
    	USTestSummaryInitializer initializer = createInitializer();
        return initializer.initialize();
    }

    
    private void configureDefaultProperties(Properties properties) {
    	this.properties = properties;
        if (properties.getProperty("repo") == null) properties.setProperty("repo", DEFAULT_PLUGIN_ELEGIDO);
        if (properties.getProperty("pluginPath") == null) properties.setProperty("pluginPath", DEFAULT_PLUGIN_PATH);
    }
    
    private USTestSummaryInitializer createInitializer() {
        RepositoryProviderFinder providerFinder = new RepositoryProviderFinder();
        return new USTestSummaryInitializer(properties, providerFinder);
    }
}
