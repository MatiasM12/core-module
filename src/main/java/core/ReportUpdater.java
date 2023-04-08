package core;

import java.util.ArrayList;

public class ReportUpdater implements Observer{
	
	public Report report;
	
	public ReportUpdater(Report report) {
		super();
		this.report = report;
	}

	public Boolean updateReport() {
		report.successRate=10;
		report.testList= new ArrayList<AcceptanceTest>();
		report.notifyObservers();
		return true;
	}
	
	public void update() {
		updateReport();
		System.out.println("Se actualizo");
	}
}
