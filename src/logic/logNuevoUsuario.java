package logic;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import view.nuevoUsuario;

public class logNuevoUsuario {

	public static void seleccionarFichero() {
		JFileChooser selectorArchivos = new JFileChooser();
		selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		selectorArchivos.showOpenDialog(null);
		
		try {
			File archivo = selectorArchivos.getSelectedFile();
			Image image = ImageIO.read(archivo);
			nuevoUsuario.lblImagen.setIcon(new ImageIcon(image));
			//Start.Principal.txtField.setText(archivo.getAbsolutePath());
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
