package logic;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.ControllerPHP;
import Model.usuario;
import view.nuevoUsuario;

public class logNuevoUsuario {
	
	private static File archivo;
	private static String sText;

	
	public static void introducirNuevoUsuario(JTextField tfNombre, JTextField tfApellido, JTextField tfNTelefono, JTextField tfEmail, JTextField tfContraseña) {
		String sResultado="";

		String x;
		try {

			ControllerPHP.peticionHttp("http://15.237.93.98/get-usuario.php?email=");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return;
	}
	

	
	public static void seleccionarFichero() {
		JFileChooser selectorArchivos = new JFileChooser();
		selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		selectorArchivos.showOpenDialog(null);
		
		try {
			archivo = selectorArchivos.getSelectedFile();
			sText = archivo.getAbsolutePath().toString();
			
			Image image = ImageIO.read(archivo);
			nuevoUsuario.lblImagen.setIcon(new ImageIcon(image));
			
			//Start.Principal.txtField.setText();
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void upload() {
		if (sText.length() == 0) {
			JOptionPane.showMessageDialog(null, "seleccionar una imagen", "FALLO", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			String filePath = archivo.getAbsolutePath();
			String fileName = nuevoUsuario.tfEmail.getText().toString();
			String fileNameWOExtension = fileName.replace("[.][^.]+$", "");
			
			String path = "http://15.237.93.98/upload-Imagen.php";
			
			// Establecer la conexion... 
			URL url = new URL(path);
			URLConnection con = url.openConnection();
			HttpURLConnection http = (HttpURLConnection) con;
			
			http.setRequestMethod("POST");
			http.setDoOutput(true);
			
			// PARAMETROS QUE VAMOS A MANDAR
			Map<String, String> params = new HashMap<>();
			params.put("imgName",fileNameWOExtension );
			params.put("imgData", encoderFileToBase64(filePath));
			
			// ARRAY DE BYTES DE ENVIO
			StringJoiner sj = new StringJoiner("&");
			for(Map.Entry<String, String> entry : params.entrySet()) {
				sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
			}
			
			byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
			
			// ENVIAR EL ARRAY DE BYTES HACIA EL PATH (URL DEL BEB-SERVICE)
			http.setFixedLengthStreamingMode(out.length);
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			http.connect();
			http.getOutputStream().write(out);
			
			JOptionPane.showMessageDialog(null, "La imagen ha sido subida correctamente", "UPLOAD", JOptionPane.INFORMATION_MESSAGE);
			
			
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "UPLOAD", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private static String encoderFileToBase64(String filePath) {
		String base64Image = "";
		File file = new File(filePath);
		
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "UPLOAD", JOptionPane.ERROR_MESSAGE);
		}
		System.out.println(base64Image);
		return base64Image;
	}

	
}
