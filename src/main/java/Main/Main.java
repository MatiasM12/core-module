package Main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import core.InitCore;
import core.Tracker;

public class Main {
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		String findersImplPath = "plugins";
		String trackerImp = "TrackerHub";
		InitCore initCore = new InitCore("stub",findersImplPath);
		Tracker t = initCore.init(trackerImp);
		
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				t.newChanges();
			}
		}, new Date(), 5000); 
	}
}
