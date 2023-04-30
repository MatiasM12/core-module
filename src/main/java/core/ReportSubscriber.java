package core;

public class ReportSubscriber {
    private Report report;
    public ReportSubscriber(Report report){
        this.report = report;
    }
    public void subscribe(Observer o){
        this.report.addObserver(o);
    }
}
