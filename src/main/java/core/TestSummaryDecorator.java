package core;

import java.util.Map;

public abstract class TestSummaryDecorator implements TestSummary{
    TestSummary testSummary;
    TestSummaryDecorator(TestSummary testSummary){
        this.testSummary = testSummary;
    }
}
