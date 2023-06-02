package coreInicialization;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.Set;

import core.ObservableTS;
import interfaces.TSProvider;

public class ObservableTSFactory {
	
    private final Properties properties;
    RepositoryProviderFinder RPFinder;

    public ObservableTSFactory(Properties properties,RepositoryProviderFinder RPFinder) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException{
        this.properties = properties;
        this.RPFinder = RPFinder;
    }

    public ObservableTS create(Set<TSProvider> providers){
        TSProvider tsp = RPFinder.findProviderByRepository(providers,properties.getProperty("repo"));
        return new ObservableTS(tsp.getUSTS(properties.getProperty("us"))); 
    }


}
