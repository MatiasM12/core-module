package core;

import java.util.Map;
import java.util.Objects;

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
	
	@Override
		public int hashCode() {
			return Objects.hash(usAcceptanceTest);
		}
	@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			ConcreteTestSummary other = (ConcreteTestSummary) obj;
			
			System.out.println(usAcceptanceTest.toString());
			System.out.println(other.usAcceptanceTest.toString());
			
			return Objects.equals(usAcceptanceTest, other.usAcceptanceTest);
		}
	
	
	 

}
