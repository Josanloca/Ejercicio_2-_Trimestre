package Model;

public class pelicula {
	
	private int iIdPelicula;
	private String sNombrePelicula;
	private byte bICCA;
	private genero gGenero;
	
	
	
	
	public int getiIdPelicula() {
		return iIdPelicula;
	}
	public void setiIdPelicula(int iIdPelicula) {
		this.iIdPelicula = iIdPelicula;
	}
	public String getsNombrePelicula() {
		return sNombrePelicula;
	}
	public void setsNombrePelicula(String sNombrePelicula) {
		this.sNombrePelicula = sNombrePelicula;
	}
	public byte getbICCA() {
		return bICCA;
	}
	public void setbICCA(byte bICCA) {
		this.bICCA = bICCA;
	}
	public genero getgGenero() {
		return gGenero;
	}
	public void setgGenero(genero gGenero) {
		this.gGenero = gGenero;
	}

	
	
	
}
