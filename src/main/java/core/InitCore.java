package core;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class InitCore {
    
    
    public Integrator init(String trackerImpl, String reportDirectoryPath,String findersImplPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException  {
        TrackerFinder finder = new TrackerFinder(findersImplPath);
    	Report report = new Report(null);
        ReportRefresher refresher = new ReportRefresher(reportDirectoryPath, report);
        Listener listener = new Listener();
        Integrator integrator = new Integrator(report, listener);
        RelateObjects relate = new RelateObjects(finder,report, refresher, listener);
        relate.relateApp(trackerImpl);
        return integrator;
    }
}
