package logic;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.json.JSONArray;
import org.json.JSONObject;

import Controller.ControllerPHP;
import Model.pelicula;
import Model.sala_cine;
import Model.usuario;
import view.viewPeliculas;
import view.viewSalaCine;

public class logSalaCine {
	public static byte bNumeroEntradas;
	public static byte bCapacidadMax;
	private static byte bNEntradasUsuario = 0;
	private static pelicula oPelicula;
	public static sala_cine oSalaCine;
	
	private static byte numeroEntradasActuales() {
		byte bResultado=0;
		
		for(int x=0; x<logGeneral.oLPelicula.size() ; x++) {
			if(logGeneral.oLPelicula.get(x).getsNombrePelicula().equals(viewPeliculas.lbNombrePelicula.getText())) {
				oPelicula = logGeneral.oLPelicula.get(x);
				break;
			}
		}

				try {
					oSalaCine = jsonToSalaCine(ControllerPHP.peticionHttp("http://15.237.93.98/get-sala-cine.php?idpeli="+oPelicula.getiIdPelicula()));
					bCapacidadMax=Byte.valueOf(ControllerPHP.peticionHttp("http://15.237.93.98/get-capacidad-max.php?idPelicula="+oPelicula.getiIdPelicula()));
					bNumeroEntradas=Byte.valueOf(ControllerPHP.peticionHttp("http://15.237.93.98/get-entradas.php?idPelicula="+oPelicula.getiIdPelicula()));
					bNEntradasUsuario = Byte.valueOf(ControllerPHP.peticionHttp("http://15.237.93.98/get-Entrada-usuario.php?idUsuario="+logPrincipal.oUsuarioGeneral.getiId_usuario()+"&idSalCine="+oPelicula.getiIdPelicula()));
				} catch (Exception e) {
					e.printStackTrace();
				}
				bResultado = (byte) (bCapacidadMax - bNumeroEntradas);
	
		return bResultado;
	}

	
	
	
	public static void iniciador() {
		viewSalaCine.dataset.setValue("Entradas sin reservar", numeroEntradasActuales());
		viewSalaCine.dataset.setValue("Entradas reservadas", bNumeroEntradas);
		viewSalaCine.chart = ChartFactory.createPieChart3D("Entradas para "+oPelicula.getsNombrePelicula(), viewSalaCine.dataset, true, true, false);
		viewSalaCine.chart.getPlot().setBackgroundPaint( Color.BLACK );
		PiePlot3D plot = (PiePlot3D) viewSalaCine.chart.getPlot();
		PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {1}");
		plot.setLabelGenerator(labelGenerator);
		plot.setForegroundAlpha(0.6f);
		plot.setCircular(true);
		viewSalaCine.lblNumeroActual.setText(""+bNEntradasUsuario);
	}


	
	private static sala_cine jsonToSalaCine(String respuesta) {
		JSONArray jsonArray = new JSONArray(respuesta);
		JSONObject jsonObject = jsonArray.getJSONObject(0);
		byte id_sala_cine = (byte) jsonObject.getInt("id_sala_cine");
		byte capacidad_max = (byte) jsonObject.getInt("capacidad_max");
		byte capacidad_act = (byte) jsonObject.getInt("capacidad_act");
		int id_pelicula = jsonObject.getInt("id_pelicula");


		return new sala_cine(id_sala_cine,capacidad_max,capacidad_act,oPelicula);
	}




	public static void sumaEntrada() {
		bNumeroEntradas =  (byte) (bNumeroEntradas+1);
		byte bN = 0;
		if(bNEntradasUsuario<bCapacidadMax) {
			
			try {
				System.out.println(bNEntradasUsuario);
				ControllerPHP.peticionHttp("http://15.237.93.98/update-nueva-entrada.php?capacidad="+bNumeroEntradas+"&idPeli="+oSalaCine.getbId_sala_cine());
				bNumeroEntradas=Byte.valueOf(ControllerPHP.peticionHttp("http://15.237.93.98/get-entradas.php?idPelicula="+oSalaCine.getbId_sala_cine()));
				System.out.println(ControllerPHP.peticionHttp("http://15.237.93.98/max-asiento.php?idUsuario="+logPrincipal.oUsuarioGeneral.getiId_usuario()+"&idSCine="+oSalaCine.getbId_sala_cine()));
				bN= Byte.valueOf(ControllerPHP.peticionHttp("http://15.237.93.98/max-asiento.php?idUsuario="+logPrincipal.oUsuarioGeneral.getiId_usuario()+"&idSCine="+oSalaCine.getbId_sala_cine()));
				System.out.println(bN);
				System.out.println(ControllerPHP.peticionHttp(//ERROR AQUI ABAJO
						"http://15.237.93.98/nueva-entrada.php?n_sitio="+(bN)
								+"&idUsuario="+logPrincipal.oUsuarioGeneral.getiId_usuario()
								+"&idSCine="+oSalaCine.getbId_sala_cine()));
				
				//SELECT MAX(n_sitio) AS mayor FROM entrada WHERE id_usuario_fk =2 AND id_sala_cine_fk=1
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
		}		
	}





}
