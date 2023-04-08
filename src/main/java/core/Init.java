package core;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Init {

	public static void init() {
		ArrayList<Observer> observers = new ArrayList<Observer>(); 
		FileUpdateChecker checker = new FileUpdateChecker("mock.text", observers);


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
