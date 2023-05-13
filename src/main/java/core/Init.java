package core;

import java.util.HashMap;
import java.util.Map;

public class Init {

	
	public  Init(String url){
		
		Tracker t = new TrackerHub(url);
		t.hook();
		TestSummary ts = new ConcreteTestSummary(t.hook());
		TestSummary observableTestSummary = new ObservableTestSummary(ts,t.hook());
		}
}
