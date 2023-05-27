package CoreInicialization;

import CoreInicialization.AppBuilder;
import CoreInicialization.ProviderInit;
import core.ObservableTS;
import core.TSProvider;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class ObservableTSInit {
	private final String DEFAULT_PLUGIN_PATH = "plugins";
	private static final String DEFAULT_PLUGIN_ELEGIDO = "DefaultPlugin";
	private final ProviderInit inicializador;
	private AppBuilder app;

	public ObservableTSInit(){
		this.app = new AppBuilder();
		inicializador = new ProviderInit();
	}
	public ObservableTS init(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		//args = {repo, US, PluginElegido, pluginsPath
		String repo = args[0];
		String userStory = args[1];
		String pluginElegido = args.length<3 ? DEFAULT_PLUGIN_ELEGIDO : args[2];
		String pluginPath = args.length<4 ? DEFAULT_PLUGIN_PATH : args[3];

		TSProvider plugin = inicializador.init(pluginPath, pluginElegido);

		ObservableTS ret = this.app.build(plugin, userStory);
		return ret;
	}
}
