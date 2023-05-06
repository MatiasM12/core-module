package core;

import java.util.Set;

public class NewCore extends Observable implements Observer{
    Set<TestResult> testResultSet;
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
