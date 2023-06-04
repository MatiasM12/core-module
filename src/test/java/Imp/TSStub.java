package Imp;

import java.util.Map;

import Interfaces.TestSummary;

public class TSStub implements TestSummary {

	public String us;
	public Map <String,Boolean> CA;
	
	
	
	public TSStub(String us2, Map<String, Boolean> CA) {
		
		System.out.println(us2+"----"+CA.toString());
		
		this.us = us2;
		this.CA = CA;
	}

	@Override
	public TestSummary update(TestSummary ts) {
		// TODO Auto-generated method stub
		return this;
	}
	
	public Map<String,Boolean>  getCA(){
		
		return this.CA;
	}
	
	public int sizeCA(){
		
		return this.CA.size();
	}
	
	

}
