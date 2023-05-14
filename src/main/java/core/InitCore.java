package core;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class InitCore {

	TrackerFinder trackerFinder;
	String url;
	
	public  InitCore(String url,String findersImplPath){
		this.trackerFinder = new TrackerFinder(findersImplPath);	
	}
	
	
	public Tracker init(String trackerImpl) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		this.trackerFinder.initTrackers();
		Tracker t = trackerFinder.getTracker(trackerImpl);
		t.hook(url);
		return t;
	}
}
