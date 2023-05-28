package core;

import Interfaces.Observer;

import java.util.HashMap;
import java.util.Map;

public class MockVista implements Observer {

    private Map<String, Boolean> tests;
    public MockVista(ObservableTS oble){
        oble.addObserver(this);
        this.tests = new HashMap<>();
        this.tests.putAll(oble.getTests());
    }
    @Override
    public void update(Object object) {
        this.tests.clear();
        this.tests.putAll((Map<String,Boolean>) object);
    }

    public Map<String, Boolean> getTests() {
        return this.tests;
    }
}
