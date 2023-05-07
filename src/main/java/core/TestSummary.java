package core;

import java.util.Map;

public interface TestSummary{
    Map<String, Boolean> getTests();
    void setTests(Map<String, Boolean> map);
    void setName(String name);
    String getName();
}
