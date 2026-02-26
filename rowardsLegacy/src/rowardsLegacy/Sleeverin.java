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
		this.turnosConfuso = 0;
		this.habilidad = 1;
	}
	
	@Override
	public int lanzarHechizos(Hechizo h) {
		if(h instanceof Ofensivo) {
			return this.sigilo + this.venenoso + this.hablarAnimales;
		}else if(h instanceof Confusion) {
			return this.sigilo + this.hablarAnimales;
		}else if(h instanceof Defensivo) {
			return this.sigilo;
		}
		return 0;
	}
	
	@Override
	public void modificarAtributos(Scanner sc) {
		this.sigilo = Mago.pedirAtributos(sc, " el sigilo");
		this.venenoso = Mago.pedirAtributos(sc, " el veneno");
		this.hablarAnimales = Mago.pedirAtributos(sc, " el habla con animales");
		
		System.out.println("Atributos establecidos correctamente");
	}
	
	
	public void misOros(Mago m) {
		if(this.habilidad <= 0) {
			System.out.println("Ya no puedes usar tu habilidad");
			return;
		}
		
		int dano1 = (int)(Math.random() * 6 + 1);
		int dano2 = (int)(Math.random() * 6 + 1);
		int dano3 =	(int)(Math.random() * 6 + 1);
		
		int total = dano1+dano2+dano3;
		
		int lanzador = (int)(Math.random() * 12 + 1);
		
		this.vida -= lanzador; 
		m.setVida(m.getVida()-total);
		this.habilidad--;
		
		System.out.println(this.nombre + " hace " + total + "puntos de daño a " + m.getNombre());
		System.out.println(this.nombre + " recibe " + lanzador + "puntos de daño por el efecto de su habilidad");
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
