package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.util.Set;

import javax.annotation.processing.FilerException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import TrackersMock.TrackerInvalidPath;
import TrackersMock.TrackerNonExistentPath;



public class US2 {
	
    private static final String INVALID_PATH = "archivo.txt";
    private static final String NON_EXISTENT_PATH = "////";
    private static final String EMPTY_DIRECTORY = "carpetaVacia/";
    private static final String NOT_A_SOURCE = "noEsFuente/image.gif";
    private static final String ONE_SOURCE = "gitlab.class";
    private static final String[] MULTIPLE_SOURCES = {"gitlab.class", "jira.class", "image.gif"};
    private static final TrackerNonExistentPath trackerNonExistFile = new TrackerNonExistentPath();
    private static final TrackerInvalidPath trackerInvalidPath = new TrackerInvalidPath();
    

    @Test 
    public void testNonExistentPath() throws FileNotFoundException{
    	assertThrows(FileNotFoundException.class, () -> trackerNonExistFile.find(NON_EXISTENT_PATH));
    }

    @Test 
    public void testInvalidPath() throws IllegalArgumentException {
    	assertThrows(IllegalArgumentException.class, () -> trackerInvalidPath.find(INVALID_PATH));
        
    }
    
    // FIXME: implementar test restantes
    
//    @Test
//    public void testEmptyDirectory() throws FileNotFoundException {
//        assertTrue(Tracker.find(EMPTY_DIRECTORY).isEmpty());
//    }
//
//    @Test
//    public void testNotASource() throws FileNotFoundException {
//        assertTrue(Tracker.find(NOT_A_SOURCE).isEmpty());
//    }
//
//    @Test
//    public void testOneSource() throws FileNotFoundException {
//        Set<Tracker> trackers = Tracker.find(ONE_SOURCE);
//        assertEquals(1, trackers.size());
//        assertTrue(trackers.contains("gitlab"));
//        assertTrue(trackers.stream().anyMatch(t -> t.name().equals("gitlab")));
//    }
//
//    @Test
//    public void testMultipleSources() throws FileNotFoundException {
//        Set<Tracker> trackers = Tracker.find(MULTIPLE_SOURCES);
//        assertEquals(2, trackers.size());
//        assertTrue(trackers.contains("gitlab"));
//        assertTrue(trackers.contains("jira"));
//    }  
}
