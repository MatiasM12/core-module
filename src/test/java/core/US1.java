package core;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class US1 {
	
    
	/*Inicializaciones*/
    private static CoreInit init;
    private static CoreInit init1;
    private static CoreInit init2;
    private static CoreInit init3;
    private static CoreInit init4;
    private static ObservableTestSummary testSummary;
    private static ObservableTestSummary testSummary1;
    private static ObservableTestSummary testSummary2;
    private static ObservableTestSummary testSummary3;
    private static ObservableTestSummary testSummary4;
    
    /*Paths y implementaciones de tracker*/
    private static String findersImplPath = "plugins";
    private static String trackerImp = "TrackerHub";
    private static String trackerImp1 = "TrackerTestIguales";
    private static String trackerImp2 = "TrackerUSChanged";
    private static String trackerImp3 = "TrackerSinUS";
    private static String trackerImp4 = "TrackerSinUS";
    private static String trackerImp5 = "TrackerSinUS";
    private static String url = "www.github.com";
   
    @BeforeAll
    public static void escenario1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
    	init = new CoreInit();
    	testSummary = (ObservableTestSummary)init.init(trackerImp,findersImplPath);	
    }
    @BeforeAll
    public static void escenario2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
    	init1 = new CoreInit();
    	testSummary1 =(ObservableTestSummary)init1.init(trackerImp1,findersImplPath);	
    }
    @BeforeAll
    public static void escenario3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
    	init2 = new CoreInit();
    	testSummary2 = (ObservableTestSummary)init2.init(trackerImp1,findersImplPath);	
    }
    @BeforeAll
    public static void escenario4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
    	init3 = new CoreInit();
    	testSummary3 = (ObservableTestSummary)init3.init(trackerImp1,findersImplPath);
    }
    @Test 
    public void addTest(){
    	Map<String,String> m = new HashMap<String,String>();
    	m.put("CA1", "PASS");
    	testSummary.update(m);
    	//assertTrue(testSummary.getTestSummary().equals(m));
    	
    }
    
    @Test 
    public void changeOfState() throws FileNotFoundException{
    	
    	Map<String,String> m = new HashMap<String,String>();
    	m.put("CA1", "PASS");
    	testSummary.update(m);
    	
    	Map<String,String> m1 = new HashMap<String,String>();
    	m.put("CA1", "ERROR");
    	testSummary.update(m);
    
    }
    @Test 
    public void noChanges() throws FileNotFoundException{
    	
    }
    
    @Test 
    public void usChanged() throws FileNotFoundException{
    		
    }
    
    @Test 
    public void usResultChanged() throws FileNotFoundException{
    		
    }
    
    
    @Test 
    public void noUS() throws FileNotFoundException{
    	
    }
    
    @Test 
    public void oneUS() throws FileNotFoundException{
    	
    }

    
}
