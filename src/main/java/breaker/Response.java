package breaker;

public class Response {

	Boolean  success;
	
	
	Response(Boolean success){
		this.success = success;
	}
	
	public Boolean isSuccess() {
		return success;
	}
}
