package core;

import Interfaces.TestSummary;

public class TSBADGE implements TestSummary {

	String us;
	Boolean badge;
	
	
	public TSBADGE(String us,Boolean badge){
		this.us = us;
		this.badge = badge;
		
	}
	public TestSummary update(TestSummary ts) {
		// TODO Auto-generated method stub
		return ts;
	}

}
