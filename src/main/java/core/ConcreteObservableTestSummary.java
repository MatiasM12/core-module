package core;

import java.util.Map;

public class ConcreteObservableTestSummary extends Observable implements TestSummary {

	TestSummary ts;
	
	public ConcreteObservableTestSummary(TestSummary concrete) {
		this.ts = concrete;
		
		System.out.println("Le avise a todos");
		this.notifyObservers("objeto aviso");
	}

	@Override
	public TestSummary track(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUS(String s) {
		this.setUS(s);
		
	}

	@Override
	public void setAcceptanceTest(String s, Map<String, String> m) {
		this.setAcceptanceTest(s, m);
		
	}  
	
	

}
