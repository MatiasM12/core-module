package core;

import Interfaces.Observer;
import Interfaces.TestSummary;

import java.util.Map;

public class MockVista implements Observer {

    private Map<String, Boolean> tests;
    public MockVista(ObservableTestSummary oble){
        oble.addObserver(this);
        this.tests = oble.getTests();
    }
    @Override
    public void update(Object object) {
        this.tests = ((ConcreteTestSummary) object).getTests();
    }

    public Map<String, Boolean> getTests() {
        return this.tests;
    }
}
