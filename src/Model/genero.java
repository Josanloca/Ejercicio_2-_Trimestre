package Model;

public class genero {
	
	private String nombreGenero;
	private String descripccion;
	
	
	public genero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}
	
	
	
	public genero(String nombreGenero, String descripccion) {
		this.nombreGenero = nombreGenero;
		this.descripccion = descripccion;
	}
	
	public String getNombreGenero() {
		return nombreGenero;
	}
	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}
	public String getDescripccion() {
		return descripccion;
	}
	public void setDescripccion(String descripccion) {
		this.descripccion = descripccion;
	}


	@Override
	public String toString() {
		return "genero [nombreGenero=" + nombreGenero + ", descripccion=" + descripccion + "]";
	}
	
	
	
}
