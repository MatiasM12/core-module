package core;

import java.util.ArrayList;

public class ReportUpdater {
	
	public Report report;
	public FileUpdateChecker fileChecker;
	
	public ReportUpdater(Report report) {
		super();
		this.report = report;
	}
	
	public ReportUpdater(Report report2, String string) {
		this.report = report2;
		this.fileChecker = new FileUpdateChecker(string);
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
