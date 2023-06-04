package coreInicialization;


import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import Interfaces.OriginTS;
import Interfaces.TestSummary;
import core.TSDecorator;

public class OriginFinder {
	String path;
	public OriginFinder(String path) {
		this.path = path;
	}
	 
    @SuppressWarnings("deprecation")
	public Set<TestSummary> find(TestSummary ts,String url ,String us) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
        File file = new File(this.path);
        Set<TestSummary> tSSet = new HashSet<>();
        if (!file.exists()) throw new FileNotFoundException();
        File[] files = file.listFiles();
        for (File f : files) {
        	 System.out.println(f.getName()+" Buenas soy la clase");
            if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                Class<?> cls = Class.forName("OriginImp."+fileName);
                if (!OriginTS.class.isAssignableFrom(cls)) continue;
                Constructor<?> constructor = cls.getDeclaredConstructor(TestSummary.class,String.class,String.class);
                tSSet.add((OriginTS) constructor.newInstance(ts,url,us));
            }
        }
        return tSSet;
    }
}