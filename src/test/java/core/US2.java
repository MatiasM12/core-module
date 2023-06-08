package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Interfaces.TestSummary;
import coreInicialization.OriginFinder;
import mocks.TSVacio;

public class US2 {

	private static String INVALID_PATH, NON_EXISTENT_PATH, EMPTY_DIRECTORY, NOT_A_SOURCE, ONE_SOURCE, MULTIPLE_SOURCES,
			SPECIFIC_PROVIDER;
	private static OriginFinder finder;

	@BeforeAll
	public static void escenario() {
		INVALID_PATH = "archivo.txt";
		NON_EXISTENT_PATH = "src/unaCarpetaInexistente";
		EMPTY_DIRECTORY = "src/test/java/directoriesMock/carpetaVacia/";
		NOT_A_SOURCE = "src/test/java/directoriesMock/noEsFuente/";
		ONE_SOURCE = "src/test/java/directoriesMock/fuenteSimple/";
		MULTIPLE_SOURCES = "src/test/java/directoriesMock/multiplesFuentes/";
		SPECIFIC_PROVIDER = "DefaultTS";
	}

	@Test
	public void CA1() {
		finder = new OriginFinder(NON_EXISTENT_PATH);
		assertThrows(FileNotFoundException.class, () -> finder.find(new TSVacio()));
	}

	@Test
	public void CA2() {
		finder = new OriginFinder(INVALID_PATH);
		assertThrows(FileNotFoundException.class, () -> finder.find(new TSVacio()));
	}

	@Test
	public void CA3() throws FileNotFoundException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		finder = new OriginFinder(EMPTY_DIRECTORY);
		assertTrue(finder.find(new TSVacio()).isEmpty());
	}

	@Test
	public void CA4() throws FileNotFoundException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		finder = new OriginFinder(NOT_A_SOURCE);
		assertTrue(finder.find(new TSVacio()).isEmpty());
	}

	@Test
	public void CA5() throws FileNotFoundException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		finder = new OriginFinder(ONE_SOURCE);
		Set<TestSummary> setTS = finder.find(new TSVacio());
		assertEquals(1, setTS.size());
	}

	@Test
	public void CA6() throws FileNotFoundException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		finder = new OriginFinder(MULTIPLE_SOURCES);
		Set<TestSummary> setTS = finder.find(new TSVacio());
		assertTrue(setTS.size() >= 2);
	}

	@Test
	public void CA7() throws FileNotFoundException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		finder = new OriginFinder(ONE_SOURCE);
		Set<TestSummary> setTS = finder.find(new TSVacio());
		assertTrue(setTS.stream().anyMatch(t -> t.getClass().getName().equals(SPECIFIC_PROVIDER)));
	}
}