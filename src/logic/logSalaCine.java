package logic;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PiePlot3D;
import org.json.JSONArray;
import org.json.JSONObject;

import Controller.ControllerPHP;
import Model.usuario;
import view.ViewGeneral;
import view.viewPeliculas;
import view.viewSalaCine;

public class logSalaCine {
	public static byte bNumeroEntradas;
	public static byte bCapacidadMax;

	
	private static byte numeroEntradasActuales() {
		byte bResultado=0;
		byte bIdPelicula = 0;
		
		for(int x=0; x<logGeneral.oLPelicula.size() ; x++) {
			if(logGeneral.oLPelicula.get(x).getsNombrePelicula().equals(viewPeliculas.lbNombrePelicula.getText())) {
				bIdPelicula = (byte) logGeneral.oLPelicula.get(x).getiIdPelicula();
				break;
			}
		}

				try {
					
					bCapacidadMax=Byte.valueOf(ControllerPHP.peticionHttp("http://15.237.93.98/get-capacidad-max.php?idPelicula="+bIdPelicula));
					bNumeroEntradas=Byte.valueOf(ControllerPHP.peticionHttp("http://15.237.93.98/get-entradas.php?idPelicula="+bIdPelicula));
				} catch (Exception e) {
					e.printStackTrace();
				}
				bResultado = (byte) (bCapacidadMax - bNumeroEntradas);
	
		return bResultado;
	}

	
	
	
	public static void iniciador() {
		System.out.println(numeroEntradasActuales());
		System.out.println(bNumeroEntradas);
		viewSalaCine.dataset.setValue("Entradas sin reservar", numeroEntradasActuales());
		viewSalaCine.dataset.setValue("Entradas reservadas", bNumeroEntradas);
		viewSalaCine.chart = ChartFactory.createPieChart3D("Chart 3", viewSalaCine.dataset, false, false, false);
		
		PiePlot3D plot = (PiePlot3D) viewSalaCine.chart.getPlot();
		plot.setForegroundAlpha(0.6f);
		plot.setCircular(true);		
	}

	
	
	private static usuario jsonToUsuario(String respuesta) {
		
		JSONArray jsonArray = new JSONArray(respuesta);
		JSONObject jsonObject = jsonArray.getJSONObject(0);
		int id_usuario = jsonObject.getInt("id_usuario");
		String nombre = jsonObject.getString("nombre");
		String apellido = jsonObject.getString("apellido");
		Integer numeroTelefono = jsonObject.getInt("numeroTelefono");
		String email = jsonObject.getString("email");
		String fecha = jsonObject.getString("fecha");
		String contrasena = jsonObject.getString("contrasena");
		
		System.out.println(""+id_usuario+" "+nombre+" "+apellido+" "+numeroTelefono+" "+email+" "+fecha+" "+contrasena);
		return new usuario();
	}
}
