package core;

import Interfaces.TestSummary;

import java.util.Map;

public class TSContainer {
    private final Map<String, TestSummary> testResults;

    public TSContainer(Map<String, TestSummary> testResults){
        this.testResults = testResults;
    }
}
