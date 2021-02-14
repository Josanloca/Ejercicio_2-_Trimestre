package logic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import Controller.ControllerPHP;
import Model.Usuario;
import variables.VariablesGenerales;
import view.ViewAdmin;

public class logAdmin {
	
	public static void loadData(){
		try {
		List<Usuario> resultado=getUsers();
				
		DefaultTableModel modelo = generarTableusuario(resultado);
		
		ViewAdmin.usuTable.setModel(modelo);
		
		//ocutar columna 0 de pk

		ViewAdmin.usuTable.getColumnModel().getColumn(0).setMinWidth(0);
		ViewAdmin.usuTable.getColumnModel().getColumn(0).setMaxWidth(0);
		ViewAdmin.usuTable.getColumnModel().getColumn(0).setWidth(0);
		}catch(Exception e) {
			System.err.println("fallo "+e.getMessage());
			e.getStackTrace();
			
		}
	}
	
	private static List<Usuario> getUsers() throws Exception {
		return jsonToUsers(ControllerPHP.peticionHttp(VariablesGenerales.URL+"/get-usuarios.php"));
	}
	
	private static List<Usuario> jsonToUsers(String respuesta) {
		List<Usuario> oUsersLis = new ArrayList<Usuario>();
		
		JSONArray jsonArray = new JSONArray(respuesta);
		for(byte x = 0 ; x < jsonArray.length(); x++ ) {
			JSONObject jsonObject = jsonArray.getJSONObject(x);
			oUsersLis.add(new Usuario(jsonObject.getInt("id_usuario"),jsonObject.getString("nombre"),jsonObject.getString("apellido"),jsonObject.getInt("numeroTelefono"),jsonObject.getString("email")));
		}
		return oUsersLis;
	}
	
	public static DefaultTableModel  generarTableusuario(List<Usuario> resultado) {

		DefaultTableModel modelo = new DefaultTableModel();
		
		
		modelo.addColumn("id_usuario");
		modelo.addColumn("nombre");
		modelo.addColumn("apellido");
		modelo.addColumn("numeroTelefono");
		modelo.addColumn("email");
		
		
		for(Usuario c: resultado) {
			modelo.addRow(new Object[] {c.getiId_usuario(),c.getsNombre(),c.getsApellido(),c.getiN_Telefono(),c.getsEmail()});
		}

		return modelo;
	}
	
}

