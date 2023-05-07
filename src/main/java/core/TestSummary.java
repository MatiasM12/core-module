package core;

import java.util.HashSet;
import java.util.Set;

public class TestSummary extends Observable implements Observer {
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
        setTestResults((Set<TestResult>) object);
    }
}
