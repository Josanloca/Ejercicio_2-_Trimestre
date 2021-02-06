package logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import Controller.ControllerPHP;
import Model.usuario;

public class logPrincipal {
	
	public static usuario oUsuarioGeneral;
	
	@SuppressWarnings("deprecation")
	public static String LoginUsuario(JTextField tfCorreo, JPasswordField passwordField) {
		String sResultado="";

		String x;
		try {
			x = ControllerPHP.peticionHttp("http://15.237.93.98/login.php?sEmail="+tfCorreo.getText().toString()+"&sContrasena="+passwordField.getText().toString());
			System.out.println(x);
			sResultado = x;
			usuario oUs = jsonToUsuario(ControllerPHP.peticionHttp("http://15.237.93.98/get-usuario.php?email="+tfCorreo.getText().toString()));
			
			oUsuarioGeneral=oUs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return sResultado;
	}
	
	
	private static usuario jsonToUsuario(String respuesta) {
		JSONArray jsonArray = new JSONArray(respuesta);
		JSONObject jsonObject = jsonArray.getJSONObject(0);
		int id_usuario = jsonObject.getInt("id_usuario");
		String nombre = jsonObject.getString("nombre");
		String apellido = jsonObject.getString("apellido");
		Integer numeroTelefono = jsonObject.getInt("numeroTelefono");
		String email = jsonObject.getString("email");
		String fecha = jsonObject.getString("fecha");
		String contrasena = jsonObject.getString("contrasena");
		
		System.out.println(""+id_usuario+" "+nombre+" "+apellido+" "+numeroTelefono+" "+email+" "+fecha+" "+contrasena);
		return new usuario(id_usuario,nombre,apellido,numeroTelefono,email,transformadorStringDate(fecha),contrasena);
	}
	
	
	public static Date transformadorStringDate(String respuesta) {
		Date date = null;
		System.out.println(respuesta);
		try {
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = simpleDateFormat.parse(respuesta);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date);
		return date ;
	}
	
	


}
