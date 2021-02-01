package Model;

public class genero {
	
	private String nombreGenero;
	
	
	public genero() {
	}
	
	public genero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}
	
	public String getNombreGenero() {
		return nombreGenero;
	}
	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}

	@Override
	public String toString() {
		return "genero [nombreGenero=" + nombreGenero + "]";
	}
	
}
