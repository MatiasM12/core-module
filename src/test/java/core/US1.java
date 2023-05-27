package core;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class US1 {

	private static Provider provider;
	private static Map<String, Boolean> test;
	private static Map<String, Boolean> emptyTest;
	
	@BeforeAll
	static void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		String[] values = {"US1","www.github.com/proyecto1/US1/"};
		provider = new InitProvider().init(values);
    	test = createInitTests();
    	emptyTest = createEmptyTest();
    	provider.update(test);
	}


	@Test
	void seAgregaUnTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		int oldTestsQuantity = test.size();
		AddOneTest();
		provider.update(test);
		assertEquals(provider.getMap().size(),oldTestsQuantity + 1);
	}
	
	@Test
	void seBorraUnTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		int oldTestsQuantity = test.size();
		removeOneTest();
		provider.update(test);
		assertEquals(provider.getMap().size(),oldTestsQuantity - 1);
	}
	
	@Test
	void CambiaEstadoDeTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		Boolean oldStatus = provider.getMap().get("CA1");
		changeStatusTest();
		provider.update(test);
		assertNotEquals(provider.getMap().get("CA1"),oldStatus);
	}
	
	@Test
	void sinTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		provider.update(emptyTest);
		assertEquals(provider.getMap().size(),0);
	}
	
	@Test
	void cambiaElTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		Map<String,Boolean> repoUpdate = new HashMap<String,Boolean>();
		provider.update(repoUpdate);
		assertEquals(provider.getMap().size(),0);
	}
	
	
	//Funciones auxiliares
	public static Map<String, Boolean> createInitTests() {
		Map<String,Boolean>  map = new HashMap<String,Boolean>();
    	map.put("CA1", true);
		return map;
	}
	
	public static void AddOneTest() {
		test.put("CA2", true);
	}

	private static void removeOneTest() {
		test.remove("CA2");
	}
	
	private static void changeStatusTest() {
		test.put("CA1", false);
	}
	
	private static Map<String, Boolean> createEmptyTest() {
		return new HashMap<String, Boolean>();
	}

}
