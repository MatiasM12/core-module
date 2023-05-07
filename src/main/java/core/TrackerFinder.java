package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class TrackerFinder {
	
	@SuppressWarnings("deprecation")
	public Set<Tracker> findTrackers(String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) throw new FileNotFoundException();
        File[] files = file.listFiles(); 
        Set<Tracker> trackers = new HashSet<>();
        if(files == null) return trackers;
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
