package core;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Set;

public class CoreInit {
	
	public CoreInit() {}

	public TestSummary init(String findersImplPath,String trackerName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		TrackerFinder trackerFinder = new TrackerFinder();
		Set<TestSummary> trackerSet = trackerFinder.find(findersImplPath);
		TrackerObtainer to = new TrackerObtainer();
		TestSummary tracker = to.getTracker(trackerSet,trackerName);
		HashMap<String,String> s = new HashMap<String,String>();
		s.put("holis", "gordis");
		TestSummary  ts = new ObservableTestSummary(tracker.update(s)); 
		return  ts;		
	}
}
