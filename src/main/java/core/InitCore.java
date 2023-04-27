package core;

import java.net.URL;
import java.util.Map;

public class InitCore {
    Discovery finderDiscovery;
    Discovery checkerDiscovery;
    Map<String, Finder> finders;
    Map<String, Checker> checkers;
    public InitCore(String findersImplPath, String checkerImplPath){
        this.finderDiscovery = new Discovery(findersImplPath);
        this.checkerDiscovery = new Discovery(checkerImplPath);
        this.finders = this.finderDiscovery.discoverFinders();
        this.checkers = this.checkerDiscovery.discoverCheckers();
    }
    public ObservableReport init(String finderImpl, URL reportDirectoryPath, int refreshPeriodms){
        Finder finder = this.finders.get(finderImpl);
        //FIXME hay que implementar la eleccion del checker
        Checker checker = this.checkers.get("SrcChecker");

        ObservableReport observableReport = new ObservableReport(finder.find(reportDirectoryPath));
        ReportUpdater updater = new ReportUpdater(finder, reportDirectoryPath, observableReport);
        checker.addObserver(updater);

        CheckerTimer timer = new CheckerTimer(checker, refreshPeriodms, reportDirectoryPath);

        timer.run();

        return observableReport;
    }
}
