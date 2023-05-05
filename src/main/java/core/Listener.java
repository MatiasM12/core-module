package core;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Listener implements HttpHandler {
    ReportRefresher reportRefresher;
    
    public void  start() throws IOException{
        HttpServer server = HttpServer.create(new InetSocketAddress(8005), 0);
        server.createContext("/mi-endpoint", this);
        server.setExecutor(null);
        server.start();
    }
    @Override
    public void handle(HttpExchange t) throws IOException {
        System.out.println("Hola jaja");
        reportRefresher.refreshReport();
        if(t != null) {
            String response = "{ Se realizo el refresh}";
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
    
    
    public void setRefresher(ReportRefresher r) {
    	this.reportRefresher = r;
    }
    
}
