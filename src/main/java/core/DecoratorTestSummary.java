package core;

import java.util.Map;

public abstract class DecoratorTestSummary implements TestSummary {
	
	TestSummary ts;
	
	public DecoratorTestSummary(TestSummary s) {
		this.ts = s;
	}

	@Override
	public TestSummary update(Map<String,String> s) {
		return this.ts.update(s);
	}

}
