package core;

import java.util.Map;
import java.util.Objects;

public class ConcreteTS implements TestSummary {

	
	public Map<String,Boolean> testResults;
 
	
	@Override
	public TestSummary update(Map<String, Boolean> m) {
		this.testResults = m;
		return this;
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
