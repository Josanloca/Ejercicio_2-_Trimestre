package Controller;

import java.io.IOException;

import logic.logLogin;

public class CtrlLogin {

	public static void cargaUsuario() {
		try {
			logLogin.cargaUsuario();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void borrado() {
		logLogin.borrar();
	}

	public static boolean isExiste() {
		return logLogin.isExiste();
	}

}
