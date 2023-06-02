package core;

import java.util.Map;
import java.util.Objects;

import interfaces.USTestSummary;

public class ConcreteTS implements USTestSummary {

	
	public Map<String,Boolean> testResults;
	public ConcreteTS(Map<String,Boolean> testRestults){
		this.testResults = testRestults;
	} 

	@Override
	public void updateTests(Map<String, Boolean> m) {
		this.testResults = m;
		System.out.println(m);
	}

	@Override
	public Map<String, Boolean> getTests() {
		return this.testResults;
	}

	@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			ConcreteTS other = (ConcreteTS) obj;

			System.out.println(testResults.toString());
			System.out.println(other.testResults.toString());

			return Objects.equals(testResults, other.testResults);
		}


}