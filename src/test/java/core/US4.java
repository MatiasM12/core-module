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
    static String[] implementations2;
    static Core coreOK;

    @BeforeEach
    public void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
        String path = "src\\test\\java\\directoriesMock\\multiplesFuentes";
        String Imp = "DefaultTS";
        String url = "url";
        String us = "US1";
        String [] args  = new String [] {path,Imp,url,us};
        Observer obs  = new Observer() {
            @Override
            public void update(TestSummary ts) {

            }
        };
        Core c  = new Core();
        Core coreOK = new Core();
        coreOK.init(args);
        c.init(args);
        implementations1 = c.getImplementationNames();  //TSBadge,TSCA
    }
/*    @BeforeEach
    public void escenario2() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        String path = "src\\test\\java\\directoriesMock\\carpetaVacia";
        String Imp = "DefaultTS";
        String url = "url";
        String us = "US1";
        String [] args  = new String [] {path,Imp,url,us};
        Core c  = new Core();
        c.init(args);
        implementations2 = c.getImplementationNames();  //[vacio]

    }*/
    @Test
    public void CA1(){
        assertEquals(1, implementations1.length);
    }
    @Test
    public void CA2(){
        assertEquals(true, coreOK.changeImplementation(implementations1[0]));
    }
    @Test
    public void CA3(){
        assertEquals(false, coreOK.changeImplementation(null));
    }
}
