package Main;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

import core.CoreInit;
import core.TrackerFinder;

public class Main {
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		TrackerFinder t = new TrackerFinder();
		//System.out.println(t.getOneTracker(new HashSet<>()));

//		String findersImplPath = "plugins";
//		String trackerImp = "TrackerHub";
//		CoreInit coreInit = new CoreInit("stub",findersImplPath);
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
