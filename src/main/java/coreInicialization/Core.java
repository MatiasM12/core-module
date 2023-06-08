package coreInicialization;

import core.ObservableTS;
import Interfaces.Observable;
import Interfaces.OriginTS;
import Interfaces.TestSummary;
import breaker.CBOrigin;
import breaker.Response;
import core.TSNameExtractor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Core {

	private CBOrigin origin;
	private String[] args;
	private OriginTSFactory otsFactory;
	private ObservableTSFactory obstsFactory;
	private TSNameExtractor extractor;
	private PropertiesLoader propertiesLoader;

	public Core() {
		this.obstsFactory = new ObservableTSFactory();
		this.extractor = new TSNameExtractor();
		this.propertiesLoader = new PropertiesLoader();
		this.origin = new CBOrigin();
	}

	public Observable init(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
		// args = {repo, US, PluginElegido, pluginsPath
		propertiesLoader.loadDefaultProperties("defaultArgs.properties");
		this.args = args;
		String repo = args[0];
		String userStory = args[1];
		String pluginElegido = args.length < 3 ? propertiesLoader.getDefaultPlugin() : args[2];
		String pluginPath = args.length < 4 ? propertiesLoader.getDefaultPluginPath() : args[3];
		this.otsFactory = new OriginTSFactory(pluginPath);
		ObservableTS ret = this.obstsFactory.create();
		this.initImplementation(pluginElegido, repo, userStory);
		return ret;
	}

	public String[] getImplementationNames() {
		return extractor.extractNames(this.otsFactory.getSet());
	}

	public Response initImplementation(String pluginElegido, String repo, String us) throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException,IllegalAccessException, NoSuchMethodException {
		String pluginPath = this.args.length < 4 ? propertiesLoader.getDefaultPluginPath() : this.args[3];
		TestSummary plugin = otsFactory.init(repo, us, pluginElegido, this.obstsFactory.getTs());
		return this.origin.makeRequest((OriginTS) plugin, repo, us);

	}

	public String getConnectionState() {
		return "";

	}

	public Integer amountOfRetrys() {
		// TODO Auto-generated method stub
		return null;
	}

	public void retry(String url, String us) {
		// TODO Auto-generated method stub

	}

}
