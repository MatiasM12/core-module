package core;

import java.util.Map;

public class ObserverTestSummary extends TestSummaryDecorator implements Observer {
    ObserverTestSummary(TestSummary testSummary) {
        super(testSummary);
    }
    @Override
    public Map<String, Boolean> getTests() {
        return this.testSummary.getTests();
    }
    @Override
    public void setTests(Map<String, Boolean> map) {
        this.testSummary.setTests(map);
    }
    @Override
    public void setName(String name) {
        this.testSummary.setName(name);
    }
    @Override
    public String getName() {
        return this.testSummary.getName();
    }
    @Override
    public void update(Object object) {
        Dupla<String, Map<String, Boolean>> tests = (Dupla<String, Map<String, Boolean>>) object;
        this.setTests(tests.getM());
        this.setName(tests.getT());
    }
}
