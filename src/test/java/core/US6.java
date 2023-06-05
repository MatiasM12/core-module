package core;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import coreInicialization.Core;

class US6 {

	private static Core c;
	
	@BeforeAll
	public void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		String path = "plugin";
		String Imp = "TSConnectionPositive";
		String url = "url";
		String us = "US1";
		String [] args  = new String [] {Imp,url,us,path};
		c  = new Core();
		c.init(args);
		
	}
	@Test
	 void closeConnection () {
		assertEquals(c.getConnectionState(),"Cerrado");
	}
	@Test
	 void openConnection() {
		assertEquals(c.getConnectionState(),"Abierto");
	}
	@Test
	 void halfOpen() {
		assertEquals(c.amountOfRetrys(), 5);
		assertEquals(c.getConnectionState(), "Abierto");
	}
	@Test
	 void halfOpenToOpen() {
		c.retry("urlNueva","NuevaUS");
		assertEquals(c.getConnectionState(), "Abierto");
	}
	@Test
	 void halfOpenToClose() {
		c.retry("urlNueva","NuevaUS");
		assertEquals(c.getConnectionState(), "Cerrado");
	}
	
	


}
