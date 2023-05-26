package core;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class InitProviderTS {
	static final String DEFAULT_PLUGIN_PATH = "plugins"; 
	private TSFinder finder;
	private Set<TestSummary> ts;
	private TSObtainer ob;
	/**
	 * suponemos que en args [0] SERA IDENTIFICADOR DE UNA USER ,POR EJEMPLO  "US1"
	 * suponemos que si existe  args [1] esta la ruta donde se busca los plugins
	 * @param args
	 * @return
	 * @throws FileNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public ProviderTS init(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException  {
		String pluginPath = DEFAULT_PLUGIN_PATH;
		if(args.length>1)
			pluginPath = args[1];
		
		setFinder();
		searchPlugin(pluginPath);
		setObtainer();
		TestSummary ts = getTestSummaryPlugin();
		ObservableTestSummary ob = new ObservableTestSummary(ts);
		ProviderTS provider = new ProviderTS(ob);
		
		return provider;
	}
	
	private void setFinder() {
		this.finder = new TSFinder();
	}
	
	private void setObtainer() {
		this.ob = new TSObtainer();
	}
	
	private void searchPlugin(String arg) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		this.ts = this.finder.find(arg);
	}
	
	private TestSummary getTestSummaryPlugin() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		return this.ob.getOneFactory(ts);
	}
	
}
	