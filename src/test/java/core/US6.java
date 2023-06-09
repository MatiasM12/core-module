package core;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import coreInicialization.Core;

class US6 {

	public static Core c;

	@BeforeAll
	public static void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException, IOException {
		String us = "US1";
		String url = "\"www.github/proyecto1/\"";
		String[] args = new String[] { url, us };
		c = new Core();
		c.init(args);
	}

	@Test
	void closeConnection() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException,
			InstantiationException, IllegalAccessException, NoSuchMethodException {
		assertEquals(c.initImplementation("TSExistente", "www.github/proyecto1/", "US1").isSuccess(), true);
	}

	@Test
	void openConnection() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException,
			InstantiationException, IllegalAccessException, NoSuchMethodException {
		assertEquals(c.initImplementation("TSInexistente", "www.github/proyecto1/", "US1").isSuccess(), false);
	}

}