package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class FactoryFinder {
	 
    @SuppressWarnings("deprecation")
	public Set<Factory> find(String ImplPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
        File file = new File(ImplPath);
        Set<Factory> FactorySet = new HashSet<>();
        if (!file.exists()) throw new FileNotFoundException();
        File[] files = file.listFiles();       
        for (File f : files) {
            if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                Class<?> cls = Class.forName("Factory."+fileName);
                if (!Factory.class.isAssignableFrom(cls)) continue;
                FactorySet.add((Factory) cls.newInstance());
            }
        }
        return FactorySet;
    }
    

  
}