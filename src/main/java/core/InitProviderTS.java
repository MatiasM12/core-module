package core;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class InitProviderTS {
	
	static final String DEFAULT_PLUGIN_PATH = "plugins"; 
	private FactoryFinder factoryFinder;
	private Set<Factory> factories;
	private FactoryObtainer factoryObtainer; 
	
	public InitProviderTS() {
		setFactoryFinder();
		setFactoryObtainer();	
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
		findFactories(pluginPath);
		
		TestSummary ts = new ConcreteTestSummary();
		TestSummary tsPlugin = getFactory().createTS(ts,args[0],args[1]);
		ObservableTestSummary ob = new ObservableTestSummary(ts);
		
		return new Provider(ob,tsPlugin);
	}
	
	private void setFactoryFinder() {
		this.factoryFinder = new FactoryFinder();
	}
	
	private void setFactoryObtainer() {
		this.factoryObtainer = new FactoryObtainer();
	}
	
	private void findFactories(String arg) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		this.factories = this.factoryFinder.find(arg);
	}
	
	private Factory getFactory() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		return this.factoryObtainer.getOneFactory(factories);
	}
	
}
	