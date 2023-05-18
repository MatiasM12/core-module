package core;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class CoreInit {

	public CoreInit(String url, String findersImplPath){
	}
	public ObservableTestSummary init(String findersImplPath, String url) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		TrackerFinder trackerFinder = new TrackerFinder();
		Set<Tracker> trackerSet = trackerFinder.find(findersImplPath);
//		Tracker t = trackerFinder.getTracker(trackerSet, trackerImpl);
		Tracker tracker = trackerFinder.getOneTracker(trackerSet);
		if(tracker != null){
			ConcreteTestSummary ts = tracker.hook(url);
			ObservableTestSummary ObleTS = new ObservableTestSummary(ts);
			ObserverTestSummary OverTS = new ObserverTestSummary(ObleTS);
			tracker.addObserver(OverTS);
			return ObleTS;
		}else {
			throw new RuntimeException("No se encontro ningun plugin");
		}
	}
}
