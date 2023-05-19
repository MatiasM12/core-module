package core;

import java.util.Map;

public class TrackerTestSummary implements TestSummary {

	@Override
	public TestSummary update(Map<String, String> m) {
		
		return new ConcreteTestSummary(m);
	}

}
