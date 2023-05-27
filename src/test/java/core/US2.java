package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class US2 {
	
    private static  String INVALID_PATH;
    private static  String NON_EXISTENT_PATH;
    private static  String EMPTY_DIRECTORY;
    private static  String NOT_A_SOURCE ;
    private static  String ONE_SOURCE ;
    private static  String MULTIPLE_SOURCES ;
    private static  FactoryFinder factoryFinder;

    @BeforeAll
    public static void escenario() {
    	INVALID_PATH = "\\n";
        NON_EXISTENT_PATH = "src/unaCarpetaInexistente";
        EMPTY_DIRECTORY = "src/test/java/directoriesMock/carpetaVacia/";
        NOT_A_SOURCE = "src/test/java/directoriesMock/noEsFuente/";
        ONE_SOURCE = "src/test/java/directoriesMock/fuenteSimple/";
        MULTIPLE_SOURCES = "src/test/java/directoriesMock/multiplesFuentes/";
    }
 
    @Test 
    public void testNonExistentPath() throws FileNotFoundException{
    	factoryFinder = new FactoryFinder(); //NON_EXISTENT_PATH
    	assertThrows(FileNotFoundException.class, () -> factoryFinder.find(NON_EXISTENT_PATH));
    }

    @Test 
    public void testInvalidPath() throws FileNotFoundException {
    	factoryFinder = new FactoryFinder(); //INVALID_PATH
    	assertThrows(FileNotFoundException.class, () -> factoryFinder.find(INVALID_PATH));
    }
    
    @Test
    public void testEmptyDirectory() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	factoryFinder = new FactoryFinder();  //EMPTY_DIRECTORY
    	assertTrue(factoryFinder.find(EMPTY_DIRECTORY).isEmpty());
    }

    @Test
    public void testNotASource() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	factoryFinder = new FactoryFinder();   //NOT_A_SOURCE
    	assertTrue(factoryFinder.find(NOT_A_SOURCE).isEmpty());
    }

    @Test
    public void testOneSource() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	factoryFinder = new FactoryFinder();  //ONE_SOURCE
    	Set<Factory> factory = factoryFinder.find(ONE_SOURCE);
        assertEquals(1, factory.size());
        assertTrue(factory.stream().anyMatch(t -> t.getClass().getName().equals("Factory.FactoryGithub")));
    }

    @Test
    public void testMultipleSources() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	factoryFinder = new FactoryFinder();  //MULTIPLE_SOURCES
    	Set<Factory> trackers = factoryFinder.find(MULTIPLE_SOURCES);
        assertEquals(3, trackers.size());
        assertTrue(trackers.stream().anyMatch(t -> t.getClass().getName().equals("Factory.FactoryGithub")));
        assertTrue(trackers.stream().anyMatch(t -> t.getClass().getName().equals("Factory.FactoryGitlab")));
    }  
}