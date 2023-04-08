package core;

import java.util.ArrayList;

public class ReportUpdater implements Observer{
	
	Report report = new Report();
	
	public ReportUpdater() {
		super();
	}

	public Boolean updateReport() {
		report.successRate=10;
		report.testList= new ArrayList<AcceptanceTest>();
		update();
		return true;
	}
	
	public void update() {
		System.out.println("Se actualizo");
	}
}
