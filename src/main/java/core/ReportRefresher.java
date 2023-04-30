package core;


public class ReportRefresher implements core.Observer {
    private Tracker tracker;
    private String path;
    private Report report;
    //private SrcChecker srcChecker;

    public ReportRefresher(Tracker trackerImpl, String path, Report reportObservable){
        this.tracker = trackerImpl;
        this.path = path;
        this.report = reportObservable;
    }

    public void update() {
        ReportResult report = this.tracker.find(this.path);
        this.report.set(report);
    }
}
