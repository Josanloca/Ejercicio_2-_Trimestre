package logic;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

import org.json.JSONArray;
import org.json.JSONObject;

import Controller.ControllerPHP;
import Model.genero;
import Model.pelicula;
import variables.VariablesGenerales;

public class logGeneral {
	
	public static ArrayList<pelicula>  oLPelicula= new ArrayList<pelicula>();

	public static void GetPeliculasList() {
		try {
			jsonToPeliculasList(ControllerPHP.peticionHttp(VariablesGenerales.URL+"/get-peliculas.php"));
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private static void jsonToPeliculasList(String respuesta) {
		
		JSONArray jsonArray = new JSONArray(respuesta);
		
		for(int x=0; x<jsonArray.length() ; x++) {
			JSONObject jsonObject = jsonArray.getJSONObject(x);
			int id_pelicula = jsonObject.getInt("id_pelicula");
			String nombre_pelicula = jsonObject.getString("nombre_pelicula");
			byte icca = (byte) jsonObject.getInt("icca");
			String genero = jsonObject.getString("genero");
			
			oLPelicula.add(new pelicula(id_pelicula,nombre_pelicula,icca,(new genero(genero))));
		}
	}
	
	public static String[] lNombrePeliculas() {
		
		String[] aString = new String[oLPelicula.size()];
		
		for(int x = 0; x < oLPelicula.size() ; x++) {
			
			aString[x] = oLPelicula.get(x).getsNombrePelicula();
		}
		return aString;
		
	}
	
	public static Map<String, ImageIcon> createImageMap(String[] list) {
        Map<String, ImageIcon> map = new HashMap<>();
        String sImagen=null;
        try {
    		for(int x=0; x<oLPelicula.size() ; x++) {
    			sImagen = oLPelicula.get(x).getsNombrePelicula();
    			
    			map.put(sImagen, new ImageIcon(new URL(VariablesGenerales.URL+"/img/peliculas/"+sImagen+".png")));
    		}

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }
	
}
