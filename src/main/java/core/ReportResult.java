package core;

import java.util.Map;
import java.util.Objects;

public class ReportResult {
    public String associatedUs;
    public Map<String,Boolean> acceptanceTests;
    public ReportResult(String associatedUs, Map<String , Boolean> acceptanceTests) {
        this.associatedUs = associatedUs;
        this.acceptanceTests = acceptanceTests;
    }
    public String getAssociatedUs() {
        return associatedUs;
    }

    public Map<String,Boolean> getTests() {
        return acceptanceTests;
    }

    @Override
    public int hashCode() {
        return Objects.hash(acceptanceTests, associatedUs);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReportResult other = (ReportResult) obj;
        return Objects.equals(acceptanceTests, other.acceptanceTests)
                && Objects.equals(associatedUs, other.associatedUs);
    }
}
