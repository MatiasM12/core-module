package coreInicialization;

import core.ObservableTS;
import Interfaces.Observable;
import Interfaces.TestSummary;
import breaker.CBOrigin;
import core.TSNameExtractor;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class Core {
	
	private CBOrigin origin;
	private final String DEFAULT_PLUGIN_PATH = "plugins";
	private static final String DEFAULT_PLUGIN_ELEGIDO = "DefaultTS";
	private String[] args;
	private OriginTSFactory otsFactory;
	private ObservableTSFactory obstsfactory;
	public Observable init(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		//args = {repo, US, PluginElegido, pluginsPath
		this.args = args;
		String repo = args[0];
		String userStory = args[1];
		String pluginElegido = args.length<3 ? DEFAULT_PLUGIN_ELEGIDO : args[2];
		String pluginPath = args.length<4 ? DEFAULT_PLUGIN_PATH : args[3];
		this.obstsfactory = new ObservableTSFactory();
		ObservableTS ret = this.obstsfactory.create();
		this.otsFactory = new OriginTSFactory(pluginPath);
		TestSummary plugin = otsFactory.init(repo,userStory,pluginElegido,ret);
		return ret;
	}
	
	
	public String[] getImplementationNames(){
		TSNameExtractor extractor = new TSNameExtractor();
		return extractor.extractNames(this.otsFactory.getSet());
	}
	public boolean changeImplementation(String pluginElegido) {
		String pluginPath = this.args.length<4 ? DEFAULT_PLUGIN_PATH : this.args[3];
		boolean ret;
		try {
			TestSummary plugin = otsFactory.init(this.args[0], this.args[1], pluginElegido, this.obstsfactory.getTs());
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
