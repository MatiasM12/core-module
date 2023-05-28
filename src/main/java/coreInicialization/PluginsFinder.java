package coreInicialization;

import Interfaces.TSProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class PluginsFinder {
	 
    @SuppressWarnings("deprecation")
	public Set<TSProvider> find(String ImplPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
        File file = new File(ImplPath);
        Set<TSProvider> TSProviderSet = new HashSet<>();
        if (!file.exists()) throw new FileNotFoundException();
        File[] files = file.listFiles();
        
        for (File f : files) {
            if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                Class<?> cls = Class.forName(fileName);
                if (!TSProvider.class.isAssignableFrom(cls)) continue;
                TSProviderSet.add((TSProvider) cls.newInstance());
            }
        }
        return TSProviderSet;
    }
}