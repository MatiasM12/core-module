package core;

import java.util.HashSet;
import java.util.Set;

public class InitCore {
    private Discovery finderDiscovery;
    private Set<Finder> finders;
    public InitCore(String findersImplPath){
        this.finderDiscovery = new Discovery(findersImplPath);
        this.finders = new HashSet<>();
    }
/*
    public Set<String> getFinderImpl(){
        return finders;
    }
*/
    public ReportSetterGetter init(String finderImpl, String reportDirectoryPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        this.finders = this.finderDiscovery.discover();
        Listener miHandler = new Listener();
        Finder finder = this.finders.get(finderImpl);
        //FIXME hay que implementar la eleccion del checker

        ReportSetterGetter observableReport = new ReportSetterGetter(finder.find(reportDirectoryPath));
        ReportUpdater updater = new ReportUpdater(finder, reportDirectoryPath, observableReport);
        checker.addObserver(updater);

        return observableReport;
    }
}
