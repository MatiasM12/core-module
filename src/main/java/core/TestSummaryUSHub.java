package core;

import java.util.Map;

public class TestSummaryUSHub extends DecoratorTestSummary{

	TestSummary ts;
	
	public TestSummaryUSHub(TestSummary concrete) {
	
		this.ts = concrete;
		
		
		this.setUS("US1");
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
