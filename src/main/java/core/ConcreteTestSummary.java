package core;

import jdk.incubator.vector.VectorOperators;

import java.util.Map;

public class ConcreteTestSummary implements TestSummary{
    Dupla<String, Map<String, Boolean>> tests;
    @Override
    public Map<String, Boolean> getTests() {
        return tests.getM();
    }
    @Override
    public void setTests(Map<String, Boolean> map) {
        this.tests.setM(map);
    }
    @Override
    public void setName(String name) {
        this.tests.setT(name);
    }
    @Override
    public String getName() {
        return this.tests.getT();
    }
}
