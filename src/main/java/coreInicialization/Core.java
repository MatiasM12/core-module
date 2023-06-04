package coreInicialization;

import core.ObservableTS;
import Interfaces.Observable;
import Interfaces.TestSummary;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class Core {
	
	private final String DEFAULT_PLUGIN_PATH = "plugins";
	private static final String DEFAULT_PLUGIN_ELEGIDO = "DefaultTS";

	public Observable init(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		//args = {repo, US, PluginElegido, pluginsPath
		String repo = args[0];
		String userStory = args[1];
		String pluginElegido = args.length<3 ? DEFAULT_PLUGIN_ELEGIDO : args[2];
		String pluginPath = args.length<4 ? DEFAULT_PLUGIN_PATH : args[3];
		ObservableTS ret = new ObservableTSFactory().create();
		TestSummary plugin = new OriginTSFactory(pluginPath).init(repo,userStory,pluginElegido,ret);
		return ret;
	}

}
