package core;

import java.util.*;

public class PvCore {
    private ObservableReport resultReports;
    public PvCore(ObservableReport observableReport) {
        this.resultReports = observableReport;
    }
    public void addObserver(Observer o){
        this.resultReports.addObserver(o);
    }
    public ReportResult getReport(){
        return this.resultReports.getReport();
    }
}
