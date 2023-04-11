package core;

import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.Date;

public class App {
	
	public ArrayList<Observer> observersReport ; 
	public FileUpdateChecker checker ;  	
	public Report report; 
	public ReportUpdater updater;
	File archivo = new File("mock.txt");

	public App() { 
		
		this.observersReport = new ArrayList<Observer>();
		ArrayList<AcceptanceTest> testList = getTestList();
		
		this.report = new Report(observersReport, 90, testList);
		this.updater = new ReportUpdater(report);
		this.checker = new FileUpdateChecker(archivo,updater);
		
	}
 
	public void initChecker() {
		Timer timer = new Timer();
		timer.schedule( this.checker , new Date() , 5000 );
	}
	
	//hardcodeado
	private ArrayList<AcceptanceTest> getTestList() {
		ArrayList<AcceptanceTest> list = new ArrayList<AcceptanceTest>();
		list.add(new AcceptanceTest("Test 1", true));
		list.add(new AcceptanceTest("Test 2", false));
		return list;
	}

}
