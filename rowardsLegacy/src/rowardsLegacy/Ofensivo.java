package rowardsLegacy;

import java.io.Serializable;

public class Ofensivo extends Hechizo implements Serializable{

	public Ofensivo(String nombre, String descripcion, int defensaObtenida, int ataqueCausado, int espacio, double coste) {
		super(nombre, descripcion, defensaObtenida, ataqueCausado, espacio, coste);
	}
	
	public int ataqueMagico(int bonificacion) {
		int num = (int)(Math.random() * this.ataqueCausado + 1);
		
		if(num < bonificacion/10) {
			return num + bonificacion/10;
		}
		
		return  0;
	}
}
