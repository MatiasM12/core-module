package core;

import java.util.Map;

public class TestSummaryTrackerHub implements  TestSummary, Observer{

	TestSummary ts; 
	
	
	
	@Override
	public TestSummary track(String url) {
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


	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

}
