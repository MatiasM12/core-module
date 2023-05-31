package core;

import Interfaces.TSProvider;
import coreInicialization.OTSBuilder;
import coreInicialization.ProviderInit;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

public class Core {
	private final String DEFAULT_PLUGIN_PATH = "plugins";
	private static final String DEFAULT_PLUGIN_ELEGIDO = "DefaultTSProvider";
	private final ProviderInit inicializador;
	private OTSBuilder app;

	public Core(){
		this.app = new OTSBuilder();
		inicializador = new ProviderInit();
	}
	public ObservableTS init(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException, MalformedURLException {
		//args = {repo, US, PluginElegido, pluginsPath
		String repo = args[0];
		String userStory = args[1];
		String pluginElegido = args.length<3 ? DEFAULT_PLUGIN_ELEGIDO : args[2];
		String pluginPath = args.length<4 ? DEFAULT_PLUGIN_PATH : args[3];
		//todos estos datos van en un properties que me hace un metodo aparte

		//OTSProvider p = new OTSPFinder(PluginPath).find(repo);	v.1
		//ObservableTSFactory p = new ObservableTSFactory(properties)
		//OTestSummary ots = p.create()
		//return ots;

		TSProvider plugin = inicializador.init(pluginPath, pluginElegido);

		ObservableTS ret = this.app.build(plugin, userStory);
		return ret;
	}
}