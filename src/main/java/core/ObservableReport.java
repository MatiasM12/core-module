package core;

import java.util.List;
import java.util.Map;

public class ObservableReport extends core.Observable{
    public ReportResult reporteJava;
    //private Observer observer;

    public ObservableReport(ReportResult rr){
        this.reporteJava = rr;
    }
    public void set(ReportResult reportResult) {
        this.reporteJava = reportResult;
        notifyObservers();
    }
    public ReportResult getReport() {
        return this.reporteJava;
    }
}
