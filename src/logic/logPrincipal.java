package logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import Controller.ControllerPHP;
import Model.usuario;

public class logPrincipal {
	
	public static usuario oUsuarioGeneral;
	
	public static String LoginUsuario(JTextField tfCorreo, JPasswordField passwordField) {
		String sResultado="";

		String x;
		try {
			x = ControllerPHP.peticionHttp("http://josanloca.000webhostapp.com/php/login.php?sEmail="+tfCorreo.getText().toString()+"&sContraseña="+passwordField.getText().toString());
			System.out.println(x);
			sResultado = x;
			usuario oUs = jsonToUsuario(ControllerPHP.peticionHttp("http://josanloca.000webhostapp.com/php/get-usuario.php?email="+tfCorreo.getText().toString()));
			
			oUsuarioGeneral=oUs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return sResultado;
	}
	
	
	private static usuario jsonToUsuario(String respuesta) {
		JSONArray jsonArray = new JSONArray(respuesta);
		System.out.println("no ha pasado");
		JSONObject jsonObject = jsonArray.getJSONObject(0);
		System.out.println("yes");
		int id_usuario = jsonObject.getInt("id_usuario");
		String nombre = jsonObject.getString("nombre");
		String apellido = jsonObject.getString("apellido");
		Integer numeroTelefono = jsonObject.getInt("numeroTelefono");
		String email = jsonObject.getString("email");
		String fecha = jsonObject.getString("fecha");
		String contraseña = jsonObject.getString("contraseña");
		
		System.out.println(""+id_usuario+" "+nombre+" "+apellido+" "+numeroTelefono+" "+email+" "+fecha+" "+contraseña);
		return new usuario(id_usuario,nombre,apellido,numeroTelefono,email,transformadorStringDate(fecha),contraseña);
	}
	
	
	private static Date transformadorStringDate(String respuesta) {
		Date date = null;
		try {
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = simpleDateFormat.parse(respuesta);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date ;
	}
	
	
	

}