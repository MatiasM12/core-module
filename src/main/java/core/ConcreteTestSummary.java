package core;

import java.util.Map;

public class ConcreteTestSummary implements TestSummary {

	
	public Map<String,Boolean> testResults;
 
	 public ConcreteTestSummary(Map<String,Boolean> m){
		 this.testResults = m;
	 }
	@Override
	 public Map<String, Boolean> getTestResults() {
		return this.testResults;
	}

	@Override
	public void updateTests(TestSummary ts) {
		testResults = ts.getTestResults();
	}


//
//	@Override
//	public TestSummary update(Map<String, String> m) {
//		this.testResults = m;
//		return this;
//	}
//
//	@Override
//		public int hashCode() {
//			return Objects.hash(testResults);
//		}
//	@Override
//		public boolean equals(Object obj) {
//			if (obj == null)
//				return false;
//			ConcreteTestSummary other = (ConcreteTestSummary) obj;
//
//			System.out.println(testResults.toString());
//			System.out.println(other.testResults.toString());
//
//			return Objects.equals(testResults, other.testResults);
//		}
}
