package interfaces;

import java.util.Map;

public interface USTestSummary {

	void updateTests(Map<String,Boolean> m);
	Map<String, Boolean> getTests();
}
