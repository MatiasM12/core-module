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
		ArrayList<AcceptanceTest> testList = new ArrayList<AcceptanceTest>();
		AcceptanceTest test = new AcceptanceTest("Test 1",true);
		testList.add(test);
		report.testList= testList;
		report.notifyObservers();
		return true;
	}
	
	public void update() {
		updateReport();
		System.out.println("Se actualizo");
	}
}
