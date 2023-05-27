package core;

import java.util.Map;
import java.util.Objects;

public class ConcreteTS implements TestSummary {

	
	public Map<String,Boolean> testResults;
 
	
	@Override
	public TestSummary update(Map<String, Boolean> test) {
		this.testResults = test;
		return this;
	}
}
