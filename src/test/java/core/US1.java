package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class US1 {
	
    
	/*Inicializaciones*/
    private static InitCore init;
    private static InitCore init1;
    private static InitCore init2;
    private static InitCore init3;
    private static Tracker tr;
    private static Tracker tr1;
    private static Tracker tr2;
    private static Tracker tr3;
    
    /*Paths y implementaciones de tracker*/
    private static String findersImplPath = "C:\\Users\\Nicol\\git\\core-module8\\bin\\main\\trackerImp";
    private static String trackerImp = "trackerImp.TrackerHub";
    private static String trackerImp2 = "trackerImp.TrackerTestIguales";
    private static String trackerImp3 = "trackerImp.TrackerUSChanged";
    private static String trackerImp4 = "trackerImp.TrackerSinUS";
    private static String url = "www.github.com";
   
    @BeforeAll
    public static void escenario1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	init = new InitCore(url,findersImplPath);
    	tr = init.init(trackerImp);	
    }
    
    @BeforeAll
    public static void escenario2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	init1 = new InitCore(url,findersImplPath);
    	tr1 = init.init(trackerImp2);	
    }
    @BeforeAll
    public static void escenario3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	init2 = new InitCore(url,findersImplPath);
    	tr2 = init.init(trackerImp3);	
    }
    
    @BeforeAll
    public static void escenario4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	init3 = new InitCore(url,findersImplPath);
    	tr3 = init.init(trackerImp4);	
    }
    
    
    
    @Test 
    public void addTest(){
    	assertFalse(tr.newChanges().equals(null));
    }
    
    @Test 
    public void changeOfState() throws FileNotFoundException{
    	Map<String,String> ts1 = ((ConcreteTestSummary)tr.newChanges()).usAcceptanceTest;
    	Map<String,String> ts2 = ((ConcreteTestSummary)tr.newChanges()).usAcceptanceTest;
    	
    	System.out.println(ts1.toString());
    	System.out.println(ts2.toString());
    	
    	assertFalse((ts1).equals(ts2));	
    }
    @Test 
    public void noChanges() throws FileNotFoundException{
    	Map<String,String> ts1 = ((ConcreteTestSummary)tr1.newChanges()).usAcceptanceTest;
    	Map<String,String> ts2 = ((ConcreteTestSummary)tr1.newChanges()).usAcceptanceTest;
    	assertTrue((ts1).equals(ts2));	
    }
    
    @Test 
    public void usChanged() throws FileNotFoundException{
    	Map<String,String> ts1 = ((ConcreteTestSummary)tr2.newChanges()).usAcceptanceTest;
    	Map<String,String> ts2 = ((ConcreteTestSummary)tr2.newChanges()).usAcceptanceTest;
    	String key1 = (String)(ts1.keySet().toArray()[0]);
    	String key2 = (String)(ts2.keySet().toArray()[0]);
    	assertFalse(key1.equals(key2));	
    }
    
    @Test 
    public void usResultChanged() throws FileNotFoundException{
    	Map<String,String> ts1 = ((ConcreteTestSummary)tr2.newChanges()).usAcceptanceTest;
    	Map<String,String> ts2 = ((ConcreteTestSummary)tr2.newChanges()).usAcceptanceTest;
    	
    	System.out.println(ts1.get("US2"));
    	System.out.println(ts2.get("US2"));
    	
    	assertFalse(ts1.get("US2").equals(ts2.get("US2")));	
    }
    
    
    @Test 
    public void noUS() throws FileNotFoundException{
    	Map<String,String> ts1 = ((ConcreteTestSummary)tr3.newChanges()).usAcceptanceTest;  	    	
    	assertTrue(ts1.size()==0);
    }

    
}
