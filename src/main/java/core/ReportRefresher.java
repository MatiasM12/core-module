package core;


public class ReportRefresher{
    private Tracker tracker;
    private String path;
    private Report report;
    public ReportRefresher(Tracker trackerImpl, String path, Report reportObservable){
        this.tracker = trackerImpl;
        this.path = path;
        this.report = reportObservable;
    }
    public void refreshReport() {
        ReportResult report = this.tracker.find(this.path);
        this.report.set(report);
    }
}
