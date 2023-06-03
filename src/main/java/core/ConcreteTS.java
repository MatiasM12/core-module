package core;

import Interfaces.TestSummary;

import java.util.Map;
import java.util.Objects;

public class ConcreteTS implements TestSummary {

	
	public TestSummary tsResult;
	

	@Override
	public TestSummary update(TestSummary ts) {
		
		System.out.println(ts.toString());
		
		this.tsResult = ts;
		return this;
	}
	
	public TestSummary getTS() {
		
		return tsResult;
	}






}
