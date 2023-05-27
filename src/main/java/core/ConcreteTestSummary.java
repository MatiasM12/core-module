package core;

import Interfaces.TestSummary;

import java.util.Map;
import java.util.Objects;

public class ConcreteTestSummary implements TestSummary {

	
	public Map<String,Boolean> testResults;
	public ConcreteTestSummary(Map<String,Boolean> testRestults){
		this.testResults = testRestults;
	}

	@Override
	public void updateTests(Map<String, Boolean> m) {
		this.testResults = m;
	}

	@Override
	public Map<String, Boolean> getTests() {
		return this.testResults;
	}

	@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			ConcreteTestSummary other = (ConcreteTestSummary) obj;

			System.out.println(testResults.toString());
			System.out.println(other.testResults.toString());

			return Objects.equals(testResults, other.testResults);
		}
}
