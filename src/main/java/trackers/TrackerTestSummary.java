package trackers;

import java.util.Map;

import core.ConcreteTestSummary;
import core.TestSummary;

public class TrackerTestSummary implements TestSummary {

	@Override
	public TestSummary update(Map<String, String> m) {
		
		return new ConcreteTestSummary();
	}

}
