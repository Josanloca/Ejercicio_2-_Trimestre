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
import variables.VariablesGenerales;
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
					oSalaCine = jsonToSalaCine(ControllerPHP.peticionHttp(VariablesGenerales.URL+"/get-sala-cine.php?idpeli="+oPelicula.getiIdPelicula()));
					bCapacidadMax=Byte.valueOf(ControllerPHP.peticionHttp(VariablesGenerales.URL+"/get-capacidad-max.php?idPelicula="+oPelicula.getiIdPelicula()));
					bNumeroEntradas=Byte.valueOf(ControllerPHP.peticionHttp(VariablesGenerales.URL+"/get-entradas.php?idPelicula="+oPelicula.getiIdPelicula()));
					bNEntradasUsuario = Byte.valueOf(ControllerPHP.peticionHttp(VariablesGenerales.URL+"/get-Entrada-usuario.php?idUsuario="+logLogin.oUsuarioGeneral.getiId_usuario()+"&idSalCine="+oSalaCine.getbId_sala_cine()));
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
		viewSalaCine.lblNumeroActual.setText(String.valueOf(bNEntradasUsuario));
	}


	
	private static sala_cine jsonToSalaCine(String respuesta) {
		JSONArray jsonArray = new JSONArray(respuesta);
		JSONObject jsonObject = jsonArray.getJSONObject(0);
		byte id_sala_cine = (byte) jsonObject.getInt("id_sala_cine");
		byte capacidad_max = (byte) jsonObject.getInt("capacidad_max");
		byte capacidad_act = (byte) jsonObject.getInt("capacidad_act");
		@SuppressWarnings("unused")
		int id_pelicula = jsonObject.getInt("id_pelicula");


		return new sala_cine(id_sala_cine,capacidad_max,capacidad_act,oPelicula);
	}




	@SuppressWarnings("unused")
	public static void sumaEntrada() {
		
		byte bN = 0,bEntrada;
		//System.out.println(bCapacidadMax+" . "+bNumeroEntradas);
		if(bCapacidadMax >=bNumeroEntradas) {
			bNumeroEntradas =  (byte) (bNumeroEntradas+1);
			try {
				ControllerPHP.peticionHttp(VariablesGenerales.URL+"/update-nueva-entrada.php?capacidad="+bNumeroEntradas+"&idPeli="+oSalaCine.getbId_sala_cine());
				
				bN= Byte.valueOf(ControllerPHP.peticionHttp(VariablesGenerales.URL+"/max-asiento.php?idUsuario="+logLogin.oUsuarioGeneral.getiId_usuario()+"&idSCine="+oSalaCine.getbId_sala_cine()));
				ControllerPHP.peticionHttp(
						VariablesGenerales.URL+"/nueva-entrada.php?n_sitio="+(bN+1)
								+"&idUsuario="+logLogin.oUsuarioGeneral.getiId_usuario()
								+"&idSCine="+oSalaCine.getbId_sala_cine());
				bEntrada=Byte.valueOf(ControllerPHP.peticionHttp(VariablesGenerales.URL+"/get-Entrada-usuario.php?idUsuario="+logLogin.oUsuarioGeneral.getiId_usuario()+"&idSalCine="+oSalaCine.getbId_sala_cine()));
				iniciador();				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}		
	}

	@SuppressWarnings("unused")
	public static void restaEntrada() {
		byte bN = 0,bEntrada;
		//System.out.println(bCapacidadMax+" . "+bNumeroEntradas);
		
		if(bNumeroEntradas>0) {
			bNumeroEntradas =  (byte) (bNumeroEntradas-1);
			try {
				ControllerPHP.peticionHttp("/update-nueva-entrada.php?capacidad="+bNumeroEntradas+"&idPeli="+oSalaCine.getbId_sala_cine());
				bN= Byte.valueOf(ControllerPHP.peticionHttp(VariablesGenerales.URL+"/max-asiento.php?idUsuario="+logLogin.oUsuarioGeneral.getiId_usuario()+"&idSCine="+oSalaCine.getbId_sala_cine()));
				ControllerPHP.peticionHttp(VariablesGenerales.URL+"/remove-entrada.php?idUsuario="+logLogin.oUsuarioGeneral.getiId_usuario()+"&idCine="+oSalaCine.getbId_sala_cine()+"&nSitio="+bN);
				iniciador();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}		
	}



}
