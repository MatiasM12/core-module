package core;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class InitCore {
    public NewCore init(String trackersPath, String trackerImpl, String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IOException, InvocationTargetException {
        TrackerFinder trackerFinder = new TrackerFinder();
        //Set<Tracker> trackerSet = trackerFinder.findTrackers(trackersPath);

        NewCore core = new NewCore();

        //Tracker tracker = new TrackerGetter().getTracker(trackerImpl, trackerSet);
        Tracker tracker = new SelfTracker();
        tracker.setObserver(core);
        tracker.track(path);

        return core;
    }
}
