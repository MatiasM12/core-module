package core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Interfaces.TestSummary;

public class TSBADGE implements TestSummary {

	String us;
	Map<String, Boolean> CA;
	Map<String, String> caCategories;
	Boolean badgeResult;

	public TSBADGE(String us, Map<String, Boolean> cA, Map<String, String> caCategories, Boolean badge) {
		super();
		this.us = us;
		this.CA = cA;
		this.caCategories = caCategories;
		this.badgeResult = badge;
	}
	
	 public Boolean getState() {
		 return badgeResult;
	 }
	 
	@Override
	public TestSummary update(TestSummary ts) {
		// TODO Auto-generated method stub
		return ts;
	}
	
	public String getUS() {
		return this.us;
	}

	public Map<String, Boolean> getCA() {
		return this.CA;
	}

	public Map<String, String> getAllCategories() {
		return this.caCategories;
	}
	
	public Set<String> getListOfCategories() {
		return new HashSet<String>(this.caCategories.values());
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
