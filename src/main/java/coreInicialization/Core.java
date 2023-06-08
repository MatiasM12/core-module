package coreInicialization;

import core.ObservableTS;
import Interfaces.Observable;
import Interfaces.TestSummary;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Core {
	
	private PropertiesLoader propertiesLoader;
	
	public Core() {
		this.propertiesLoader = new PropertiesLoader();
	}
	
	//args = {repo, US, PluginElegido, pluginsPath	
	public Observable init(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
		propertiesLoader.loadDefaultProperties("defaultArgs.properties");
		String repo = args[0];
		String userStory = args[1];
		String pluginElegido = args.length < 3 ? propertiesLoader.getDefaultPlugin() : args[2];
		String pluginPath = args.length < 4 ? propertiesLoader.getDefaultPluginPath() : args[3];
		ObservableTS ret = new ObservableTSFactory().create();
		TestSummary plugin = new OriginTSFactory(pluginPath).init(repo,userStory,pluginElegido,ret);
		return ret;
	}

}
