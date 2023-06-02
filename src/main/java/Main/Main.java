package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import core.Core;
import interfaces.USTestSummary;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException, MalformedURLException {
		Properties prop = new Properties();
        loadProperties(prop);
        
        Core core = new Core();
        USTestSummary ts = core.init(prop);
	    Map<String, Boolean> map = new HashMap<>();
	    map.put("clave1", true);
	    map.put("clave2", true);
	    map.put("clave3", true);
		ts.updateTests(map);
		
        map.put("clave1", false);
        map.put("clave2", false);
        map.put("clave3", false);
        ts.updateTests(map);
	}

	public static void loadProperties(Properties prop) {
		try (FileInputStream fileInputStream = new FileInputStream("config.properties")) {
        	prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}