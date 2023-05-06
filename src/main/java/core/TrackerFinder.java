package core;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class TrackerFinder {
    private String path;
    TrackerFinder(String findersImplPath){
        this.path = findersImplPath;
    }
    public Set<Tracker> findTrackers() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        File[] files = new File(path).listFiles();
        Set<Tracker> trackers = new HashSet<>();
        for (File f : files) {
            if (f.getName().endsWith(".class")) {
                String fileName = f.getName().replace(".class", "");
                Class<?> cls = Class.forName(fileName);
                if (!Tracker.class.isAssignableFrom(cls)) continue;
                trackers.add((Tracker) cls.newInstance());
            }
        }
        return trackers;
    }
}
