package rowardsLegacy;
import java.io.Serializable;
import java.util.Scanner;

public abstract class Mago implements Serializable{
	protected String nombre;
	protected int vida;
	protected int afinidad;
	protected int resistencia;
	protected double plomo;
	protected LibroHechizos libro;
	
	protected int turnosConfuso;
	
	public Mago(String nombre, int vida, int afinidad, int resistencia, double plomo) {
		this.nombre = nombre;
		this.vida= vida;
		this.afinidad = afinidad;
		this.resistencia = resistencia;
		this.plomo = plomo;
		this.turnosConfuso = 0;
		this.libro = new LibroHechizos(this.afinidad);
	}	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAfinidad() {
		return afinidad;
	}

	public void setAfinidad(int afinidad) {
		this.afinidad = afinidad;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public double getPlomo() {
		return plomo;
	}

	public void setPlomo(double plomo) {
		this.plomo = plomo;
	}

	public LibroHechizos getLibro() {
		return libro;
	}

	public void setLibro(LibroHechizos libro) {
		this.libro = libro;
	}

	public int getTurnosConfuso() {
		return turnosConfuso;
	}

	public void setTurnosConfuso(int turnosConfuso) {
		this.turnosConfuso = turnosConfuso;
	}

	public abstract void lanzarHechizos();

	public abstract void modificarAtributos(Scanner sc);
	@Override
	public String toString() {
		return "Mago [nombre=" + nombre + ", vida=" + vida + ", afinidad=" + afinidad + ", resistencia=" + resistencia
				+ ", plomo=" + plomo + ", libro=" + libro + "]";
	}
	
	
	public static int pedirAtributos(Scanner sc, String nombre) {
		int valor = 0;
		do {
			System.out.println("Ingresa " + nombre + " (entre 0-100): ");
			valor = sc.nextInt();
			
			if(valor < 0 || valor > 100) {
				System.out.println("El valor no puede ser menor que 0 ni mayor que 100");
			}
		}while(valor < 0 || valor > 100);
		
		return valor;
	}
}
