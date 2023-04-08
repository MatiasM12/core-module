package core;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Init {
	
	public ArrayList<Observer2> observers ; 	
	public FileUpdateChecker checker ;

	public Init() { //yo creo que esto esta mal pero fue la forma de probarlo en el momento jaja
		
		this.observers = new ArrayList<Observer2>();
		this.checker = new FileUpdateChecker("mock.text", observers);

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
