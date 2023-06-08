package core;

import coreInicialization.Core;
import mocks.ObAT;
import mocks.TSStub;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class US4 {
    static String[] implementations1;
    static Core coreOK;

    @BeforeEach
    public void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
        String path = "src/test/java/directoriesMock/multiplesFuentes";
        String Imp = "DefaultTS";
        String url = "url";
        String us = "US1";
        String [] args  = new String [] {url,us,Imp,path};
       // Core c  = new Core();
        coreOK = new Core();
        coreOK.init(args);
        implementations1 = coreOK.getImplementationNames();  //TSBadge,TSCA
    }

    @Test
    public void CA1(){
    	assertEquals(implementations1.length , 3);
    }
    @Test
    public void CA2() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException{
    	assertEquals(coreOK.initImplementation("TSExistente","www.github/proyecto1/","US1").isSuccess(),true);
    	

    }
    @Test
    public void CA3() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException{
    	
    	assertEquals(coreOK.initImplementation("TSInexistente","www.github/proyecto1/","US1").isSuccess(),false);
    	
  

    }
}
