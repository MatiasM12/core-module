package core;


import coreInicialization.ObservableInit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Imp.ObAT;
import Imp.TSStub;
import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class US1 {

    private static TestSummary ts;

    @BeforeEach
    public void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
    	String path = "C:\\Users\\Nicol\\git\\core-module82\\bin\\test\\Imp";
    	String ImplPlugin = "OriginImp.DefaultTS";
    	String url = "url";
    	String [] args  = new String[] {path,url,ImplPlugin};
    	Observer o = new ObAT();
    	Observable obv=  new  ObservableInit().init(args);
    	obv.addObserver(o);
    	ts = ((ObAT)o).getTS();


    }

	@Test
    void CA1AgregarTest() {
    	Map<String,Boolean> m = new HashMap<String,Boolean>();   //[CA1 : TRUE]
    	m.put("CA1", true);
    	TestSummary newTS= new TSStub("US1",m);
    	assertEquals(((TSStub)ts.update(newTS)).sizeCA() , 1);
    }
	@Test
    void CA2QuitarTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
    	Map<String,Boolean> m = new HashMap<String,Boolean>();   //[CA1 : TRUE]
    	TestSummary newTS= new TSStub("US1",m);
        assertEquals(((TSStub)ts.update(newTS)).sizeCA() , 0);
    }
	@Test
    void CA3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
    	Map<String,Boolean> m0 = new HashMap<String,Boolean>();//[CA1 : TRUE]
    	Map<String,Boolean> m1 = new HashMap<String,Boolean>();//[CA1 : TRUE]
    	m0.put("CA1", true);
    	m1.put("CA1", false);
    	TestSummary nuevoTSTrue   = new TSStub("US1",m0);
        TestSummary nuevoTSFalse  = new TSStub("US1",m1);
        assertEquals(ts.update(nuevoTSTrue).equals(ts.update(nuevoTSFalse)), false);
    }

  
}


