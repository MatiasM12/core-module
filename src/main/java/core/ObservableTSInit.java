package core;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ObservableTSInit {
	private final PluginProvider provider;
	private final PluginsFinder finder;
	private final String DEFAULT_PLUGIN_PATH = "plugins";
	private static final String DEFAULT_PLUGIN_ELEGIDO = "DefaultPlugin";
	private  AppBuilder app;

	public ObservableTSInit(){
		this.provider = new PluginProvider();
		this.finder = new PluginsFinder();
		this.app = new AppBuilder();
	}
	public ObservableTS init(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		//args = {repo, US, PluginElegido, pluginsPath
		String repo = args[0];
		String userStory = args[1];
		String pluginElegido = args.length<3 ? DEFAULT_PLUGIN_ELEGIDO : args[2];
		String pluginPath = args.length<4 ? DEFAULT_PLUGIN_PATH : args[3];

		Set<TSProvider> set = finder.find(pluginPath);
		TSProvider TSProvider1 = this.provider.getOne(set, pluginElegido);

		ObservableTS ret = this.app.build(TSProvider1, userStory);
		return ret;
	}
}
