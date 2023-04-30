package core;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class TrackerFinder {
    private Searcher trackerSearcher;
    private Set<Tracker> trackers;
    TrackerFinder(String findersImplPath){
        this.trackerSearcher = new Searcher(findersImplPath);
        this.trackers = new HashSet<>();
    }
    public void initTrackers() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        this.trackers = this.trackerSearcher.discover();
    }
    public Tracker getTracker(String trackerImpl){
        return this.trackers.stream().filter(x -> x.getClass().getName().equals(trackerImpl)).collect(null);
    }
}
