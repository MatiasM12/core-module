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

	@Override
	public TestSummary hook(String url) {
		
		Map<String,String> m = new HashMap<String,String>();
		m.put("US1", "CA 1");
		
		ConcreteTestSummary tsl = new ConcreteTestSummary(m);
		TestSummary obl = new ObservableTestSummary(tsl,m);
		this.obl = obl;
		
		return obl;
	}

	@Override
	public TestSummary newChanges() {
		
		Map<String,String> m = new HashMap<String,String>();
		m.put("US1", "CA 3");
		
		return this.obl.update(m);
		
	}

}
