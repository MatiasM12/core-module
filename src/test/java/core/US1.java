package core;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class US1 {
	
    
	/*Inicializaciones*/
    private  CoreInit init;
  
    private  ObservableTestSummary testSummary;
    
    /*Paths y implementaciones de tracker*/
    private  String findersImplPath = "C:\\Users\\Nicol\\git\\core-module12\\bin\\main\\core";
    private  String trackerImp = "TrackerHub";
    private  String trackerImp1 = "trackers.TrackerTestSummary";
    private  String url = "www.github.com";
   
    @BeforeAll
    public void escenario1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException  {
    	init = new CoreInit();
    	testSummary =(ObservableTestSummary)init.init("C:\\Users\\Nicol\\git\\core-module12\\bin\\main\\trackers", "trackers.TrackerTestSummary");
    	System.out.println(testSummary);
    
    }
    @Test 
    public void nullTestSummary(){
    	assertTrue(testSummary!=null);
    }
    @Test 
    public void addTest(){
    	
    }
    
    @Test 
    public void changeOfState() {
    	
    
    }
    @Test 
    public void noChanges()  {
    	
    }
    
    @Test 
    public void usChanged()  {
    		
    }
    
    @Test 
    public void usResultChanged()  {
    		
    }
    
    
    @Test 
    public void noUS()  {
    	
    }
    
    @Test 
    public void oneUS() {
    	
    }

    
}
