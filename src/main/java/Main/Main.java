package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import core.*;
import core.Observable;

public class Main {
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		TestPublisher model = new TestPublisher();
		new Vista(nodel);
		model.getAvailablePlugins();
		//////usuario: selecciona un scrapper y setea el endpoint en si repositorio o issue tracker
		model.start("scrapper","US");


//		PluginFinderInit inicializador = new PluginFinderInit();
//		System.out.println(System.getProperty("user.dir"));
//		File f = new File("./plugins");
//		Set<TSManager> pluginsDisponibles = inicializador.init("./plugins");
//		//estos plugins se disponibilizan en la ui para ser seleccionados
//
//		//Desde un boton en la ui se ejecuta lo siguiente partiendo del plugin disponible
//		AppBuilder modelo = new AppBuilder();
//		Observable oble = modelo.build(getOne(pluginsDisponibles), "User Story 1", "www.unlinkvalidio.com");
//		Vista v = new Vista();
//		oble.addObserver(v);
//	}

	public static TSManager getOne(Set<TSManager> set){
		Iterator<TSManager> iterator = set.iterator();
		if (iterator.hasNext()){
			TSManager builder = iterator.next();
			return builder;
		}
		return null;
	}
}
