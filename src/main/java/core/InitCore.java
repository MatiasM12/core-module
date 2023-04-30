package core;

import java.io.IOException;

public class InitCore {
    private OtraClase otraClase;
    public InitCore(String findersImplPath){
        this.otraClase = new OtraClase(findersImplPath);
    }
    public void init(String trackerImpl, String reportDirectoryPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IOException {
        this.otraClase.initTrackers();
        Tracker tracker = this.otraClase.getTracker(trackerImpl);

        Report report = new Report(tracker.find(reportDirectoryPath));
        ReportRefresher refresher = new ReportRefresher(tracker, reportDirectoryPath, report);
        Listener listener = new Listener(refresher);
        listener.start();
    }
}
