package core;

import java.util.ArrayList;

public class ObservableReport extends core.Observable{
    private ReportResult reportResult;
    protected ObservableReport(ReportResult rr){
        this.reportResult = rr;
        super.observers = new ArrayList<>();
    }
    protected void set(ReportResult reportResult) {
        this.reportResult = reportResult;
        notifyObservers();
    }
    public ReportResult getReport() {
        return this.reportResult;
    }
}
