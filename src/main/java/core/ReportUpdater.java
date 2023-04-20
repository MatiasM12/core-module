package core;


import netscape.javascript.JSObject;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;

public class ReportUpdater implements Observer {
    private Finder finder;
    private URL path;
    private ObservableReport observableReportResult;

    public ReportUpdater(Finder finderImple, URL path, ObservableReport reporteObservable){
        this.finder = finderImple;
        this.path = path;
    }

    protected void update(ReportResult report, URL path) {
        JSObject listaNueva = finder.find(path);

    }
    //fixme no deberia hacer tantas cosas: usar el finder, set, new
    protected void getReport(){
        JSObject reporte = this.finder.find(this.path);
        this.observableReportResult.set(new ReportResult(reporte));
    }

    @Override
    public void update(Observable o, Object arg) {
        getReport();
        //esta observando un timer que le avisa cada vez que pasa x cantidad de tiempo
        //entonces el updater consige el reporteJson a traves del finder, crea un ReportResult y lo setea en ObserbableReport
    }
}
