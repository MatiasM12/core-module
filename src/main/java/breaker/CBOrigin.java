package breaker;

import Interfaces.OriginTS;
import Interfaces.TestSummary;

public class CBOrigin {
	 State state; 	 
	 
	 public CBOrigin(){
		 this.state = new State();
	 }
	 	 
	 public Response makeRequest(OriginTS ts,String url,String us) {
		 return this.state.makeRequest(ts, url, us);
	 }

}
