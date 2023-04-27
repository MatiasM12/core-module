package InterfacesImpl;

import core.Finder;
import core.ReportResult;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DefaultFinder implements Finder {

    @Override
    public ReportResult find(URL path) {
        Map<String, Boolean> map = new HashMap<>();
        map.put("test1", true);
        map.put("test2", true);
        map.put("test3", false);
        return ReportResult.ReportResultBuilder.builder()
                .setAcceptanceTests(map)
                .setSuccessRate(98.8D)
                .setAssociatedUs("US1")
                .build();
    }
}
