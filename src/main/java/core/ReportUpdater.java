package core;

import java.util.ArrayList;

public class ReportUpdater {
	
	public Report report;
	public FileUpdateChecker fileChecker;

	public ReportUpdater(Report report) {
		super();
		this.report = report;
	}
	
	public ReportUpdater(Report report, String filePath) {
		this.report = report;
		this.fileChecker = new FileUpdateChecker(filePath);
	}

	public void update(Report reporte) {
		updateReport();
		System.out.println("Se actualizo");
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
