package core;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import breaker.Response;
import coreInicialization.Core;

class US6 {

	public static Core c;
	public static Response resultConnection;

	@BeforeAll
	public static void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException, IOException {
		String us = "US1";
		String url = "\"www.github/proyecto1/\"";
		String[] args = new String[] { url, us };
		c = new Core();
		c.init(args);
		resultConnection = c.selectImplementation("TSInexistente", url, us);
	}
	
	//Primer conexión fallida
	@Test
	void CA1firstConnection() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException,
			InstantiationException, IllegalAccessException, NoSuchMethodException {
		assertEquals(resultConnection.responseMsg, "Fallo en la primera conexión");
	}
	
	//Reintento de conexión
	@Test
	void CA2Reconnection() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException,
			InstantiationException, IllegalAccessException, NoSuchMethodException {
		assertEquals(c.selectImplementation("TSInexistente", "www.github/proyecto1/", "US1").responseMsg, "Fallo en el reintento de conexión");
	}
	

}
