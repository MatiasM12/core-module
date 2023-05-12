package core;

import java.util.Map;

public class TestSummaryTrackerHub  implements TestSummary{

	TestSummary ts; 
	
	
	
	@Override
	public TestSummary track(String url) {
		// TODO Auto-generated method stub
		return new ConcreteTestSummary();
	}

	
	@Override
	public void setUS(String s) {
		this.ts.setUS(s);
		
	}

	@Override
	public void setAcceptanceTest(String s, Map<String, String> m) {
		this.ts.setAcceptanceTest(s, m);
		
	}

}
