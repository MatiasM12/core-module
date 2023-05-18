package core;

import java.util.Map;

public interface TestSummary {

	void newChange(Map<String,String> m);
	Map<String,String> getTestResults();

}
