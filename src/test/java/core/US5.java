package core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;
import coreInicialization.Core;
import mocks.ObAT;
import mocks.TSWithCategories;

public class US5 {
	
	private static TestSummary ts;
	
    @BeforeEach
    public void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
    	String path = "plugins";
    	String ImplPlugin = "DefaultTS";
    	String url = "url";
    	String [] args  = new String[] {path,url,ImplPlugin};
    	Observer o = new ObAT();
    	Observable observableTS = new Core().init(args);
    	observableTS.addObserver(o);
    	ts = ((ObAT)o).getTS();
    }

    @Test
    public void CA1(){
    	TSWithCategories newTS = createTS("CA1" , "Seguridad");
    	
    	assertEquals(((TSWithCategories)ts.update(newTS)).getCategories().size() , 1);
    	assertEquals(((TSWithCategories)ts.update(newTS)).getCategories().get("CA1") , "Seguridad");
    }
    
    @Test
    public void CA2(){
    	TSWithCategories newTS = createTS("CA1" , null);
    	
    	assertEquals(((TSWithCategories)ts.update(newTS)).getCategories().size() , 0);
    	assertEquals(((TSWithCategories)ts.update(newTS)).getCategories().get("CA1") , null);
    }
    
    @Test
    public void CA3(){
    	TSWithCategories newTS = createTS("CA1" , "Seguridad");
    	newTS.caCategories = createCategories("CA1" , "Accesibilidad");
    	
    	assertEquals(((TSWithCategories)ts.update(newTS)).getCategories().size() , 1);
    	assertEquals(((TSWithCategories)ts.update(newTS)).getCategories().get("CA1") , "Accesibilidad");
    }
    
	private Map<String, Boolean> createMap(String ca, boolean status) {
		Map<String,Boolean> m = new HashMap<String,Boolean>();   
    	m.put(ca, status);
		return m;
	}
	
	private Map<String, String> createCategories(String ca, String category) {
		Map<String,String> m = new HashMap<String,String>();   
    	if(category != null) m.put(ca, category);
		return m;
	}
  
	private TSWithCategories createTS(String ca, String category) {
		Map<String,Boolean> m = createMap(ca, true);
    	Map<String,String> m2 = createCategories(ca, category);
		return new TSWithCategories("US1",m,m2);
	}
}
