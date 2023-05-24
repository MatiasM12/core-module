package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class PluginsFinder {
	 
    public Set<Plugin> find(String ImplPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
        File file = new File(ImplPath);
        Set<Plugin> pluginSet = new HashSet<>();
        if (!file.exists()) throw new FileNotFoundException();
        File[] files = file.listFiles();
        
        for (File f : files) {
        	System.out.println(f.getName());
            if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                Class<?> cls = Class.forName("trackers."+fileName);
                if (!TestSummary.class.isAssignableFrom(cls)) continue;
                pluginSet.add((Plugin) cls.newInstance());
            }
        }
        return pluginSet;
    }
    

  
}
