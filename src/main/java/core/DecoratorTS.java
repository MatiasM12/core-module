package core;

import java.util.Map;

public abstract class DecoratorTS implements TestSummary {
	
	protected TestSummary ts;
	
	public DecoratorTS(TestSummary s) {
		this.ts = s;
	}

	@Override
	public TestSummary update(Map<String,Boolean> s) {
		return this.ts.update(s);
	}
	
	protected  Map<String, Boolean> getTestSummary(){
		return ((ConcreteTS)this.ts).testResults;
	}

}
