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
    private static  TrackerFinder trackerFinder;

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
    	trackerFinder = new TrackerFinder(NON_EXISTENT_PATH);
    	assertThrows(FileNotFoundException.class, () -> trackerFinder.initTrackers());
    }

    @Test 
    public void testInvalidPath() throws FileNotFoundException {
    	trackerFinder = new TrackerFinder(INVALID_PATH);
    	assertThrows(FileNotFoundException.class, () -> trackerFinder.initTrackers());
    }
    
    @Test
    public void testEmptyDirectory() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	trackerFinder = new TrackerFinder(EMPTY_DIRECTORY);
    	assertTrue(trackerFinder.initTrackers().isEmpty());
    }

    @Test
    public void testNotASource() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	trackerFinder = new TrackerFinder(NOT_A_SOURCE);
    	assertTrue(trackerFinder.initTrackers().isEmpty());
    }

    @Test
    public void testOneSource() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	trackerFinder = new TrackerFinder(ONE_SOURCE);
    	Set<Tracker> trackers = trackerFinder.initTrackers();System.out.println(trackers);
        assertEquals(1, trackers.size());
        
        assertTrue(trackers.stream().anyMatch(t -> t.getClass().getName().equals("Gitlab")));
    }

    @Test
    public void testMultipleSources() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	trackerFinder = new TrackerFinder(MULTIPLE_SOURCES); 
    	Set<Tracker> trackers = trackerFinder.initTrackers();
        assertEquals(2, trackers.size());
        assertTrue(trackers.stream().anyMatch(t -> t.getClass().getName().equals("Gitlab")));
        assertTrue(trackers.stream().anyMatch(t -> t.getClass().getName().equals("Jira")));
    }  
}