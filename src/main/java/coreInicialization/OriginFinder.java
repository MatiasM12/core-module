package coreInicialization;


import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import Interfaces.OriginTS;
import Interfaces.TestSummary;

public class OriginFinder {
	String path;
	public OriginFinder(String path) {
		this.path = path;
	}
	 
    public Set<TestSummary> find(TestSummary ts) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
        File file = new File(this.path);
        Set<TestSummary> tSSet = new HashSet<>();
        if (!file.exists()) throw new FileNotFoundException();
        
        File[] files = file.listFiles();
        for (File f : files) {
        	
        	System.out.println(f.getName()+" Toy aca basuraaaaaaaaaaaaaaaaaaas");
        	
            if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");           
                Class<?> cls = Class.forName("imp."+fileName);
                if (!OriginTS.class.isAssignableFrom(cls)) continue;
                
                for (Constructor<?>  c : cls.getConstructors()) {
					System.out.println(c.toString());
				}
                
                Constructor<?> constructor = cls.getDeclaredConstructor(TestSummary.class);
                tSSet.add((OriginTS) constructor.newInstance(ts));
            }
        }
        return tSSet;
    }
}