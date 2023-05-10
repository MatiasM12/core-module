package core;

import java.util.HashSet;
import java.util.Map;

public abstract class ObservableTestSummaryDecorator extends Observable implements TestSummary{
    TestSummary testSummary;
    ObservableTestSummaryDecorator(TestSummary testSummary){
        this.observers = new HashSet<>();
        this.testSummary = testSummary;
    }
}
