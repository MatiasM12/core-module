package core;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class InitCore {
    public TestSummary init(String trackersPath, String trackerImpl, String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IOException, InvocationTargetException {
        TrackerFinder trackerFinder = new TrackerFinder();
        Set<Tracker> trackerSet = trackerFinder.findTrackers(trackersPath);

        TestSummary core = new TestSummary();

        Tracker tracker1 = TrackerGetter.getOneTracker(trackerSet);
        if(tracker1 != null)tracker1.addObserver((Observer) core);


        return core;
    }
}
