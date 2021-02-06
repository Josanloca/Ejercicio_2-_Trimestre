package Controller;

import java.util.Map;

import javax.swing.ImageIcon;

import logic.logGeneral;
import logic.logPrincipal;
import view.ViewGeneral;

public class CtrlGeneral {
	
	public static void NombreUsuario() {
		ViewGeneral.lblNewLabel.setText("Bienvenido: "+logPrincipal.oUsuarioGeneral.getsNombre());
	}
	
	public static String[] NombrePeliculasList() {
		logGeneral.GetPeliculasList();
		return logGeneral.lNombrePeliculas();
	}
	
	public static Map<String, ImageIcon> createImageMap(String[] list){
		return logGeneral.createImageMap(list);
	}

	public static void DisplayPelicula() {
		ViewGeneral.lPelicula.getSelectedValue();
	}
	


}
