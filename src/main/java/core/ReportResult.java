package core;

import netscape.javascript.JSObject;

import java.util.Map;

public class ReportResult {
    private String associatedUs;
    private Map<String, Boolean> acceptanceTests;
    private double successRate;
    //es el objeto reporte en nuestro sistema. Es mutable
    public ReportResult(ReportResultBuilder reportResultBuilder) {
        this.associatedUs = reportResultBuilder.getAssociatedUs();
        this.acceptanceTests = reportResultBuilder.getAcceptanceTests();
        this.successRate = reportResultBuilder.getSuccessRate();
        //transforma el JSObject en la variables de instancia que definamos aca
    }

    public String getAssociatedUs() {
        return associatedUs;
    }

    public Map<String, Boolean> getAcceptanceTests() {
        return this.acceptanceTests;
    }

    public double getSuccessRate() {
        return this.successRate;
    }
}
