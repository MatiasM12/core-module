package core;

import java.util.Map;

public class ObservableTestSummary extends ObservableTestSummaryDecorator{
    TestSummary testSummary;
    ObservableTestSummary(TestSummary testSummary){
        super(testSummary);
        this.testSummary = testSummary;
    }
    @Override
    public Map<String, Boolean> getTests() {
        return this.testSummary.getTests();
    }
    @Override
    public void setTests(Map<String, Boolean> map) {
        this.testSummary.setTests(map);
        notifyObservers(testSummary);
    }
    @Override
    public void setName(String name) {
        this.testSummary.setName(name);
        notifyObservers(testSummary);
    }
    @Override
    public String getName() {
        return this.testSummary.getName();
    }
}
