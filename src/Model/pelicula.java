package Model;

public class pelicula {
	
	private int iIdPelicula;
	private String sNombrePelicula;
	private byte bICCA;
	private genero gGenero;
	
	
	public pelicula() {

	}
	
	public pelicula(int iIdPelicula, String sNombrePelicula, byte bICCA, genero gGenero) {
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
	public genero getgGenero() {
		return gGenero;
	}
	public void setgGenero(genero gGenero) {
		this.gGenero = gGenero;
	}

	@Override
	public String toString() {
		return "pelicula [iIdPelicula=" + iIdPelicula + ", sNombrePelicula=" + sNombrePelicula + ", bICCA=" + bICCA
				+ ", gGenero=" + gGenero + "]";
	}
}
