package coreIC;

import java.util.List;

public class TestReport implements Report{
    List<AcceptanceTest> tests;

    public TestReport(List<AcceptanceTest> testList){
        for (coreIC.AcceptanceTest at : testList ) {
            tests.add(at);
        }
    }


    @Override
    public void setValues(List<Object> values) {
        tests.clear();
        for(Object at : values){
            tests.add((AcceptanceTest) at);
        }
    }
}
