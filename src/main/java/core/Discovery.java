package core;

import InterfacesImpl.DefaultFinder;
import InterfacesImpl.SrcChecker;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//TODO implementar esto
public class Discovery {
    private String path;
    public Discovery(String path){
        this.path = path;
    }
/*    public Set<Finder> discover(){
        Map<String, Finder> finders = new HashMap<>();
        finders.put("DefaultFinder", new DefaultFinder());
        return finders;
    }*/

    @SuppressWarnings("deprecation")
	public Set<Finder> discover() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Set<Finder> result = new HashSet<>();
        File[] files = new File(path).listFiles();
        for (File f : files) {
        	if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                String className = "InterfacesImpl." + fileName;
                Class<?> cls = Class.forName(className);
                if (!Finder.class.isAssignableFrom(cls)) continue;
                result.add((Finder) cls.newInstance());
            }
        }
        return result;
    }
}
