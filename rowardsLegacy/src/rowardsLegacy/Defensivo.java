package rowardsLegacy;

import java.io.Serializable;

public class Defensivo extends Hechizo implements Serializable{

	public Defensivo(String nombre, String descripcion, int defensaObtenida, int ataqueCausado, int espacio, double coste) {
		super(nombre, descripcion, defensaObtenida, ataqueCausado, espacio, coste);
	}
	
	
	public int defensaMagico(int bonificacion) {
		int num = (int)(Math.random() * this.defensaObtenida + 1);
		
		if(num < bonificacion/10) {
			return num + bonificacion/10;
		}
		
		return 0;
	}
}
