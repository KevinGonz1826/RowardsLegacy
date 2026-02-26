package rowardsLegacy;

import java.io.Serializable;
import java.util.Scanner;

public class Meeplepuf extends Mago implements Serializable{
	private int eficiencia;
	private int honor;
	
	public Meeplepuf(String nombre, int vida, int afinidad, int resistencia, double plomo, int eficiencia, int honor) {
		super(nombre, vida, afinidad, resistencia, plomo);
		this.eficiencia = eficiencia;
		this.honor = honor;
	}
	
	@Override
	public void lanzarHechizos() {
		
	}
	
	@Override
	public void modificarAtributos(Scanner sc) {
		this.eficiencia = Mago.pedirAtributos(sc, " la eficiencia");
		this.honor = Mago.pedirAtributos(sc, " el honor");
		
		System.out.println("Atributos establecidos correctamente");
	}
	
	
	public void ultimaVamos() {
		
	}
	
	public int getEficiencia() {
		return eficiencia;
	}

	public int getHonor() {
		return honor;
	}
	
}
