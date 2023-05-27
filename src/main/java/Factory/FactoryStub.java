package Factory;

import core.ConcreteTestSummary;
import core.Factory;
import core.ObservableTestSummary;
import core.TestSummary;
import trackers.TestSummaryStub;

public class FactoryStub implements Factory {

	@Override
	public TestSummary createTS(TestSummary ts,String us,String url) {	
		TestSummary tsStub = new TestSummaryStub(ts);
		return tsStub;
	}
	
	
	
	
}
