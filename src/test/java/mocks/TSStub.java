package mocks;

import java.util.Map;

import Interfaces.TestSummary;

public class TSStub implements TestSummary {

	public String us;
	public Map <String,Boolean> ca;
	 
	public TSStub(String us, Map<String, Boolean> ca) {
		this.us = us;
		this.ca = ca;
	}

	@Override
	public TestSummary update(TestSummary ts) {
		return this;
	}
	
	public Map<String,Boolean>  getCA(){
		return this.ca;
	}
	
	public int sizeCA(){
		return this.ca.size();
	}

}
