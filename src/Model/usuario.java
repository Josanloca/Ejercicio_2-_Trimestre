package Model;

import java.io.Serializable;
import java.util.Date;

public class usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	private int iId_usuario;
	private String sNombre;
	private String sApellido;
	private int iN_Telefono;
	private String sEmail;
	private Date dFechaNC;
	private String sContrasena;
	
	public usuario() {
		
	}
	
	public usuario(String sEmail,String sContrasena) {
		this.sEmail = sEmail;
		this.sContrasena = sContrasena;
	}
	
	public usuario(int iId_usuario,String sNombre, String sApellido, int iN_Telefono, String sEmail) {
		this.iId_usuario = iId_usuario;
		this.sNombre = sNombre;
		this.sApellido = sApellido;
		this.iN_Telefono = iN_Telefono;
		this.sEmail = sEmail;
	}
	
	public usuario(String sNombre, String sApellido, int iN_Telefono, String sEmail, Date dFechaNC,String sContrasena) {
		this.sNombre = sNombre;
		this.sApellido = sApellido;
		this.iN_Telefono = iN_Telefono;
		this.sEmail = sEmail;
		this.dFechaNC = dFechaNC;
		this.sContrasena = sContrasena;
	}
	
	public usuario(int iId_usuario, String sNombre, String sApellido, int iN_Telefono, String sEmail, Date dFechaNC,String sContrasena) {
		this.iId_usuario = iId_usuario;
		this.sNombre = sNombre;
		this.sApellido = sApellido;
		this.iN_Telefono = iN_Telefono;
		this.sEmail = sEmail;
		this.dFechaNC = dFechaNC;
		this.sContrasena = sContrasena;
	}


	public int getiId_usuario() {
		return iId_usuario;
	}
	public void setiId_usuario(int iId_usuario) {
		this.iId_usuario = iId_usuario;
	}
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public String getsApellido() {
		return sApellido;
	}
	public void setsApellido(String sApellido) {
		this.sApellido = sApellido;
	}
	public int getiN_Telefono() {
		return iN_Telefono;
	}
	public void setiN_Telefono(int iN_Telefono) {
		this.iN_Telefono = iN_Telefono;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public Date getdFechaNC() {
		return dFechaNC;
	}
	public void setdFechaNC(Date dFechaNC) {
		this.dFechaNC = dFechaNC;
	}

	public String getsContrasena() {
		return sContrasena;
	}
	public void setsContrasena(String sContrasena) {
		this.sContrasena = sContrasena;
	}

	@Override
	public String toString() {
		return "usuario [iId_usuario=" + iId_usuario + ", sNombre=" + sNombre + ", sApellido=" + sApellido
				+ ", iN_Telefono=" + iN_Telefono + ", sEmail=" + sEmail + ", dFechaNC=" + dFechaNC + "]";
	}
	
}
