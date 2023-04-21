package core;

import java.util.List;
import java.util.Map;
import java.util.Observable;

public class ObservableReport extends Observable {

    List<ReportResult> reportes;
    Map<String, ReportResult> reportePorUS;

    public ReportResult reporteJava;


    public void set(ReportResult reportResult) {
        this.reporteJava = reportResult;
        notifyObservers();
    }

    public ReportResult getReport() {
        return this.reporteJava;
    }
}
