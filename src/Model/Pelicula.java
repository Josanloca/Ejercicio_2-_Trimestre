package Model;

public class Pelicula {
	
	private int iIdPelicula;
	private String sNombrePelicula;
	private byte bICCA;
	private Genero gGenero;
	
	
	public Pelicula() {

	}
	
	public Pelicula(int iIdPelicula, String sNombrePelicula, byte bICCA, Genero gGenero) {
		this.iIdPelicula = iIdPelicula;
		this.sNombrePelicula = sNombrePelicula;
		this.bICCA = bICCA;
		this.gGenero = gGenero;
	}
	
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
	public Genero getgGenero() {
		return gGenero;
	}
	public void setgGenero(Genero gGenero) {
		this.gGenero = gGenero;
	}

	@Override
	public String toString() {
		return "pelicula [iIdPelicula=" + iIdPelicula + ", sNombrePelicula=" + sNombrePelicula + ", bICCA=" + bICCA
				+ ", gGenero=" + gGenero + "]";
	}
}
