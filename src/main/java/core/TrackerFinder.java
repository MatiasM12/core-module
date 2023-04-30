package core;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

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
            if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                String className = "InterfacesImpl." + fileName;
                Class<?> cls = Class.forName(className);
                if (!Tracker.class.isAssignableFrom(cls)) continue;
                this.trackers.add((Tracker) cls.newInstance());
            }
        }
    }
    public Tracker getTracker(String trackerImpl){
        return this.trackers.stream().filter(x -> x.getClass().getName().equals(trackerImpl)).collect(null);
    }
}
