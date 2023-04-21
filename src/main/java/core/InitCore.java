package core;

import java.net.URL;
import java.util.Map;
import java.util.Observer;

public class InitCore {
    Discovery discovery;
    Map<String, Finder> finders;
    public InitCore(String path){
        this.discovery = new Discovery(path);
        this.finders = discovery.discover();
    }
    public PvCore init(String finderImpl, URL path, int refreshPeriodms){
        Finder finder = finders.get(finderImpl);

        ObservableReport resultReports = new ObservableReport();
        SrcChecker srcChecker = new SrcChecker();
        ReportUpdater actualizador = new ReportUpdater(finder, path, resultReports, srcChecker);
        CheckerTimer timer = new CheckerTimer(srcChecker, refreshPeriodms);

        PvCore pvcore = new PvCore(actualizador, resultReports);
        timer.run();

        return pvcore;
    }
}
