package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PluginFinder {
    public Set<TSManager> find(String trackerImplPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
        File file = new File(trackerImplPath);
        Set<TSManager> TSBuilderSet = new HashSet<>();
        if (!file.exists()) throw new FileNotFoundException();
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                Class<?> cls = Class.forName(fileName);
                if (!TSManager.class.isAssignableFrom(cls)) continue;
                TSBuilderSet.add((TSManager) cls.newInstance());
            }
        }
        return TSBuilderSet;
    }
    public TSManager getTracker(Set<TSManager> TSBuilderSet, String trackerImpl){
        Iterator<TSManager> iterator = TSBuilderSet.iterator();
        while(iterator.hasNext()){
            TSManager t = iterator.next();
            if(t.getClass().getName().equals(trackerImpl))
                return t;
        }
        return null;
    }
    public TSManager getOneTracker(Set<TSManager> TSBuilderSet) {
        if(TSBuilderSet.isEmpty()) throw new RuntimeException("El set esta vacio");
        Iterator<TSManager> iterator = TSBuilderSet.iterator();
        TSManager t = null;
        while (iterator.hasNext()) {
            t = iterator.next();
        }
        return t;
    }
}