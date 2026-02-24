package rowardsLegacy;

public class Confusion extends Hechizo{

	public Confusion(String nombre, String descripcion, int defensaObtenida, int ataqueCausado, int espacio, double coste) {
		super(nombre, descripcion, defensaObtenida, ataqueCausado, espacio, coste);
	}
	
	
	public int confundirMago(int bonificacion) {
		int num = (int)(Math.random() * this.ataqueCausado + 1);
		
		if(num < bonificacion/10) {
			return num + bonificacion/10;
		}
		
		return 0;
	}
}
