package core;

import Interfaces.Observer;

import java.util.Map;

public class MockVista implements Observer {

    private Map<String, Boolean> tests;
    public MockVista(ObservableTS oble){
        oble.addObserver(this);
        this.tests = oble.getTests();
    }
    @Override
    public void update(Object object) {
        this.tests = ((ConcreteTS) object).getTests();
    }

    public Map<String, Boolean> getTests() {
        return this.tests;
    }
}
