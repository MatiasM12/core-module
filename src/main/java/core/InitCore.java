package core;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class InitCore {
    public UserStoryGateway init(String trackersPath, String trackerImpl, String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IOException, InvocationTargetException {
        TrackerFinder trackerFinder = new TrackerFinder();
        Set<Tracker> trackerSet = trackerFinder.findTrackers(trackersPath);

        TestSummary userStory = new UserStory();

        UserStoryGateway userStoryGateway = new UserStoryGateway((UserStory) userStory);
        TestSummary core = new TestSummaryProxy(userStory);

        TrackerGetter getter = new TrackerGetter();
        Tracker tracker1 = getter.getOneTracker(trackerSet);
        if(tracker1 != null)tracker1.setObserver(core);

        //Tracker tracker = new TrackerGetter().getTracker(trackerImpl, trackerSet);
//        Tracker tracker = new SelfTracker();
//        tracker.setObserver(core);
//        tracker.track(path);

        return userStoryGateway;
    }
}
