package core;

import java.util.HashSet;
import java.util.Set;

public class OtraClase {
    private Discovery fidnderDiscovery;
    private Set<Tracker> trackers;
    OtraClase(String findersImplPath){
        this.fidnderDiscovery = new Discovery(findersImplPath);
        this.trackers = new HashSet<>();
    }
    public void initTrackers() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        this.trackers = this.fidnderDiscovery.discover();
    }
    public Tracker getTracker(String trackerImpl){
        return this.trackers.stream().filter(x -> x.getClass().getName().equals(trackerImpl)).collect(null);
    }
}
