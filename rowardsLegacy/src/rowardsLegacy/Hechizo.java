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
}
