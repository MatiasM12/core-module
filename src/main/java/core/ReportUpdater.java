package core;

import java.util.Observable;
import java.util.Observer;

public class ReportUpdater implements Observer {
    Finder reportFinder;
    CheckerBuilder CheckerBuilder;
    public ReportUpdater(String path, int intervaloActualizacion, Init init) {
        this.CheckerBuilder = new CheckerBuilder(path, intervaloActualizacion, this);
        this.reportFinder = new ReportFinder(path);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
    public void update(){
        updateReport();
    }
    public void updateReport() {

    }
}
