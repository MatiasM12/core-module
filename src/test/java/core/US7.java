package core;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;
import coreInicialization.Core;
import mocks.ObAT;

class US7 {

	public static Core c;
	public static TestSummary ts;
	public static Observer o;

	@BeforeAll
	public static void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException, IOException {
		String us = "US1";
		String url = "\"www.github/proyecto1/\"";
		String[] args = new String[] { url, us };
		c = new Core();
		Observable obv = c.init(args);
		o = new ObAT(obv);
		ts = ((ObAT) o).getTS();

	}

	@Test
	void CA1lastTS() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException,
			InstantiationException, IllegalAccessException, NoSuchMethodException {
		assertEquals(c.initImplementation("TSInexistente", "www.github/proyecto1/", "US1").responseMsg, "Fallo en la primera conexión");
		assertEquals(ts.equals(((ObAT) o).getTS()), true);
	}

}
