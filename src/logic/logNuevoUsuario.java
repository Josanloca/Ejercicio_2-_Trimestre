package logic;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Controller.ControllerPHP;
import Model.usuario;
import view.login;
import view.nuevoUsuario;

public class logNuevoUsuario {
	
	private static File archivo;
	private static String sText="";

	
	public static void introducirNuevoUsuario(usuario oUsuario) {
		if(bBooleanUsuario(oUsuario)) {
			try {
				String sTring = "http://15.237.93.98/set_new_user.php?nombre="+oUsuario.getsNombre()+"&apellido="+oUsuario.getsApellido()+"&numeroTelefono="+oUsuario.getiN_Telefono()+"&email="+oUsuario.getsEmail()+"&fecha="+new SimpleDateFormat("yyyy-MM-dd").format(oUsuario.getdFechaNC())+"&contrasena="+oUsuario.getsContrasena();
				String sBoolean = ControllerPHP.peticionHttp(sTring);
				if(sBoolean.equals("Yes") && sText.length() > 0) {
					JOptionPane.showMessageDialog(login.nUFrame,"Introduccion de usuario correcta");
					logNuevoUsuario.upload();
					login.nUFrame.dispose();
				}else {
					JOptionPane.showMessageDialog(login.nUFrame,"Error en la introduccion del usuario, recuerde añadir una foto");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
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

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void upload() {

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
			
			JOptionPane.showMessageDialog(login.nUFrame, "La imagen ha sido subida correctamente", "UPLOAD", JOptionPane.INFORMATION_MESSAGE);
			
			
		
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

	public static boolean bBooleanUsuario(usuario oUsuario) {
		boolean bRespuesta=false;
		
		if((!oUsuario.getsNombre().equals("") && (oUsuario.getsNombre().length() < 45 && oUsuario.getsNombre().length() > 4))){
			if((!oUsuario.getsApellido().equals("") && (oUsuario.getsApellido().length() < 45 && oUsuario.getsApellido().length() > 4))) {
				if((oUsuario.getiN_Telefono() > 10000000 && oUsuario.getiN_Telefono() < 999999999)) {
					if((!oUsuario.getsEmail().isBlank() && oUsuario.getsEmail().contains("@gmail.com") && oUsuario.getsEmail().length() > 11 && oUsuario.getsEmail().length() < 50)) {
						if((!oUsuario.getsContrasena().isBlank() && oUsuario.getsContrasena().length() > 6 && oUsuario.getsContrasena().length() < 45)) {
							bRespuesta=true;
						}else {
							JOptionPane.showMessageDialog(login.nUFrame,"Introduccion de la contraseña incorrecta, ha de ser (>6 y 45<)","Error al introducir el usuario",JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(login.nUFrame,"Introduccion del correo incorrecto, ha de ser un @gmail y (>11 y 54<)","Error al introducir el usuario",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(login.nUFrame,"Introduccion del numero de telefono incorrecto, (>100000000 y 999999999<)","Error al introducir el usuario",JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(login.nUFrame,"Introduccion del apellido incorrecto, (>4 y 45<)","Error al introducir el usuario",JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(login.nUFrame,"Introduccion del nombre incorrecto, (>4 y 45<)","Error al introducir el usuario",JOptionPane.ERROR_MESSAGE);
		}
		
		return bRespuesta;
	}
}
