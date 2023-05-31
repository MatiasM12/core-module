package core;

import Interfaces.TSProvider;

import java.util.Properties;

/** construye un ObservableTS a partir de un TS. Es como un adapter*/
public class ObservableTSFactory {
    private final Properties properties;
    TSPFinder tsProviderFinder;

    public ObservableTSFactory(Properties properties){
        this.properties = properties;
        String pluginPath = properties.getProperty("pluginPath");
        this.tsProviderFinder = new TSPFinder(pluginPath);
    }

    public ObservableTS create(){
        String repo = properties.getProperty("repo");
        TSProvider tsp = this.tsProviderFinder.find(repo);
        return new ObservableTS(tsp.getTS(us)); // el constructor este queremos que sea privado por eso usamos el factory
    }




}
