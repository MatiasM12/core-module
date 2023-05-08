package core;

import java.util.HashSet;
import java.util.Set;

public class TestSummary extends Observable implements core.Observer {
    Set<TestResult> testResultSet;

    TestSummary(){
        this.observers = new HashSet<>();
        this.testResultSet = new HashSet<>();
    }
    protected void setTestResults(Set<TestResult> testResultSet) {
        this.testResultSet = testResultSet;
        notifyObservers(testResultSet);
    }
    public Set<TestResult> getTestResults() {
        return this.testResultSet;
    }

    @Override
    public void update(Object object) {
        if(object.getClass() != testResultSet.getClass()) throw new IllegalArgumentException("Expected TestResult Set");
        setTestResults((Set<TestResult>) object);
    }

    public void attach(Tracker tracker1) {
        tracker1.addObserver(this);
    }
}
