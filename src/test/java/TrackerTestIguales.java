
import java.util.HashMap;
import java.util.Map;

import core.ConcreteTestSummary;
import core.ObservableTestSummary;
import core.TestSummary;
import core.Tracker;

public class TrackerTestIguales implements Tracker{

	TestSummary obl;
	
	@Override
	public TestSummary hook(String url) {
		Map<String,String> m = new HashMap<String,String>();
		m.put("US1", "PASS");
		
		ConcreteTestSummary tsl = new ConcreteTestSummary(m);
		TestSummary obl = new ObservableTestSummary(tsl,m);
		this.obl = obl;
		
		return obl;
	}
	@Override
	public TestSummary newChanges() {
		Map<String,String> m = new HashMap<String,String>();
		m.put("US1", "PASS");
		return this.obl.update(m);
	}

}
