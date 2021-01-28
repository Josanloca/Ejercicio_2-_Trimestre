package Model;

import java.util.Date;

public class usuario {
	
	private int iId_usuario;
	private String sNombre;
	private String sApellido;
	private int iN_Telefono;
	private String sEmail;
	private Date dFechaNC;
	private String sContraseña;
	
	
	
	public usuario() {
		
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

	public String getsContraseña() {
		return sContraseña;
	}
	public void setsContraseña(String sContraseña) {
		this.sContraseña = sContraseña;
	}

	@Override
	public String toString() {
		return "usuario [iId_usuario=" + iId_usuario + ", sNombre=" + sNombre + ", sApellido=" + sApellido
				+ ", iN_Telefono=" + iN_Telefono + ", sEmail=" + sEmail + ", dFechaNC=" + dFechaNC + ", sContraseña="
				+ sContraseña + "]";
	}
	
}
