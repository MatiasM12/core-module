package core;

import java.util.Map;
import java.util.Objects;

public class ReportResult {
    public String associatedUs;
    public Map<String,Boolean> acceptanceTests;
    public double successRate;
    private ReportResult(ReportResultBuilder reportResultBuilder){
        this.associatedUs = reportResultBuilder.associatedUs;
        this.acceptanceTests = reportResultBuilder.acceptanceTests;
        this.successRate = reportResultBuilder.successRate;
    }
    public String getAssociatedUs() {
        return associatedUs;
    }

    public Map<String,Boolean> getTests() {
        return acceptanceTests;
    }

    public double getSuccessRate() {
        return successRate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(acceptanceTests, associatedUs, successRate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return false;
/*        ReportResult other = (ReportResult) obj;
        return Objects.equals(acceptanceTests, other.acceptanceTests)
                && Objects.equals(associatedUs, other.associatedUs)
                && Double.doubleToLongBits(successRate) == Double.doubleToLongBits(other.successRate);*/
    }

    public static class ReportResultBuilder{
        public String associatedUs;
        public Map<String,Boolean> acceptanceTests;
        public double successRate;

        public static ReportResultBuilder builder() {
            return new ReportResultBuilder();
        }
        private ReportResultBuilder(){
        }
        public ReportResultBuilder setAssociatedUs(String associatedUs){
            this.associatedUs = associatedUs;
            return this;
        }
        public ReportResultBuilder setAcceptanceTests(Map<String, Boolean> acceptanceTests){
            this.acceptanceTests = acceptanceTests;
            return this;
        }
        public ReportResultBuilder setSuccessRate(double successRate){
            this.successRate = successRate;
            return this;
        }
        public ReportResult build(){
            return new ReportResult(this);
        }
    }
}
