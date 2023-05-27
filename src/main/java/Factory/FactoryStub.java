package Factory;

import core.Factory;
import core.TestSummary;

public class FactoryStub implements Factory {

	@Override
	public TestSummary createTS(TestSummary ts,String us,String url) {	
		return new TestSummaryStub(ts);
	}
	
}
