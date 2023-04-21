package core;

import java.util.*;

public class PvCore {
    private ReportUpdater actualizador;
    private ObservableReport resultReports;
    public PvCore(ReportUpdater reportUpdater, ObservableReport observableReport) {
        this.resultReports = observableReport;
        this.actualizador = reportUpdater;
    }
    public void addObserver(Observer o){
        this.resultReports.addObserver(o);
    }
    public ReportResult getReport(){
        return this.resultReports.getReport();
    }
}
