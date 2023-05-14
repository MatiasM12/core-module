package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class US1 {
	
    private static  String INVALID_PATH;
    private static  String NON_EXISTENT_PATH;
    private static  String EMPTY_DIRECTORY;
    private static  String NOT_A_SOURCE ;
    private static  String ONE_SOURCE ;
    private static  String MULTIPLE_SOURCES ;
    private static InitCore init;
    private static String findersImplPath = "C:\\Users\\Nicol\\git\\core-module8\\bin\\main\\trackerImp";
    private static String trackerImp = "trackerImp.TrackerHub";
    private static String url = "www.github.com";
    private static Tracker tr;
    
    @BeforeAll
    public static void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	init = new InitCore(url,findersImplPath);
    	tr = init.init(trackerImp);
    	
    }
 
    @Test 
    public void addTest() throws FileNotFoundException{
    	assertFalse(tr.newChanges().equals(null));
    }
    
    @Test 
    public void changeOfState() throws FileNotFoundException{
    	TestSummary ts1 = tr.newChanges();
    	TestSummary ts2 = tr.newChanges();
    	assertFalse(((ConcreteTestSummary)ts2).equals(((ConcreteTestSummary)ts1)));
    	
    	
    }

    
}
