package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
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
    	INVALID_PATH = "archivo.txt";
        NON_EXISTENT_PATH = "/unaCarpetaInexistente";
        EMPTY_DIRECTORY = "carpetaVacia/";
        NOT_A_SOURCE = "noEsFuente/image.gif";
        ONE_SOURCE = "gitlab.class";
        MULTIPLE_SOURCES = "/multiplesFuntes";
    	trackerFinder = new TrackerFinder();
    }

    @Test 
    public void testNonExistentPath() throws FileNotFoundException{
    	assertThrows(FileNotFoundException.class, () -> trackerFinder.findTrackers(NON_EXISTENT_PATH));
    }

    @Test 
    public void testInvalidPath() throws IllegalArgumentException {
    	assertThrows(IllegalArgumentException.class, () -> trackerFinder.findTrackers(INVALID_PATH));
    }
    
    @Test
    public void testEmptyDirectory() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        assertTrue(trackerFinder.findTrackers(EMPTY_DIRECTORY).isEmpty());
    }

    @Test
    public void testNotASource() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        assertTrue(trackerFinder.findTrackers(NOT_A_SOURCE).isEmpty());
    }

    @Test
    public void testOneSource() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Set<Tracker> trackers = trackerFinder.findTrackers(ONE_SOURCE);
        assertEquals(1, trackers.size());
        assertTrue(trackers.contains("gitlab"));
        assertTrue(trackers.stream().anyMatch(t -> t.getClass().getName().equals("gitlab")));
    }

    @Test
    public void testMultipleSources() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Set<Tracker> trackers = trackerFinder.findTrackers(MULTIPLE_SOURCES);
        assertEquals(2, trackers.size());
        assertTrue(trackers.contains("gitlab"));
        assertTrue(trackers.contains("jira"));
    }  
}
