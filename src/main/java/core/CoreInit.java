package core;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class CoreInit {
	private final PluginProvider provider;
	private final PluginsFinder finder;
	private final String DEFAULT_PLUGIN_PATH = "plugins";
	private static final String DEFAULT_PLUGIN_ELEGIDO = "defaultPlugin";
	public CoreInit(){
		this.provider = new PluginProvider();
		this.finder = new PluginsFinder();
	}
	public ObservableTestSummary init(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		//args = {repo, US, PluginElegido, pluginsPath
		String repo = args[0];
		String userStory = args[1];
		String pluginElegido = args.length<3 ? DEFAULT_PLUGIN_ELEGIDO : args[2];
		String pluginPath = args.length<4 ? DEFAULT_PLUGIN_PATH : args[3];

		Set<Plugin> set = finder.find(pluginPath);
		Plugin plugin1 = this.provider.getOne(set, pluginElegido);

		TestSummary ts = plugin1.getTS(userStory);

		ObservableTestSummary oTS = new ObservableTestSummary(ts);
		return oTS;


//		#Set<Pulgins> set = TestSummaryFactoryFinder.find(path) -> creo que el nombre de esto deberia ser pluginsFinder o algo mas generico ya que el plugin no es un factory si o si.
//		# plugin1 = getOne(set, “plugin1”);
//		# TestSummary ts = plugin1.getTS(“US1”) -> podría ser finder, factory, fetcher o no se como pero consigue el TS.
//		# ObservablTSe tso = new ObservablTS(ts)
//		Lo que esta con # hay que explicarlo en el diseño
	}
}
