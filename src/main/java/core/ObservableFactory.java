package core;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ObservableFactory {
	static final String DEFAULT_PLUGIN_PATH = "plugins"; 

	
	
	private TestSummary decorador;
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
	public Observable createObservable(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException  {
		String pluginPath = DEFAULT_PLUGIN_PATH;
		if(args.length>1)
			pluginPath = args[1];
		TestSummaryFactoriesFinder tSFFinder = new TestSummaryFactoriesFinder();
		Set<Factory> tsFactories = tSFFinder.find(pluginPath);
		FactoryObtainer factoryObtainer = new FactoryObtainer(); 
		
		if(tsFactories.isEmpty())throw new RuntimeException("No se encontro la impl");
		
		if(tsFactories.size()>1) System.err.println("Se encontro mas de un plugin, se usara el primero");
		
		Factory f = factoryObtainer.getOneFactory(tsFactories);
		Observable ob = f.createObservableTS(args[0]);
		decorador = f.getTSDecorator();
		return  ob;		
	}
	
	public TestSummary getDecorador() {
		return this.decorador;
	}
	
   }
	