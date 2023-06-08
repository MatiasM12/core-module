package core;

import Interfaces.TestSummary;

import java.util.Set;

public class TSNameExtractor {
	
	public String[] extractNames(Set<TestSummary> tsSet) {
		String[] names = new String[tsSet.size()];
		int count = 0;
		for (TestSummary ts : tsSet) {
			String name = ts.getClass().getName();
			names[count++] = name;
		}
		return names;
	}
}
