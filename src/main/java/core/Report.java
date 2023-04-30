package core;

import java.util.ArrayList;

public class Report extends core.Observable{
    private ReportResult reportResult;
    protected Report(ReportResult rr){
        this.reportResult = rr;
        super.observers = new ArrayList<>();
    }
    protected void set(ReportResult reportResult) {
        this.reportResult = reportResult;
        notifyObservers(this.reportResult);
    }
}
