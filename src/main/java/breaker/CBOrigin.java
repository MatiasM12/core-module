package breaker;

import Interfaces.OriginTS;

public class CBOrigin {

	int cont;
	Boolean firstConnection;
	State state;

	public CBOrigin() {
		this.state = new State();
		this.cont = 0;
		this.firstConnection = true;
	}



	public Response connectionHandler(OriginTS ts, String url, String us) {
		Boolean resultConnection = ts.connectTS(url, us);

		if(resultConnection) {
			this.firstConnection=true;
					return state.closed();
		}
		else if(resultConnection == false && firstConnection == true){
			this.firstConnection = false;
			return state.open();}
		else {
			while(this.cont<3) {
				if(ts.connectTS(url, us))
					return state.closed();
				else 
					this.cont+=1;
			}
			return state.halfOpen();

		}
	}
}


