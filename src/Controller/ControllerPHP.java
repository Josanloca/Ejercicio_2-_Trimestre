package Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ControllerPHP {

	
	public static String peticionHttp(String urlWebService) throws Exception {
		StringBuilder resultado = new StringBuilder();
		
		// Realizar la peticion http
		URL url = new URL(urlWebService);
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		
		// Recoger los datos de respuesta
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		
		rd.close();
		
		return resultado.toString();
	}
}
