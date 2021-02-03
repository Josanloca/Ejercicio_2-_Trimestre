package logic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import org.json.JSONArray;
import org.json.JSONObject;

import Controller.ControllerPHP;
import Model.usuario;

public class logPrincipal {
	
	public static String LoginUsuario(JLabel lblCorreo, JLabel lblContraseña) {
		String sResultado="";
		
		String x;
		try {
			x = ControllerPHP.peticionHttp("http://josanloca.000webhostapp.com/php/login.php?sEmail="+lblCorreo.getText().toString()+"&sContraseña="+lblContraseña.getText().toString());
			System.out.println(x);
			sResultado = x;
			
			ControllerPHP.peticionHttp("http://josanloca.000webhostapp.com/php/login.php?sEmail="+lblCorreo.getText().toString()+"&sContraseña="+lblContraseña.getText().toString());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return sResultado;
	}
	
	
	private static usuario jsonToUsuario(String respuesta) {
		JSONArray jsonArray = new JSONArray(respuesta);
		
		
		JSONObject jsonObject = jsonArray.getJSONObject(0);
			
		int id_usuario = jsonObject.getInt("id_coche");
		String nombre = jsonObject.getString("marca");
		String apellido = jsonObject.getString("apellido");
		Integer numeroTelefono = jsonObject.getInt("numeroTelefono");
		String email = jsonObject.getString("email");
		String fecha = jsonObject.getString("fecha");
		String contraseña = jsonObject.getString("contraseña");
		
		
			
		
		return new usuario();
	}
	
	
	
	
	

}
