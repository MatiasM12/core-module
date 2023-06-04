package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Imp.TSVacio;
import Interfaces.TestSummary;
import coreInicialization.OriginFinder;


public class US2 {
    private static String INVALID_PATH;
    private static String NON_EXISTENT_PATH;
    private static String EMPTY_DIRECTORY;
    private static String NOT_A_SOURCE;
    private static String ONE_SOURCE;
    private static String MULTIPLE_SOURCES;
    private static String SPECIFIC_PROVIDER;
    private static OriginFinder finder1;
    private static OriginFinder finder2;
    private static OriginFinder finder3;
    private static OriginFinder finder4;
    private static OriginFinder finder5;
    private static OriginFinder finder6;
    private static OriginFinder finder7;
   

    @BeforeAll
    public static void escenario1() {
    	INVALID_PATH = "\\n";
    	finder1 = new OriginFinder(INVALID_PATH);
    }
    @BeforeAll
    public static void escenario2() {
        NON_EXISTENT_PATH = "src/unaCarpetaInexistente";
       
        finder2 = new OriginFinder(NON_EXISTENT_PATH);
    }
    @BeforeAll
    public static void escenario3() {
    	EMPTY_DIRECTORY = "src/test/java/directoriesMock/carpetaVacia/";
    	finder3 = new OriginFinder(EMPTY_DIRECTORY);
    }
    
    @BeforeAll
    public static void escenario4() {
        NOT_A_SOURCE = "src/test/java/directoriesMock/noEsFuente/";
        finder4 = new OriginFinder(NOT_A_SOURCE);
    }
    @BeforeAll
    public static void escenario5() {
    	ONE_SOURCE = "src/test/java/directoriesMock/fuenteSimple/";
    	finder5 = new OriginFinder(ONE_SOURCE);
    }
    @BeforeAll
    public static void escenario6() {
    	MULTIPLE_SOURCES = "src/test/java/directoriesMock/multiplesFuentes/";
    	finder6 = new OriginFinder(MULTIPLE_SOURCES);
    }
    @BeforeAll
    public static void escenario7() {
    	SPECIFIC_PROVIDER = "OriginImp.DefaultTS";
    	finder7 = new OriginFinder(ONE_SOURCE);
    }
    
    
    
    @Test 
    public void CA1() {
        assertThrows(FileNotFoundException.class, () -> finder1.find(new TSVacio(),SPECIFIC_PROVIDER,"US1"));
    }
    @Test 
    public void CA2(){
    	assertThrows(FileNotFoundException.class, () -> finder2.find(new TSVacio(),SPECIFIC_PROVIDER,"US1"));
    }
    @Test
    public void CA3() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	assertTrue(finder3.find(new TSVacio(),SPECIFIC_PROVIDER,"US1").isEmpty());
    }
    @Test
    public void CA4() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	assertTrue(finder4.find(new TSVacio(),SPECIFIC_PROVIDER,"US1").isEmpty());
    }
    @Test
    public void CA5() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	
    	System.out.println(SPECIFIC_PROVIDER);
    	Set<TestSummary> setTS = finder5.find(new TSVacio(),SPECIFIC_PROVIDER,"US1");
        assertEquals(1, setTS.size());
    }
    @Test
    public void CA6() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	Set<TestSummary> setTS = finder6.find(new TSVacio(),SPECIFIC_PROVIDER,"US1");
        assertTrue(setTS.size() >= 2);
    }
    @Test
    public void CA7() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	Set<TestSummary> setTS = finder7.find(new TSVacio(),SPECIFIC_PROVIDER,"US1");	
        assertTrue(setTS.stream().anyMatch(t -> t.getClass().getName().equals(SPECIFIC_PROVIDER)));
    }
}