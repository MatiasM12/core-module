package core;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class CoreInit {

	public CoreInit(String url, String findersImplPath){
	}
	public TestSummary init(String findersImplPath,String trackerName, String url) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		TrackerFinder trackerFinder = new TrackerFinder();
		Set<Tracker> trackerSet = trackerFinder.find(findersImplPath);
		TrackerObtainer to = new TrackerObtainer();
		
		
		Tracker tracker = to.getTracker(trackerSet,trackerName);
		TestSummary ts = tracker.hook(url);
		TestSummary ObleTS = new ObservableTestSummary(ts);
		TestSummary OverTS = new ObserverTestSummary(ObleTS);
		tracker.addObserver((ObserverTestSummary)OverTS);
		return ObleTS;
		
	}
}
