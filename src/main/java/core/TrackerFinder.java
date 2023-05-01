package core;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class TrackerFinder {
    private Set<Tracker> trackers;
    private String path;
    TrackerFinder(String findersImplPath){
        this.path = findersImplPath;
        this.trackers = new HashSet<>();
    }
    public void initTrackers() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        File[] files = new File(path).listFiles();
        for (File f : files) {
            System.out.println(f.getName());
            if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                String className = "InterfacesImpl." + fileName;
                Class<?> cls = Class.forName(className);
                if (!Tracker.class.isAssignableFrom(cls)) continue;
                this.trackers.add((Tracker) cls.newInstance());
            }
        }
        for(Tracker tracker : this.trackers){
            System.out.println(tracker.getClass().getName());
        }
    }
    public Tracker getTracker(String trackerImpl){
        Iterator<Tracker> iterator = this.trackers.iterator();
        while(iterator.hasNext()){
            Tracker t = iterator.next();
            if(t.getClass().getName().equals(trackerImpl))
                return t;
        }
        System.out.println("Soy null");
        return null;
    }
}
