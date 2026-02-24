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
	}
	
	@Override
	public void lanzarHechizos() {
		
	}
	
	@Override
	public void modificarAtributos(Scanner sc) {
		this.arrojo = Mago.pedirAtributos(sc, " el arrojo");
		this.carisma = Mago.pedirAtributos(sc, " la carisma");
		
		System.out.println("Atributos establecidos correctamente");
	}
	
	
	public void losPelos() {
		
	}

	public int getArrojo() {
		return arrojo;
	}
	
	public int getCarisma() {
		return carisma;
	}
}
