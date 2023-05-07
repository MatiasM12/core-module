package core;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestSummaryProxy implements TestSummary{
    TestSummary testSummary;
    TestSummaryProxy(TestSummary testSummary){
        this.testSummary = testSummary;
    }
    @Override
    public Map<String, Boolean> getTests() {
        return testSummary.getTests();
    }
    @Override
    public void setTests(Map<String, Boolean> map) {
        testSummary.setTests(map);
    }
    @Override
    public void setName(String name) {
        this.testSummary.setName(name);
    }
    @Override
    public String getName() {
        return this.testSummary.getName();
    }
}
