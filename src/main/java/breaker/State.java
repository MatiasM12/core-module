package breaker;

import Interfaces.OriginTS;

public class State {

	public Response makeRequest(OriginTS ts, String url, String us) {
		if (ts.connectTS(url, us))
			return this.close();
		return this.open();
	}

	public Response open() {
		return new Response(false);
	}

	public Response close() {
		return new Response(true);
	}

}
