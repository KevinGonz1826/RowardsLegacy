package rowardsLegacy;
import java.io.Serializable;

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

	public int getVida() {
		return vida;
	}

	public int getAfinidad() {
		return afinidad;
	}

	public int getResistencia() {
		return resistencia;
	}

	public double getPlomo() {
		return plomo;
	}

	public LibroHechizos getLibro() {
		return libro;
	}

	public void setLibro(LibroHechizos libro) {
		this.libro = libro;
	}
	
	
	public abstract void lanzarHechizos();

	@Override
	public String toString() {
		return "Mago [nombre=" + nombre + ", vida=" + vida + ", afinidad=" + afinidad + ", resistencia=" + resistencia
				+ ", plomo=" + plomo + ", libro=" + libro + "]";
	}
	
	
	
}
