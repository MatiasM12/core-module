package core;

import interfaces.USTestSummary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class US1 {

    private USTestSummary usTestSummary;
    private Map<String,Boolean> TSUS1 ;

    @BeforeEach
    public void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException, MalformedURLException {
		Properties prop = new Properties();
        loadProperties(prop,"src/test/java/mock.properties"); 
		usTestSummary = new Core().init(prop);
		TSUS1  = usTestSummary.getTests();
    }
    
    
	@Test
    void CA1() {
		Map<String,Boolean> newCA = createMap("CA2",true);
    	
		TSUS1 .putAll(newCA);
    	usTestSummary.updateTests(TSUS1 );
    	
    	assertTrue(usTestSummary.getTests().entrySet().containsAll(newCA.entrySet()));
    	assertEquals(2,usTestSummary.getTests().size());
    }

    
	@Test @SuppressWarnings({"unlikely-arg-type"})
    void CA2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
		Map<String,Boolean> removeCA = createMap("CA2",true);
    	
		TSUS1 .remove(removeCA);
		usTestSummary.updateTests(TSUS1 );
		
    	assertFalse(usTestSummary.getTests().entrySet().containsAll(removeCA.entrySet()));
    	assertEquals(1,usTestSummary.getTests().size());
    }

    
	@Test 
    void CA3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
		Map<String,Boolean> newSatusCA = createMap("CA1",false);
    	
		TSUS1 .putAll(newSatusCA);
    	usTestSummary.updateTests(TSUS1 );
    	
    	assertTrue(usTestSummary.getTests().get("CA1") == false);
    }

    
	@Test
    void CA4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException{
		Map<String,Boolean> emptyCA = createEmptyMap();
    	
		TSUS1 = emptyCA;
    	usTestSummary.updateTests(TSUS1);
    	
    	assertTrue(usTestSummary.getTests() == emptyCA);
    }
	
    


	public static void loadProperties(Properties prop,String filePath) {
		try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
        	prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@SuppressWarnings("serial")
	public HashMap<String, Boolean> createMap(String caName,Boolean testResult) {
		return new HashMap<String,Boolean>(){{put(caName,testResult);}};
	}
	
	private Map<String, Boolean> createEmptyMap() {
		return new HashMap<String,Boolean>();
	}

}