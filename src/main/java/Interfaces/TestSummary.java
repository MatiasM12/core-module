package Interfaces;

import java.util.Map;

public interface TestSummary {

	void updateTests(Map<String,Boolean> m);
	Map<String, Boolean> getTests();
}
