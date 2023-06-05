package breaker;

import Interfaces.TestSummary;

public class CBOrigin {
	 State state; 
	 int failureThreshold;
	 int retryInterval;
	 int failureCount;
	 long lastFailure;
	 
	 
	 public Response makeRequest(TestSummary ts) {
		 
		 return new Response();
	 }

	 public void open() {}

	 public void close() {}

	 public void halfOpen() {}

	 public void recordFailures()  {}

	 public void recordSuccess() {}

	 public boolean isThresholdReached() {
		 return true;
	 }
}
