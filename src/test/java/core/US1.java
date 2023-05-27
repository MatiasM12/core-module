package core;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class US1 {

	private static InitProviderTS init;
	private  static Provider provider;
	
	@BeforeAll
	static void escenario1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		init = new InitProviderTS();
		String[] values = new String[] {"US1","www.github.com/proyecto1/US1/"};
		provider =init.init(values);
		System.out.println(provider.getMap());
    	Map<String,Boolean>  map = new HashMap<String,Boolean>();
    	map.put("CA1", true);
    	provider.update(map);
    	System.out.println(provider.getMap().toString());
    	
  
	}
	
	@Test
	void seAgregaUnTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
	//	init = new CoreInit();
    //	testSummary =(ObservableTestSummary)init.init("plugins", "trackers.TrackerTestSummary");
		Map<String,Boolean> repoUpdate =  new HashMap<String,Boolean>();
		repoUpdate.put("CA1", true);
		repoUpdate.put("CA2", true);
		provider.update(repoUpdate);
		assertEquals(provider.getMap().size(),2);
	}
	
	
	@Test
	void CambiaEstadoDeTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		Boolean estadoAnterior = provider.getMap().get("CA1");
		Map<String,Boolean> repoUpdate =  new HashMap<String,Boolean>();
		repoUpdate.put("CA1", false);
		provider.update(repoUpdate);
		assertNotEquals(provider.getMap().get("CA1"),estadoAnterior);
	}
	
	
	@Test
	void seBorraUnTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		int tamañoAnterior = provider.getMap().size();
		Map<String,Boolean> repoUpdate = new HashMap<String,Boolean>();
		repoUpdate.put("CA1", false);
		provider.update(repoUpdate);
		assertEquals(provider.getMap().size(),tamañoAnterior-1);
}
	
	@Test
	void sinTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		Map<String,Boolean> repoUpdate =  new HashMap<String,Boolean>();
		provider.update(repoUpdate);
		assertEquals(provider.getMap().size(),0);
}
	

	@Test
	void cambiaElTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		Map<String,Boolean> repoUpdate = new HashMap<String,Boolean>();
		provider.update(repoUpdate);
		assertEquals(provider.getMap().size(),0);
}
	
	
	
	

}
