package trackerImp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import core.ConcreteTestSummary;
import core.ObservableTestSummary;
import core.TestSummary;
import core.Tracker;

public class TrackerHub  implements Tracker{

	
	TestSummary obl;
	String lastResult;
	
	@Override
	public TestSummary hook(String url) {
		Map<String,String> m = new HashMap<String,String>();
		
		lastResult = "PASS";
		m.put("US1", "PASS");
		
		ConcreteTestSummary tsl = new ConcreteTestSummary(m);
		TestSummary obl = new ObservableTestSummary(tsl,m);
		this.obl = obl;
		
		return obl;
	}

	@Override
	public TestSummary newChanges() {
		Map<String,String> m = new HashMap<String,String>();
		
		if(lastResult.equals("PASS")) {
			lastResult = "ERROR";
			m.put("US1", "ERROR");
		}
		else if(lastResult.equals("ERROR")) {
			lastResult = "PASS";
			m.put("US1", "PASS");
		}
		
		System.out.println(m);
		
		
		return this.obl.update(m);
		
	}

}
