package logic;

import javax.swing.JLabel;

import Controller.ControllerPHP;

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

}
