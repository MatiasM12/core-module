package core;


import netscape.javascript.JSObject;

import java.net.URL;
import java.util.Observer;

public class ReportUpdater implements core.Observer {
    private Finder finder;
    private URL path;
    private ObservableReport observableReportResult;
    //private SrcChecker srcChecker;

    public ReportUpdater(Finder finderImple, URL path, ObservableReport reporteObservable, Observable srcChecker){
        this.finder = finderImple;
        this.path = path;
        this.observableReportResult = reporteObservable;

        srcChecker.addObserver(this);
    }

    public void update() {
        ReportResult report = finder.find(this.path);
        observableReportResult.set(report);
    }
}
