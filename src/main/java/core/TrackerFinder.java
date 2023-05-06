package core;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class TrackerFinder {
	

    
    public Set<Tracker> findTrackers(String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
