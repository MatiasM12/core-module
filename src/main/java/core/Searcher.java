package core;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class Searcher {
    private String path;
    public Searcher(String path){
        this.path = path;
    }
    @SuppressWarnings("deprecation")
	public Set<Tracker> discover() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Set<Tracker> result = new HashSet<>();
        File[] files = new File(path).listFiles();
        for (File f : files) {
        	if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                String className = "InterfacesImpl." + fileName;
                Class<?> cls = Class.forName(className);
                if (!Tracker.class.isAssignableFrom(cls)) continue;
                result.add((Tracker) cls.newInstance());
            }
        }
        return result;
    }
}
