package coreInicialization;

import core.ConcreteTS;
import core.ObservableTS;
import core.TSDecorator;
import Interfaces.TestSummary;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class ObservableTSInit {
	private final String DEFAULT_PLUGIN_PATH = "plugins";
	private static final String DEFAULT_PLUGIN_ELEGIDO = "DefaultTSProvider";
	private DecoratorInit inicializador;

	public ObservableTSInit(){
		inicializador = new DecoratorInit();    
	}
	public ObservableTS init(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		//args = {repo, US, PluginElegido, pluginsPath
		String repo = args[0];
		String userStory = args[1];
		String pluginElegido = args.length<3 ? DEFAULT_PLUGIN_ELEGIDO : args[2];
		String pluginPath = args.length<4 ? DEFAULT_PLUGIN_PATH : args[3];
		TestSummary ts = new ConcreteTS(); 
		ObservableTS ret = new ObservableTS(ts);
		TSDecorator tsD = inicializador.init(pluginPath, pluginElegido, ret);
		
		return ret;
	}
}
