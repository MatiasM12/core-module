package mocks;

import java.util.Map;

import Interfaces.TestSummary;

public class TSWithCategories implements TestSummary {

	public String us;
	public Map <String,Boolean> ca;
	public Map <String,String> caCategories;
	 
	public TSWithCategories(String us, Map<String, Boolean> ca,Map <String,String> caCategories) {
		this.us = us;
		this.ca = ca;
		this.caCategories = caCategories;
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
	

	
	public Map <String,String> getCategories() {
		return this.caCategories;
	}

}
