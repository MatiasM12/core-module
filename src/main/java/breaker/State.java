package breaker;


public class State {

	public Response open() {
		
		return new Response("Fallo en la primera conexión");
	}
	public Response closed() {
		return new Response("Conexión Exitosa");
	}
	public Response halfOpen() {
		return new Response("Fallo en el reintento de conexión");
	}
	

}
