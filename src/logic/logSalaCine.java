package logic;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PiePlot3D;

import Controller.ControllerPHP;
import view.viewSalaCine;

public class logSalaCine {
	public static byte bNumeroEntradas;
	public static byte bCapacidadMax;

	
	private static byte numeroEntradasActuales() {
		byte bResultado=0;

				try {
					bCapacidadMax=Byte.valueOf(ControllerPHP.peticionHttp("http://15.237.93.98/get-capacidad-max.php"));
					bNumeroEntradas=Byte.valueOf(ControllerPHP.peticionHttp("http://15.237.93.98/get-entradas.php"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				bResultado = (byte) (bCapacidadMax - bNumeroEntradas);
	
		return bResultado;
	}

	
	
	
	public static void iniciador() {
		viewSalaCine.dataset.setValue("Entradas sin reservar", numeroEntradasActuales());
		viewSalaCine.dataset.setValue("Entradas reservadas", bNumeroEntradas);
		viewSalaCine.chart = ChartFactory.createPieChart3D("Chart 3", viewSalaCine.dataset, false, false, false);
		
		PiePlot3D plot = (PiePlot3D) viewSalaCine.chart.getPlot();
		plot.setForegroundAlpha(0.6f);
		plot.setCircular(true);		
	}

}
