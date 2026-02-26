package rowardsLegacy;

import java.io.Serializable;
import java.util.Scanner;

public class Tokenclau extends Mago implements Serializable{
	private int arrojo;
	private int carisma;
	
	public Tokenclau(String nombre, int vida, int afinidad, int resistencia, double plomo, int arrojo, int carisma) {
		super(nombre, vida, afinidad, resistencia, plomo);
		this.arrojo = arrojo;
		this.carisma = carisma;
		this.turnosConfuso = 0;
		this.habilidad = 2;
	}
	
	@Override
	public int lanzarHechizos(Hechizo h) {
		if(h instanceof Sanacion || h instanceof Ofensivo) {
			return this.arrojo + this.carisma;
		}else if(h instanceof Confusion) {
			return this.arrojo - this.carisma;
		}else if(h instanceof Defensivo) {
			return this.carisma - this.arrojo;
		}
		return 0;
	}
	
	@Override
	public void modificarAtributos(Scanner sc) {
		this.arrojo = Mago.pedirAtributos(sc, " el arrojo");
		this.carisma = Mago.pedirAtributos(sc, " la carisma");
		
		System.out.println("Atributos establecidos correctamente");
	}
	
	
	public void losPelos() {
		if(this.habilidad <= 0) {
			System.out.println("Ya no puedes usar tu habilidad");
			return;
		}
		
		int efecto = (int)(Math.random()*2);
		
		if(efecto == 0) {
			int res1 = (int)(Math.random() * 6 + 1);
			int res2 = (int)(Math.random() * 6 + 1);
			int total = res1 + res2;
			this.vida += total;
			System.out.println(this.nombre + " recupera" + total + " puntos de vida");
		}else {
			int afinid = (int)(Math.random() * 8 + 1);
			this.afinidad += afinid;
			System.out.println(this.nombre + " recupera" + afinid + " puntos de afinidad");
		}
		
		this.habilidad--;
	}
	

	public int getArrojo() {
		return arrojo;
	}
	
	public int getCarisma() {
		return carisma;
	}
}
