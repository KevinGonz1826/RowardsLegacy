package rowardsLegacy;
import java.util.ArrayList;
import java.io.Serializable;

public class LibroHechizos implements Serializable{
	private int paginasTotales;
	private int paginasOcupadas;
	private ArrayList<Hechizo> hechizos;
	
	public LibroHechizos(int afinidad) {
		this.paginasTotales = afinidad / 10;
		this.paginasOcupadas = 0;
		this.hechizos = new ArrayList<Hechizo>();
	}
	
	
	public boolean anadirHechizo(Hechizo h) {
		
		return false;
	}
	
	
	public boolean eliminarHechizo(String nHechizo) {
		
		return false;
	}
	
	
	public int getPaginasTotales() {
		return paginasTotales;
	}
	
	public int getPaginasOcupadas() {
		return paginasOcupadas;
	}
	
	public ArrayList<Hechizo> getHechizos(){
		return hechizos;
	}
}
