package core;

import coreInicialization.Core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class US4 {
	static String[] implementations1;
	static Core coreOK;

	@BeforeEach
	public void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException, IOException {
		String us = "US1";
		String url = "url";
		String[] args = new String[] { url, us };
		coreOK = new Core();
		coreOK.init(args);
		implementations1 = coreOK.getImplementationNames(); // TSBadge,TSCA
	}

	@Test
	public void CA1ObtenerImplementacion() {
		assertEquals(implementations1.length, 4);
	}

	@Test
	public void CA2ElegirImplementacion() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException,
			InstantiationException, IllegalAccessException, NoSuchMethodException {
		assertEquals(coreOK.selectImplementation("TSExistente", "www.github/proyecto1/", "US1").responseMsg,"Conexión Exitosa");
	}

	@Test
	public void CA3ElegirYFallo() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException,
			InstantiationException, IllegalAccessException, NoSuchMethodException {
		assertEquals(coreOK.selectImplementation("TSInexistente", "www.github/proyecto1/", "US1").responseMsg, "Fallo en la primera conexión");
	}
}
