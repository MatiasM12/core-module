package core;

import java.util.Map;

public interface TestSummary {

	//void newChange(TestSummary cts);
	Map<String,Boolean> getTestResults();

	protected void updateTests(TestSummary ts);

}
