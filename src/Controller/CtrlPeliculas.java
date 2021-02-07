package Controller;


import java.net.MalformedURLException;

import logic.logPelicula;

public class CtrlPeliculas {


		public static void iniciacionPeli() {
			try {
				logPelicula.setPelicul();
			} catch (MalformedURLException e) {

				e.printStackTrace();
			}

		}
}
