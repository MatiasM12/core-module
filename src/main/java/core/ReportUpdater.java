package core;


public class ReportUpdater implements core.Observer {
    private Finder finder;
    private String path;
    private ReportSetterGetter observableReportResult;
    //private SrcChecker srcChecker;

    public ReportUpdater(Finder finderImpl, String path, ReportSetterGetter reportObservable){
        this.finder = finderImpl;
        this.path = path;
        this.observableReportResult = reportObservable;
    }

    public void update() {
        ReportResult report = this.finder.find(this.path);
        this.observableReportResult.set(report);
    }
}
