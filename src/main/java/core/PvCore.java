package core;

import java.net.URL;
import java.util.*;

public class PvCore {
    Map<String, Finder> finders;
    ReportUpdater actualizador;
    ObservableReport resultReports;
    private ObservableTimer timer;

    public PvCore(URL pathFinderImplementations) {
        //el contructor es mi inicializador y recibe donde buscar las imple del finder
        //aca vendria el dicovery que vaa buscar todas las imple de Finder
        //GitLabFinder - GitHubFinder - MockTxtFinder
        //el nombre no se si esta bien pero es la idea

        //el discovery devuelve una lista de todos los que encontro y se guarda aca en el PvCore
    }

    //fixme
    public PvCore() {
        this.finders = new HashMap<>();
        this.finders.put("default", new DefaultFinder()); //con esto parcheamos el Discovery
    }

    public void init(String finderImple, URL path, int refreshPeriodms){
        // todo lo que tenga que ver con configuracion de las distinta clases
        this.resultReports = new ObservableReport();
        this.actualizador = new ReportUpdater(finders.get(finderImple), path, this.resultReports);
        this.timer = new ObservableTimer((Observer) this.actualizador, refreshPeriodms);

    }

    public void addObserver(Observer o){
        this.resultReports.addObserver(o);
    }

    public void run(){
        this.timer.run();
    }

    public ReportResult getReport(){
        return this.resultReports.getReport();
    }

}
