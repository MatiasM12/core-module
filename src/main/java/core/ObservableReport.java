package core;

public class ObservableReport extends core.Observable{
    private ReportResult reportResult;
    protected ObservableReport(ReportResult rr){
        this.reportResult = rr;
    }
    protected void set(ReportResult reportResult) {
        this.reportResult = reportResult;
        notifyObservers();
    }
    public ReportResult getReport() {
        return this.reportResult;
    }
}
