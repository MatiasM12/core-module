package mocks;

import Interfaces.TestSummary;

public class TSBadge implements TestSummary {

	String us;
	Boolean badgeResult;
	
	public TSBadge(String us, Boolean b) {
		this.us = us;
		this.badgeResult = b;
	}
	
	@Override
	public TestSummary update(TestSummary ts) {
		// TODO Auto-generated method stub
		return ts;
	}
	
	
	 public Boolean getState() {
		 
		 return badgeResult;
	 }

}
