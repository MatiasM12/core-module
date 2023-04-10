package core;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Core {
	
	public ArrayList<Observer> observersChecker ; 
	public ArrayList<Observer> observersReport ; 
	public FileUpdateChecker checker ;  	
	public Report report; 
	public ReportUpdater updater;

	public void init() { //yo creo que esto esta mal pero fue la forma de probarlo en el momento jaja
		
		this.observersChecker = new ArrayList<Observer>();
		this.observersReport = new ArrayList<Observer>();
		this.checker = new FileUpdateChecker("mock.text", observersChecker);
		this.report = new Report(observersReport, 100, null);
		this.updater = new ReportUpdater(report);

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
