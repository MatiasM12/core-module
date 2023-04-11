package core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

public class App {
	
	public ArrayList<Observer> observersChecker ; 
	public ArrayList<Observer> observersReport ; 
	public FileUpdateChecker checker ;  	
	public Report report; 
	public ReportUpdater updater;

	public App() { 
		
        File archivo = new File("mock.txt");
		
		this.observersReport = new ArrayList<Observer>();
		this.checker = new FileUpdateChecker(archivo);
		this.report = new Report(observersReport, 100, null);
		this.updater = new ReportUpdater(report);

	}

	public void initChecker() {
		//cada 5 segundos chequea cambios
		Timer timer = new Timer();
		timer.schedule( this.checker , 5000 );
	}
}
