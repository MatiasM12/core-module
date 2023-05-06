package core;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TrackerFinder {
	
    private Set<Tracker> trackers;
    private String path;
    
    public TrackerFinder(String findersImplPath){
        this.path = findersImplPath;
        this.trackers = new HashSet<Tracker>();
    }
    
    public void initTrackers() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        File[] files = new File(path).listFiles();
        for (File f : files) {
            System.out.println(f.getName());
            if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                String className =  fileName;
                System.out.println(className);
                Class<?> cls = Class.forName(className);
                if (!Tracker.class.isAssignableFrom(cls)) continue;
                this.trackers.add((Tracker) cls.newInstance());
            }
        }
        System.out.println("encontre los trackers");
    }
    
    public Tracker getTracker(String trackerImpl){
        Iterator<Tracker> iterator = this.trackers.iterator();
        while(iterator.hasNext()){
            Tracker t = iterator.next();
            if(t.getClass().getName().equals(trackerImpl))
                return t;
        }
        return null;
    }
    
    
    public int getSizeTrackers() {
    	return this.trackers.size();
    }
}
