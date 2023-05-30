package coreInicialization;

import Interfaces.TestSummary;
import core.TSDecorator;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class PluginsFinder {
	 
    @SuppressWarnings("deprecation")
	public Set<TSDecorator> find(String ImplPath,TestSummary ts) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
        File file = new File(ImplPath);
        Set<TSDecorator> Decorators = new HashSet<>();
        if (!file.exists()) throw new FileNotFoundException();
        File[] files = file.listFiles();
        
        for (File f : files) {
            if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                Class<?> cls = Class.forName(fileName);
                Constructor<?> constructor = cls.getConstructor(TestSummary.class);
                if (!TSDecorator.class.isAssignableFrom(cls)) continue;
                Decorators.add((TSDecorator) constructor.newInstance(ts));
            }
        }
        return Decorators;
    }
}