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
	int nCa;
	
	@Override
	public TestSummary hook(String url) {
		nCa = 1;
		
		Map<String,String> m = new HashMap<String,String>();
		m.put("US1", "CA "+nCa);
		
		ConcreteTestSummary tsl = new ConcreteTestSummary(m);
		TestSummary obl = new ObservableTestSummary(tsl,m);
		this.obl = obl;
		
		return obl;
	}

	@Override
	public TestSummary newChanges() {
		
		nCa++;
		
		
		Map<String,String> m = new HashMap<String,String>();
		m.put("US1", "CA "+nCa);
		System.out.println(m.toString());
		
		return this.obl.update(m);
		
	}

}
