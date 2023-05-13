package core;

import java.util.Map;

public class ConcreteTestSummary implements TestSummary {

	 public Map<String,String> usAcceptanceTest;
 
	 public ConcreteTestSummary(Map<String,String> m){
		 this.usAcceptanceTest = m;
	 }
	@Override
	public TestSummary update(Map<String, String> m) {
		this.usAcceptanceTest = m;
		return this;
	}
	 

}
