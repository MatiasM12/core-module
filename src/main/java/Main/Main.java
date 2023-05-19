package Main;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

import core.CoreInit;
import core.ObservableTestSummary;
import core.TestSummary;
import core.TrackerFinder;

public class Main {
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		
	
		//String findersImplPath = "plugins";
		//String trackerImp = "TrackerHub";
		CoreInit coreInit = new CoreInit();
		TestSummary t = coreInit.init("C:\\Users\\Nicol\\git\\core-module12\\bin\\main\\trackers", "trackers.TrackerTestSummary");
		
		System.out.println(((ObservableTestSummary)t).getTestSummary());
//		Tracker t = (Tracker) coreInit.init(trackerImp);
//
//
//		Timer timer = new Timer();
//		timer.schedule(new TimerTask() {
//			@Override
//			public void run() {
//				t.newChanges();
//			}
//		}, new Date(), 5000);
	}
}
