package core;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;

public class ReportUpdater2 {
	
	public Report report;
	public FileUpdateChecker fileChecker;
	public ReportUpdater2(Report report) {
		super();
		this.report = report;
	}
	
	public ReportUpdater2(Report report, String filePath) {
		this.report = report;
		this.fileChecker = new FileUpdateChecker(filePath);
		initChecker();
	}

	public void initChecker() {
		Timer timer = new Timer();
		timer.schedule(this.fileChecker , new Date() , 5000 );
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
