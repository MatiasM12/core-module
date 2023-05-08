package core;

import java.util.Iterator;
import java.util.Set;

public class TrackerGetter {
    //voy a aplicar Singleton

    private static TrackerGetter intancia;

    private TrackerGetter(){}

    public static TrackerGetter getInstance(){
        if(intancia == null) intancia = new TrackerGetter();

        return intancia;
    }
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
