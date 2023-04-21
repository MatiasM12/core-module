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









    // private ObservableTimer timer;



    //el contructor es mi inicializador y recibe donde buscar las imple del finder
    //aca vendria el dicovery que vaa buscar todas las imple de Finder
    //GitLabFinder - GitHubFinder - MockTxtFinder
    //el nombre no se si esta bien pero es la idea

    //el discovery devuelve una lista de todos los que encontro y se guarda aca en el PvCore




    // public void run(){
    //    this.timer.run();
    // }


    //fixme
/*    public PvCore() {
        this.finder = new HashMap<>();
        this.finder.put("default", new DefaultFinder()); //con esto parcheamos el Discovery
    }*/

/*    public void init(String finderImple, URL path, int refreshPeriodms){
        // todo lo que tenga que ver con configuracion de las distinta clases
        this.resultReports = new ObservableReport();
        this.actualizador = new ReportUpdater(finder.get(finderImple), path, this.resultReports);
        this.timer = new ObservableTimer((Observer) this.actualizador, refreshPeriodms);

    }*/
}
