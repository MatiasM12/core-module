package core;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Core {
	
	public ArrayList<Observer> observers ; 	
	public FileUpdateChecker checker ;  	
	public Report report; 
	public ReportUpdater updater;

	public void Init() { //yo creo que esto esta mal pero fue la forma de probarlo en el momento jaja
		
		this.observers = new ArrayList<Observer>();
		this.checker = new FileUpdateChecker("mock.text", observers);
		this.report = new Report(observers, 100, null);
		this.updater = new ReportUpdater(report);

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
