package Model;

public class Sala_cine {

	private byte bId_sala_cine;
	private byte bCapacidad_Max;
	private byte bCapacidad_Act;
	private Pelicula oPelicula;
	
	
	
	public Sala_cine() {

	}
		
	public Sala_cine(byte bId_sala_cine, byte bCapacidad_Max, byte bCapacidad_Act, Pelicula oPelicula) {
		this.bId_sala_cine = bId_sala_cine;
		this.bCapacidad_Max = bCapacidad_Max;
		this.bCapacidad_Act = bCapacidad_Act;
		this.oPelicula = oPelicula;
	}

	public byte getbId_sala_cine() {
		return bId_sala_cine;
	}
	
	public void setbId_sala_cine(byte bId_sala_cine) {
		this.bId_sala_cine = bId_sala_cine;
	}
	
	public byte getbCapacidad_Max() {
		return bCapacidad_Max;
	}
	
	public void setbCapacidad_Max(byte bCapacidad_Max) {
		this.bCapacidad_Max = bCapacidad_Max;
	}
	
	public byte getbCapacidad_Act() {
		return bCapacidad_Act;
	}
	
	public void setbCapacidad_Act(byte bCapacidad_Act) {
		this.bCapacidad_Act = bCapacidad_Act;
	}
	
	public Pelicula getoPelicula() {
		return oPelicula;
	}
	
	public void setoPelicula(Pelicula oPelicula) {
		this.oPelicula = oPelicula;
	}

	@Override
	public String toString() {
		return "sala_cine [bId_sala_cine=" + bId_sala_cine + ", bCapacidad_Max=" + bCapacidad_Max + ", bCapacidad_Act="
				+ bCapacidad_Act + ", oPelicula=" + oPelicula + "]";
	}
}