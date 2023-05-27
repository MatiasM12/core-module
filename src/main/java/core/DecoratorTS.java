package core;

import java.util.Map;

public abstract class DecoratorTS implements TestSummary {
	
	protected TestSummary ts;
	
	public DecoratorTS(TestSummary ts) {
		this.ts = ts;
	}

	@Override
	public TestSummary update(Map<String,Boolean> test) {
		return this.ts.update(test);
	}
	
	protected  Map<String, Boolean> getTestSummary(){
		return ((ConcreteTS)this.ts).testResults;
	}

}
