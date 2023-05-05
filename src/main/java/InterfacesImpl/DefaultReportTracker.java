package InterfacesImpl;

import core.ReportResult;
import core.Tracker;
import java.util.Random;

import java.util.HashMap;
import java.util.Map;

public class DefaultReportTracker implements Tracker {
    @Override
    public ReportResult find(String path) {
    	
    	Random rd = new Random();
    	
    	System.out.println(rd);
    	
        Map<String, Boolean> map = new HashMap<>();
        map.put("test1", rd.nextBoolean());
        map.put("test2", rd.nextBoolean());
        map.put("test3", rd.nextBoolean());
        map.put("test4", rd.nextBoolean());
        map.put("test5", rd.nextBoolean());
        ReportResult ret = new ReportResult("US1", map);
        return ret;
    }
}
