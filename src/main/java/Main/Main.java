package Main;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import core.ConcreteTestSummary;
import core.CoreInit;
import core.ObservableTestSummary;
import core.TestSummary;
import core.TrackerFinder;

public class Main {
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		
	
		//String findersImplPath = "plugins";
		//String trackerImp = "TrackerHub";
		CoreInit coreInit = new CoreInit();
		TestSummary t = coreInit.init("plugins", "trackers.TrackerTestSummary");		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			int i =0;
			@Override
			public void run() {
				i++;
				Map<String,String> m= new HashMap<String,String>();
				m.put("CA"+i, "PASS");
				System.out.println(((ConcreteTestSummary)t.update(m)).testResults.toString());
			}
		}, new Date(), 5000);
	}
}
