package breaker;

import Interfaces.OriginTS;
import Interfaces.TestSummary;

public class State {

	public Response makeRequest(TestSummary ts,String url,String us) {
		 
		 if(((OriginTS)ts).connectTS(url, us)) this.open();
		 
		 
		 
		
		 return new Response();
	 }

	 public void open() {}

	 public void close() {}

	 public void halfOpen() {}

	 public void recordFailures()  {}
}
