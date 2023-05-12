package core;

import java.util.HashMap;
import java.util.Map;

public class ConcreteTestSummary implements TestSummary {

	 Map<String,Map<String,String>> UsAcceptanceTest;
	
	
	 ConcreteTestSummary(){
		 this.UsAcceptanceTest = new HashMap<String,Map<String,String>>();
	 }
	 
	@Override
	public TestSummary track(String url) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setUS(String s) {
		this.UsAcceptanceTest.put(s, null);
	}

	@Override
	public void setAcceptanceTest(String name,Map<String, String> m) {
		this.UsAcceptanceTest.put(name, m);
		
	}

}
