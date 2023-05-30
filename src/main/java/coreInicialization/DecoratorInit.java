package coreInicialization;


import Interfaces.TestSummary;
import core.TSDecorator;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class DecoratorInit {

    private final DecoratorChooser chooser;
    private final PluginsFinder finder;

    public DecoratorInit(){
        this.chooser = new DecoratorChooser();
        this.finder = new PluginsFinder();
    }
    public TSDecorator init(String pluginPath, String pluginElegido, TestSummary ts) throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Set<TSDecorator> set = finder.find(pluginPath,ts);
        TSDecorator plugin = this.chooser.getOne(set, pluginElegido);
        return plugin;
    }
}
