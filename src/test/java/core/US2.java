package core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;


import coreInicialization.PluginsFinder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class US2 {
    private static String INVALID_PATH;
    private static String NON_EXISTENT_PATH;
    private static String EMPTY_DIRECTORY;
    private static String NOT_A_SOURCE;
    private static String ONE_SOURCE;
    private static String MULTIPLE_SOURCES;
    private static String SPECIFIC_PROVIDER;
    private static PluginsFinder finder;

    @BeforeAll
    public static void escenario() {
    	INVALID_PATH = "\\n";
        NON_EXISTENT_PATH = "src/unaCarpetaInexistente";
        EMPTY_DIRECTORY = "src/test/java/directoriesMock/carpetaVacia/";
        NOT_A_SOURCE = "src/test/java/directoriesMock/noEsFuente/";
        ONE_SOURCE = "src/test/java/directoriesMock/fuenteSimple/";
        MULTIPLE_SOURCES = "src/test/java/directoriesMock/multiplesFuentes/";
        SPECIFIC_PROVIDER = "MockTSProvider";
        finder = new PluginsFinder();
    }
 /*   @Test 
    public void CA1() {
        assertThrows(FileNotFoundException.class, () -> finder.find(NON_EXISTENT_PATH));
    }
    @Test 
    public void CA2(){
    	assertThrows(FileNotFoundException.class, () -> finder.find(INVALID_PATH));
    }
    @Test
    public void CA3() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	assertTrue(finder.find(EMPTY_DIRECTORY).isEmpty());
    }
    @Test
    public void CA4() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	assertTrue(finder.find(NOT_A_SOURCE).isEmpty());
    }
    @Test
    public void CA5() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    	Set<TSProvider> providers = finder.find(ONE_SOURCE);
        assertEquals(1, providers.size());
    }
    @Test
    public void CA6() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Set<TSProvider> providers = finder.find(MULTIPLE_SOURCES);
        assertTrue(providers.size() >= 2);
    }
    @Test
    public void CA7() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Set<TSProvider> providers = finder.find(ONE_SOURCE);
        assertTrue(providers.stream().anyMatch(t -> t.getClass().getName().equals(SPECIFIC_PROVIDER)));
    }*/
}