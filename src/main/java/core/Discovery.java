package core;

import InterfacesImpl.DefaultFinder;
import InterfacesImpl.SrcChecker;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

//TODO implementar esto
public class Discovery {
	
    private String path;
    
    public Discovery(String path){
        this.path = path;
    }
    
//    @SuppressWarnings("deprecation")
//	public Map<String, Finder> discoverFinders() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
//        Map<String, Finder> result = new HashMap<>();
//        String name;
//        File[] files = new File(path).listFiles();
//        for (File f : files) {
//        	if (f.getName().endsWith(".class")) {
//                String fileName = f.getName().replace(".class", "");
//                String className = "InterfacesImpl." + fileName;
//                Class<?> cls = Class.forName(className);
//                if (!Finder.class.isAssignableFrom(cls)) continue;
//                name = cls.getName().replace("InterfacesImpl.", "");
//                result.put(name , (Finder) cls.newInstance());
//            }
//        }
//        System.out.println(result);
//        return result;
//    }
    
    public Map<String, Finder> discoverFinders(){
        Map<String, Finder> finders = new HashMap<>();
        finders.put("DefaultFinder", new DefaultFinder());
        return finders;
    }


    public Map<String, Checker> discoverCheckers(){
        Map<String, Checker> checkers = new HashMap<>();
        checkers.put("SrcChecker", new SrcChecker());
        return checkers;
    }
}
