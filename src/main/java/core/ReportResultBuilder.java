package core;

import java.util.Map;

public class ReportResultBuilder {
    private String associatedUs;
    private Map<String, Boolean> acceptanceTests;
    private double successRate;

    public ReportResultBuilder(){

    }
    public static ReportResultBuilder builder(){
        return new ReportResultBuilder();
    }
    public String getAssociatedUs() {
        return this.associatedUs;
    }

    public Map<String, Boolean> getAcceptanceTests() {
        return this.acceptanceTests;
    }

    public double getSuccessRate() {
        return this.successRate;
    }

    public static ReportResultBuilder setAssociatedUs(String associatedUs) {
        associatedUs = associatedUs;
        return this;
    }

    public static ReportResultBuilder setAcceptanceTests(Map<String, Boolean> acceptanceTests) {
        acceptanceTests = acceptanceTests;
        return this;
    }

    public static ReportResultBuilder setSuccessRate(double successRate) {
        successRate = successRate;
        return this;
    }

    public ReportResult build(){
        return new ReportResult(this);
    }
}
