package Controller;

import Model.Usuario;
import logic.logNuevoUsuario;

public class CtrlNuevoUsuario {
	public static void onclick_OK(Usuario oUsua) {
		logNuevoUsuario.introducirNuevoUsuario(oUsua);

	}

}
