

import Interfaces.OriginTS;
import Interfaces.TestSummary;
import core.TSBADGE;
import core.TSBadgeProyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.google.gson.Gson;
import com.google.gson.JsonElement;


public class BadgeTS extends OriginTS implements HttpHandler {

	HttpServer server;
	
	public BadgeTS(TestSummary ts) {
		super(ts);
		System.out.println("Me creee");
	}

	@Override
	public boolean connectTS(String url, String us) {
		
		System.out.println("Estoy aca");
		
		JsonElement s = parseRespuesta(conectarAGithub(url,us)).getAsJsonObject().get("workflow_runs").getAsJsonArray().get(0).getAsJsonObject().get("conclusion");
		
		if(s.toString().equals('"'+"success"+'"')) this.update(new TSBadgeProyecto(true));
		
		else 	this.update(new TSBadgeProyecto(false));
		
		return crearEndpoint()&&conectarWebHook(url,us);  
		
		
	}
	
	private Boolean conectarWebHook(String url,String us) {
		//45729c1b7fa69242660be6a6e17cc743881067b3
		try {
            // Configura tus credenciales de autenticación
            String username = "Nicolas2k19";
            String password = "Jonybonyboy1";
            // URL del repositorio y URL del endpoint de webhooks
            String repositoryUrl = "https://api.github.com/repos/Nicolas2k19/GitAcme";
            String webhookUrl = "https://smee.io/JBUz5zfWrAinxEn";
                       
            // Configura la solicitud HTTP
            URL urlGithub = new URL(repositoryUrl + "/hooks");
            HttpURLConnection connection = (HttpURLConnection) urlGithub.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + url);
            															

            // Configura el cuerpo de la solicitud con los detalles del webhook
            String body = "{ \"name\": \"web\", \"active\": true, \"events\": [\"workflow_run\"], \"config\": { \"url\": \"" + urlGithub + "\" } }";
            byte[] requestBody = body.getBytes(StandardCharsets.UTF_8);
            connection.setDoOutput(true);
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(requestBody);
            outputStream.close();

            // Obtiene la respuesta de la solicitud
            int responseCode = connection.getResponseCode();
            BufferedReader reader;
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            // Lee la respuesta
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Verifica si el webhook se creó correctamente
            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                System.out.println("Webhook creado correctamente");
                return true;
            } else {
                System.out.println("Error al crear el webhook: " + response.toString());
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
		
	
	private String conectarAGithub(String url,String us) {
			 
		String conexion =  "https://api.github.com/repos/" + "MatiasM12" + "/" + "core-module" + "/actions/runs";
		
		System.out.println(conexion+"");
		
		 try {
	            URL apiUrl = new URL(conexion);
	            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
	            connection.setRequestMethod("GET");
	            int responseCode = connection.getResponseCode();       
	            if (responseCode == HttpURLConnection.HTTP_OK) {
	                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	                String inputLine;
	                StringBuilder response = new StringBuilder();

	                while ((inputLine = in.readLine()) != null) {
	                    response.append(inputLine);
	                }
	                in.close();
	                return response.toString();
	            } else {
	                System.out.println("Error en la solicitud. Código de respuesta: " + responseCode);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
		
	private JsonElement parseRespuesta(String respuesta) {
		Gson gson = new Gson();
		return gson.fromJson(respuesta, JsonElement.class);
	}
		
		
	

	private boolean crearEndpoint() {
		
		
		try {
			//HttpServer server;
			System.out.println("Todo salio bien");
			//server.stop(0);
			server = HttpServer.create(new InetSocketAddress(8095), 0);
			server.createContext("/mi-endpoint", this);
			server.setExecutor(null);
			server.start();
	        System.out.println("Servidor iniciado en el puerto 8095");
			return true;
		} catch (IOException e) {
			System.out.println(e.getStackTrace().getClass().getName());
			return false;
		}
	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {
			InputStream inputStream = exchange.getRequestBody();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	        String linea;
	        StringBuilder contenido = new StringBuilder();

	        
	        while ((linea = reader.readLine()) != null) {
	            contenido.append(linea);
	        }
	      	        
	        if(expresionRegular(contenido.toString())) {
	        	
	        	System.out.println("Me cree");
	        	
	        	this.update(new TSBadgeProyecto(true));
	        	}
	        
	        else {
	        	System.out.println("No Me cree");
	        	this.update(new TSBadgeProyecto(false));}
	        	
	     
	        inputStream.close();
	        reader.close();
			
		    String response = "¡Hola desde mi endpoint!";
	        exchange.sendResponseHeaders(200, response.length());
	        OutputStream os = exchange.getResponseBody();
	        os.write(response.getBytes());
	        os.close();
	}
	
	  private boolean  expresionRegular(String text) {
		  // Definir la expresión regular
		  	String regex = "succes\\w+";
	        // Crear un objeto de patrón usando la expresión regular
	        Pattern pattern = Pattern.compile(regex);
	        // Crear un objeto de coincidencia para buscar la expresión regular en el texto
	        Matcher matcher = pattern.matcher(text);
	        // Buscar todas las ocurrencias de la expresión regular en el texto
	        return (matcher.find()); 
	         
	  }
	
	
	

}
