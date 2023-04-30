package core;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class InitCore {
    private TrackerFinder trackerFinder;
    public InitCore(String findersImplPath){
        this.trackerFinder = new TrackerFinder(findersImplPath);
    }
    public ReportSubscriber init(String trackerImpl, String reportDirectoryPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IOException, InvocationTargetException {
        this.trackerFinder.initTrackers();
        Tracker tracker = this.trackerFinder.getTracker(trackerImpl);

        Report report = new Report(tracker.find(reportDirectoryPath));
        ReportRefresher refresher = new ReportRefresher(tracker, reportDirectoryPath, report);
        Listener listener = new Listener(refresher);
        listener.start();

        return new ReportSubscriber(report);
    }
}
