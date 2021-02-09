package Controller;

import java.util.Map;

import javax.swing.ImageIcon;

import logic.logGeneral;
import logic.logLogin;
import view.ViewGeneral;

public class CtrlGeneral {
	
	public static void NombreUsuario() {
		ViewGeneral.lblNewLabel.setText("Bienvenido: "+logLogin.oUsuarioGeneral.getsNombre());
	}
	
	public static String[] NombrePeliculasList() {
		logGeneral.GetPeliculasList();
		return logGeneral.lNombrePeliculas();
	}
	
	public static Map<String, ImageIcon> createImageMap(String[] list){
		return logGeneral.createImageMap(list);
	}

	public static String DisplayPelicula() {
		return ViewGeneral.lPelicula.getSelectedValue().toString();
	}
	


}
