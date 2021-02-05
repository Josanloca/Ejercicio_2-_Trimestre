package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import Model.usuario;
import logic.logNuevoUsuario;
import view.nuevoUsuario;

public class CtrlNuevoUsuario {
	public static void onclick_OK(usuario oUsua) {
		System.out.println("" + nuevoUsuario.tfNTelefono.getText()+"hola");
		
		logNuevoUsuario.introducirNuevoUsuario(oUsua);
		logNuevoUsuario.upload();

	}

}
