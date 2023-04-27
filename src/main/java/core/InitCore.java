package core;

import java.net.URL;
import java.util.Map;
import java.util.Observer;

public class InitCore {
    Discovery discovery;
    Map<String, Finder> finders;
    public InitCore(String findersImplPath){
        this.discovery = new Discovery(findersImplPath);
        this.finders = this.discovery.discover();
    }
    public PvCore init(String finderImpl, URL reportDirectoryPath, int refreshPeriodms){
        Finder finder = this.finders.get(finderImpl);

        ObservableReport resultReports = new ObservableReport(finder.find(reportDirectoryPath));
        ReportUpdater updater = new ReportUpdater(finder, reportDirectoryPath, resultReports);
        SrcChecker srcChecker = new SrcChecker(reportDirectoryPath, updater);
        CheckerTimer timer = new CheckerTimer(srcChecker, refreshPeriodms);

        PvCore pvcore = new PvCore(resultReports);
        timer.run();

        return pvcore;
    }
}
