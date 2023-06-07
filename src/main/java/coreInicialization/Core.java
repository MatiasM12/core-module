package coreInicialization;

import core.ObservableTS;
import Interfaces.Observable;
import Interfaces.TestSummary;
import breaker.CBOrigin;
import core.TSNameExtractor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

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
	}

	public Observable init(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
		//args = {repo, US, PluginElegido, pluginsPath
		propertiesLoader.loadDefaultProperties("defaultArgs.properties");
		this.args = args;
		String repo = args[0];
		String userStory = args[1];
		String pluginElegido = args.length<3 ? propertiesLoader.getDefaultPlugin() : args[2];
		String pluginPath = args.length<4 ? propertiesLoader.getDefaultPluginPath() : args[3];
		
		ObservableTS ret = this.obstsFactory.create();
		this.otsFactory = new OriginTSFactory(pluginPath);
		otsFactory.init(repo,userStory,pluginElegido,ret);
		return ret;
	}


	public String[] getImplementationNames(){
		return extractor.extractNames(this.otsFactory.getSet());
	}
	
	public boolean changeImplementation(String pluginElegido) {
		String pluginPath = this.args.length<4 ? propertiesLoader.getDefaultPluginPath() : this.args[3];
		boolean ret;
		try {
			TestSummary plugin = otsFactory.init(this.args[0], this.args[1], pluginElegido, this.obstsFactory.getTs());
			ret = true;
		}
		catch(Exception e){
			e.printStackTrace();
			ret = false;
		}
		return ret;
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
