package core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.Date;

public class App {
	
	public ArrayList<Observer> observersChecker ; 
	public ArrayList<Observer> observersReport ; 
	public FileUpdateChecker checker ;  	
	public Report report; 
	public ReportUpdater updater;
	File archivo = new File("mock.txt");

	public App() { 
		
		this.observersReport = new ArrayList<Observer>();
		
		this.report = new Report(observersReport, 100, null);
		this.updater = new ReportUpdater(report);
		this.checker = new FileUpdateChecker(archivo,updater);
		
	}
 
	public void initChecker() {
		//cada 5 segundos chequea cambios
		Timer timer = new Timer();
		timer.schedule( this.checker ,new Date(), 5000 );
	}
}
