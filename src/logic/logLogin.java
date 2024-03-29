package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import Controller.ControllerPHP;
import Model.Usuario;
import variables.VariablesGenerales;
import view.login;

public class logLogin {
	
	public static Usuario oUsuarioGeneral;
	
	@SuppressWarnings("deprecation")
	public static String LoginUsuario(JTextField tfCorreo, JPasswordField passwordField) {
		String sResultado="";

		String x;
		try {
			x = ControllerPHP.peticionHttp(VariablesGenerales.URL+"/login.php?sEmail="+tfCorreo.getText().toString()+"&sContrasena="+passwordField.getText().toString());
			sResultado = x;
			Usuario oUs = jsonToUsuario(ControllerPHP.peticionHttp(VariablesGenerales.URL+"/get-usuario.php?email="+tfCorreo.getText().toString()));
			
			oUsuarioGeneral=oUs;
			
		} catch (org.json.JSONException  e) {
			//e.printStackTrace();
		} catch (Exception e) {
			//e.printStackTrace();
		}		
		return sResultado;
	}
	
	private static Usuario jsonToUsuario(String respuesta) {
		JSONArray jsonArray = new JSONArray(respuesta);
		JSONObject jsonObject = jsonArray.getJSONObject(0);
		int id_usuario = jsonObject.getInt("id_usuario");
		String nombre = jsonObject.getString("nombre");
		String apellido = jsonObject.getString("apellido");
		Integer numeroTelefono = jsonObject.getInt("numeroTelefono");
		String email = jsonObject.getString("email");
		String fecha = jsonObject.getString("fecha");
		String contrasena = jsonObject.getString("contrasena");
		
		//System.out.println(""+id_usuario+" "+nombre+" "+apellido+" "+numeroTelefono+" "+email+" "+fecha+" "+contrasena);
		return new Usuario(id_usuario,nombre,apellido,numeroTelefono,email,transformadorStringDate(fecha),contrasena);
	}

	
	public static Date transformadorStringDate(String respuesta) {
		Date date = null;
		try {
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = simpleDateFormat.parse(respuesta);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date ;
	}

	@SuppressWarnings("deprecation")
	public static void cargaUsuario() throws IOException {
		File fArchivo = new File("guardoUsuario/datosU.obj");
		FileOutputStream fOut = new FileOutputStream(fArchivo);
		ObjectOutputStream oOut = new ObjectOutputStream(fOut);
		oOut.writeObject(new Usuario(login.tfCorreo.getText().toString(),login.passwordField.getText().toString()));
		oOut.close();
	}

	@SuppressWarnings("resource")
	public static boolean isExiste() {
		File fLectura = new File("guardoUsuario/datosU.obj");
		boolean bResul= false;
		if(fLectura.exists()) {
			bResul=true;
			try {
				FileInputStream fImput = new FileInputStream(fLectura);
				ObjectInputStream oImput = new ObjectInputStream(fImput);
				while(true) {
					Usuario u = (Usuario) oImput.readObject();
					login.tfCorreo.setText(u.getsEmail());
					login.passwordField.setText(u.getsContrasena());
				}
				
				} catch (IOException | ClassNotFoundException e) {
			}
		}		
		return bResul;
	}


	public static void borrar() {
		System.out.println(new File("guardoUsuario/datosU.obj").delete());
	}
	
	


}
