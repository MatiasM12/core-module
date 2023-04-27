package core;

public class ObservableReport extends core.Observable{
    public ReportResult reportResult;
    //private Observer observer;

    public ObservableReport(ReportResult rr){
        this.reportResult = rr;
    }
    public void set(ReportResult reportResult) {
        this.reportResult = reportResult;
        notifyObservers();
    }
    public ReportResult getReport() {
        return this.reportResult;
    }
}
