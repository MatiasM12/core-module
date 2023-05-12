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
  /*  private static  TrackerFinder trackerFinder;

    @BeforeAll
    public static void escenario() {
    	INVALID_PATH = "\\n";
        NON_EXISTENT_PATH = "/unaCarpetaInexistente";
        EMPTY_DIRECTORY = "src/test/java/MockDirectories/carpetaVacia/";
        NOT_A_SOURCE = "src/test/java/MockDirectories/noEsFuente/image.gif";
        ONE_SOURCE = "src/test/java/MockDirectories/unaFuente";
        MULTIPLE_SOURCES = "src/test/java/MockDirectories/multiplesFuentes";
    	trackerFinder = new TrackerFinder();
    }
 
    @Test 
    public void testNonExistentPath() throws FileNotFoundException{
    	assertThrows(FileNotFoundException.class, () -> trackerFinder.findTrackers(NON_EXISTENT_PATH));
    }

    @Test 
    public void testInvalidPath() throws FileNotFoundException {
    	assertThrows(FileNotFoundException.class, () -> trackerFinder.findTrackers(INVALID_PATH));
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
        assertTrue(trackers.stream().anyMatch(t -> t.getClass().getName().equals("Gitlab")));
    }

    @Test
    public void testMultipleSources() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Set<Tracker> trackers = trackerFinder.findTrackers(MULTIPLE_SOURCES);
        assertEquals(2, trackers.size());
        assertTrue(trackers.stream().anyMatch(t -> t.getClass().getName().equals("Gitlab")));
        assertTrue(trackers.stream().anyMatch(t -> t.getClass().getName().equals("Jira")));
    }  */
}
