package Controller;

import Model.usuario;
import logic.logNuevoUsuario;

public class CtrlNuevoUsuario {
	public static void onclick_OK(usuario oUsua) {
		logNuevoUsuario.introducirNuevoUsuario(oUsua);

	}

}
