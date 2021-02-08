package logic;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

import Controller.CtrlGeneral;
import view.viewPeliculas;

public class logPelicula {

	public static void setPelicul() throws MalformedURLException {
		String sNombreSelect = CtrlGeneral.DisplayPelicula();
		System.out.println(sNombreSelect);
		
		for(byte x = 0 ; x < logGeneral.oLPelicula.size(); x++ ) {
			if(logGeneral.oLPelicula.get(x).getsNombrePelicula().equals(sNombreSelect)) {
				viewPeliculas.lbNombrePelicula.setText(logGeneral.oLPelicula.get(x).getsNombrePelicula());
				viewPeliculas.lbICCANOMBRE.setText(String.valueOf(logGeneral.oLPelicula.get(x).getbICCA()));
				viewPeliculas.lbGENERONombre.setText(String.valueOf(logGeneral.oLPelicula.get(x).getgGenero().getNombreGenero()));
				viewPeliculas.lblPelicula.setIcon(new ImageIcon(new URL("http://15.237.93.98/img/peliculas/"+logGeneral.oLPelicula.get(x).getsNombrePelicula()+".png")));
				 break;
			}
		}
	}

}
