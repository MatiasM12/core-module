package core;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import coreInicialization.Core;

class US6 {

	private static Core c;
	
	@BeforeAll
	public void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
	String [] args = new String[]  {"www.github/proyecto1/","US1","TSConexionExitosa"};
	Core c  = new Core();
	c.init(args);

		
	}
	@Test
	 void closeConnection () throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		assertEquals(c.initImplementation("TSExistente","www.github/proyecto1/","US1").isSuccess(),true);
	}
	@Test
	 void openConnection() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		assertEquals(c.initImplementation("TSExistente","www.github/proyecto1/","US1").isSuccess(),false);
	}
	@Test
	 void halfOpen() {
		
	}
	@Test
	 void halfOpenToOpen() {
		//c.retry("urlNueva","NuevaUS");
		//assertEquals(c.getConnectionState(), "Abierto");
	}
	@Test
	 void halfOpenToClose() {
		//c.retry("urlNueva","NuevaUS");
		//assertEquals(c.getConnectionState(), "Cerrado");
	}
	
	


}
