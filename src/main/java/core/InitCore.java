package core;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class InitCore {
    public TestSummary init(String trackersPath, String trackerImpl, String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IOException, InvocationTargetException {
        TrackerFinder trackerFinder = new TrackerFinder();
        Set<Tracker> trackerSet = trackerFinder.findTrackers(trackersPath);

        TrackerGetter getter = new TrackerGetter();
        TestSummary tracker = getter.getOneTracker(trackerSet);

        TestSummary concrete = tracker.hook(path);
        TestSummary core = new ObservableTestSummary(concrete);

        return core;
    }
}
