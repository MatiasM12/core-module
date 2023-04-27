package core;


import netscape.javascript.JSObject;

import java.net.URL;
import java.util.Observer;

public class ReportUpdater implements core.Observer {
    private Finder finder;
    private String path;
    private ObservableReport observableReportResult;
    //private SrcChecker srcChecker;

    public ReportUpdater(Finder finderImpl, String path, ObservableReport reportObservable){
        this.finder = finderImpl;
        this.path = path;
        this.observableReportResult = reportObservable;
    }

    public void update() {
        ReportResult report = this.finder.find(this.path);
        this.observableReportResult.set(report);
    }
}
