package core;

import java.io.File;
import java.io.FileNotFoundException;
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

    public TrackerFinder() {

    }

    public Set<Tracker> initTrackers() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) throw new FileNotFoundException();
        File[] files = file.listFiles(); 
        for (File f : files) {
            if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                Class<?> cls = Class.forName(fileName); 
                if (!Tracker.class.isAssignableFrom(cls)) continue;
                this.trackers.add((Tracker) cls.newInstance());  
            }
        }
        return this.trackers;
    }
    public Set<Tracker> find(String trackerImplPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
        File file = new File(path);
        Set<Tracker> trackerSet = new HashSet<>();
        if (!file.exists()) throw new FileNotFoundException();
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                Class<?> cls = Class.forName(fileName);
                if (!Tracker.class.isAssignableFrom(cls)) continue;
                trackerSet.add((Tracker) cls.newInstance());
            }
        }
        return trackerSet;
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

    public Tracker getTracker(Set<Tracker> trackerSet, String trackerImpl){
        Iterator<Tracker> iterator = trackerSet.iterator();
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

    public Tracker getOneTracker(Set<Tracker> trackerSet) {
//        if(trackerSet == null)
        Iterator<Tracker> iterator = trackerSet.iterator();
        Tracker t = null;
        while (iterator.hasNext()) {
            t = iterator.next();
        }
        return t;
    }
}