package core;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class InitProviderTS {
	static final String DEFAULT_PLUGIN_PATH = "plugins"; 
	private TSFinder finder;
	private Set<Factory> ts;
	private FactoryObtainer ob;
	
	public InitProviderTS() {
		setFinder();
		setObtainer();	
	}
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
	public Provider init(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException  {
		String pluginPath = DEFAULT_PLUGIN_PATH;
		if(args.length>2) pluginPath = args[2];
		searchPlugin(pluginPath);
		TestSummary ts = new ConcreteTestSummary();
		TestSummary tsPlugin = getFactory().createTS(ts,args[0],args[1]);
		ObservableTestSummary ob = new ObservableTestSummary(ts);
		return new Provider(ob,tsPlugin);
	}
	
	private void setFinder() {
		this.finder = new TSFinder();
	}
	
	private void setObtainer() {
		this.ob = new FactoryObtainer();
	}
	
	private void searchPlugin(String arg) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		this.ts = this.finder.find(arg);
	}
	
	private Factory getFactory() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		
	
		
		return this.ob.getOneFactory(ts);
	}
	
}
	