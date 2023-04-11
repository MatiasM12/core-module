package core;

import java.util.ArrayList;

public class ReportUpdater {
	
	public Report report;
	
	public ReportUpdater(Report report) {
		super();
		this.report = report;
	}

	public Boolean updateReport() {
		report.successRate = 10;
		report.testList = new ArrayList<AcceptanceTest>();;
		report.notifyObservers();
		System.out.println("Se actualizo");
		return true;
	}
	
}
