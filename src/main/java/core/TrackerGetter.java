package core;

import java.util.Iterator;
import java.util.Set;

public class TrackerGetter {
    public Tracker getTracker(String trackerImpl, Set<Tracker> trackerSet){
        Iterator<Tracker> iterator = trackerSet.iterator();
        while(iterator.hasNext()){
            Tracker tracker = iterator.next();
            if(tracker.getClass().getName().equals(trackerImpl))
                return tracker;
        }
        return null;
    }

    public Tracker getOneTracker(Set<Tracker> trackerSet) {
        Iterator<Tracker> iterator = trackerSet.iterator();
        if (iterator.hasNext()){
            Tracker tracker = iterator.next();
            return tracker;
        }
        return null;
    }
}
