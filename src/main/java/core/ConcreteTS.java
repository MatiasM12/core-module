package core;

import Interfaces.TestSummary;

import java.util.Map;
import java.util.Objects;

public class ConcreteTS implements TestSummary {

	
	public Map<String,Boolean> testResults;
	

	@Override
	public void update(Map<String, Boolean> m) {
		this.testResults = m;
	}

}
