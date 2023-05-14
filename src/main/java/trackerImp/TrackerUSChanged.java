package trackerImp;

import java.util.HashMap;
import java.util.Map;

import core.ConcreteTestSummary;
import core.ObservableTestSummary;
import core.TestSummary;
import core.Tracker;

public class TrackerUSChanged implements Tracker{

	TestSummary obl;
	int intUS;
	
	@Override
	public TestSummary hook(String url) {
		intUS=1;
		Map<String,String> m = new HashMap<String,String>();
		m.put("US1", "CA 1");
		
		ConcreteTestSummary tsl = new ConcreteTestSummary(m);
		TestSummary obl = new ObservableTestSummary(tsl,m);
		this.obl = obl;
		return obl;
	}
	@Override
	public TestSummary newChanges() {
		intUS++;
		Map<String,String> m = new HashMap<String,String>();
		m.put("US"+intUS, "CA 1");
		return this.obl.update(m);
	}

}
