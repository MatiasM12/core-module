package mocks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Interfaces.TestSummary;

public class TSWithCategories implements TestSummary {

	public String us; 
	public Map<String,Boolean> CA;
	public Map<String,String> caCategories;
	
	public TSWithCategories(String us, Map<String, Boolean> cA, Map<String,String> caCategories) {
		this.us = us;
		this.CA = cA;
		this.caCategories = caCategories;
	}
	
	
	@Override
	public TestSummary update(TestSummary ts) {
		return ts ;
	}
	
	
	public String getUS() {
		return this.us;
	}
	
	public Map <String,Boolean> getCA() {
		return this.CA;
	}
	
	public Map <String,String> getAllCategories() {
		return this.caCategories;
	}
	
	public Set<String> getListOfCategories() {
		return new HashSet<String>(this.caCategories.values());
	}
	
	public int getSizeOfCategories() {
		return getAllCategories().size();
	}
	
	public String getCategoryOf(String ca) {
		return this.caCategories.get(ca);
	}
	
	public List<String> getCAsByCategory(String category){
		List<String> keys = new ArrayList<>();
		for (String key : caCategories.keySet()) {
			if (caCategories.get(key).equals(category)) {
				keys.add(key);
			}
		}
		return keys;
	}
	
	
}