package core;

public class ReportUpdater {
	
	public Report report;
	
	public ReportUpdater(Report report) {
		super();
		this.report = report;
	}

	public void updateReport() {
		report.successRate = 95;
		report.testList.add(new AcceptanceTest("Test 3",true));
		report.notifyObservers();
	}
	
}
