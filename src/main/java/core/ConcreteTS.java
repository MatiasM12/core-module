package core;

import Interfaces.TestSummary;


public class ConcreteTS implements TestSummary {

	
	public TestSummary tsResult;
	

	@Override
	public TestSummary update(TestSummary ts) {
		this.tsResult = ts;
		return tsResult;
	}
	
	public TestSummary getTS() {
		
		return tsResult;
	}






}
