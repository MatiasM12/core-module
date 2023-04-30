package InterfacesImpl;

import core.ReportResult;
import core.Tracker;

import java.util.HashMap;
import java.util.Map;

public class DefaultReportTracker implements Tracker {
    @Override
    public ReportResult find(String path) {
        Map<String, Boolean> map = new HashMap<>();
        map.put("test1", true);
        map.put("test2", false);
        map.put("test3", true);
        ReportResult ret = new ReportResult("US1", map);
        return ret;
    }
}
