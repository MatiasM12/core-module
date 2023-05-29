package coreInicialization;

import Interfaces.TSProvider;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ProviderInit {

    private final PluginChooser provider;
    private final PluginsFinder finder;

    public ProviderInit(){
        this.provider = new PluginChooser();
        this.finder = new PluginsFinder();
    }
    public TSProvider init(String pluginPath, String pluginElegido) throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Set<TSProvider> set = finder.find(pluginPath);
        TSProvider plugin = this.provider.getOne(set, pluginElegido);
        return plugin;
    }
}