package Imp;

import java.util.Map;

import Interfaces.TestSummary;

public class TSResultDefault implements TestSummary {

	String us;
	Map<String,Boolean> CA;
	public TSResultDefault(String us, Map<String, Boolean> cA) {
		super();
		this.us = us;
		this.CA = cA;
	}
	
	
	@Override
	public TestSummary update(TestSummary ts) {
		return ts ;
	}

}
