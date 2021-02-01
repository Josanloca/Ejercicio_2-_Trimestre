package Model;

public class sala_cine {

	private byte bId_sala_cine;
	private byte bCapacidad_Max;
	private byte bCapacidad_Act;
	private pelicula oPelicula;
	
	
	
	public sala_cine() {

	}
		
	public sala_cine(byte bId_sala_cine, byte bCapacidad_Max, byte bCapacidad_Act, pelicula oPelicula) {
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
	
	public pelicula getoPelicula() {
		return oPelicula;
	}
	
	public void setoPelicula(pelicula oPelicula) {
		this.oPelicula = oPelicula;
	}

	@Override
	public String toString() {
		return "sala_cine [bId_sala_cine=" + bId_sala_cine + ", bCapacidad_Max=" + bCapacidad_Max + ", bCapacidad_Act="
				+ bCapacidad_Act + ", oPelicula=" + oPelicula + "]";
	}
}