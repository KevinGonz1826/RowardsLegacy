package rowardsLegacy;

import java.io.Serializable;
import java.util.Scanner;

public class Sleeverin extends Mago implements Serializable{
	private int sigilo;
	private int venenoso;
	private int hablarAnimales;
	
	public Sleeverin(String nombre, int vida, int afinidad, int resistencia, double plomo, int sigilo, int venenoso, int hablarAnimales) {
		super(nombre, vida, afinidad, resistencia, plomo);
		this.sigilo = sigilo;
		this.venenoso = venenoso;
		this.hablarAnimales = hablarAnimales;
	}
	
	@Override
	public void lanzarHechizos() {
		
	}
	
	@Override
	public void modificarAtributos(Scanner sc) {
		this.sigilo = Mago.pedirAtributos(sc, " el sigilo");
		this.venenoso = Mago.pedirAtributos(sc, " el veneno");
		this.hablarAnimales = Mago.pedirAtributos(sc, " el habla con animales");
		
		System.out.println("Atributos establecidos correctamente");
	}
	
	
	public void misOros() {
		
	}

	public int getSigilo() {
		return sigilo;
	}

	public int getVenenoso() {
		return venenoso;
	}

	public int getHablarAnimales() {
		return hablarAnimales;
	}
	
}
