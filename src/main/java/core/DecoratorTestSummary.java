package core;

import java.util.Map;

public abstract class DecoratorTestSummary implements TestSummary {
	
	protected TestSummary ts;
	
	public DecoratorTestSummary(TestSummary s) {
		this.ts = s;
	}

	@Override
	public TestSummary update(Map<String,Boolean> s) {
		return this.ts.update(s);
	}
	
	protected  Map<String, Boolean> getTestSummary(){
		return ((ConcreteTestSummary)this.ts).testResults;
	}

}
