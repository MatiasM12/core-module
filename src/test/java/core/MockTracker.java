package core;


import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class MockTracker extends Tracker {
    Set<TestResult> testResultSet;
    Boolean flag;

    public MockTracker(){
        this.testResultSet = new HashSet<>();
        this.flag = true;
    }
    public void ningunTest(){
        this.testResultSet.clear();
        super.notifyObservers(testResultSet);
    }

    public void unSoloTest(){
        this.testResultSet.clear();
        this.testResultSet.add(new TestResult("test1",true));
        super.notifyObservers(this.testResultSet);
    }

    public void unoCambia() {

    }

    @Override
    public void track(String path) throws FileNotFoundException {

    }
}
