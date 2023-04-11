package core;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class App {
	
	public ArrayList<Observer> observersChecker ; 
	public ArrayList<Observer> observersReport ; 
	public FileUpdateChecker checker ;  	
	public Report report; 
	public ReportUpdater updater;

	public App(ArrayList<Observer> observersChecker,ArrayList<Observer> observersReport,FileUpdateChecker checker,Report report,ReportUpdater updater) { 
		
		this.observersChecker = observersChecker;
		this.observersReport = observersReport;
		this.checker = checker;
		this.report = report;
		this.updater = updater;

		checker.addObserver(updater);

	}

	public void initChecker() {
		//cada 5 segundos chequea cambios
		Timer timer = new Timer();
		int delay = 1000; 
		int interval = 5000; 
		timer.scheduleAtFixedRate(new TimerTask() {
		public void run() {
		    checker.check();
		  }
		}, delay, interval);
	}
}
