package rowardsLegacy;

import java.io.Serializable;

public abstract class Hechizo implements Serializable{
	protected String nombre;
	protected String descripcion;
	protected int defensaObtenida;
	protected int ataqueCausado;
	protected int espacio;
	protected double coste;
	
	public Hechizo(String nombre, String descripcion, int defensaObtenida, int ataqueCausado, int espacio, double coste) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.defensaObtenida = defensaObtenida;
		this.ataqueCausado = ataqueCausado;
		this.espacio = espacio;
		this.coste = coste;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDefensaObtenida() {
		return defensaObtenida;
	}

	public void setDefensaObtenida(int defensaObtenida) {
		this.defensaObtenida = defensaObtenida;
	}

	public int getAtaqueCausado() {
		return ataqueCausado;
	}

	public void setAtaqueCausado(int ataqueCausado) {
		this.ataqueCausado = ataqueCausado;
	}

	public int getEspacio() {
		return espacio;
	}

	public void setEspacio(int espacio) {
		this.espacio = espacio;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}
}
