package core;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class US1 {

	private static ObservableFactory init;
	private  static ObservableTestSummary testSummary;
	
	@BeforeAll
	static void escenario1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		init = new ObservableFactory();
		String[] values = new String[] {"US1","StubTsDecorator"};
    	Observable obv =init.createObservable(values);
    	init.getDecorador();
	}
	
	@Test
	void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
	//	init = new CoreInit();
    //	testSummary =(ObservableTestSummary)init.init("plugins", "trackers.TrackerTestSummary");
   	assertFalse(testSummary==null);
	}
	
	
	

}
