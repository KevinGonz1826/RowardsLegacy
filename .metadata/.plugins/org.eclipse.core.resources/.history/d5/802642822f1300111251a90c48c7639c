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
		if(this.paginasOcupadas + h.getEspacio() > this.paginasTotales) {
			System.out.println("No hay paginas libres en el libro " + this.paginasOcupadas + "/" + this.paginasTotales);
			return false;
		}
		
		for(Hechizo he : hechizos) {
			if(he.getNombre().equalsIgnoreCase(h.getNombre())) {
				System.out.println("Ya existe un hechizo llamado " + h.getNombre() + " en el libro");
				return false;
			}
		}
		
		this.hechizos.add(h);
		this.paginasOcupadas += h.getEspacio();
		System.out.println("Hechizo " + h.getNombre() + " añadido con exito");
		return true;
	}
	
	
	public boolean eliminarHechizo(String nHechizo) {
		for(Hechizo h : hechizos) {
			if(h.getNombre().equalsIgnoreCase(nHechizo)) {
				this.paginasOcupadas -= h.getEspacio();
				this.hechizos.remove(h);
				System.out.println("Se elimino " + nHechizo + " del libro");
				return true;
			}
		}
		return false;
	}
	
	
	public Hechizo obtenerHechizo(String nHehizo) {
		for(Hechizo h : hechizos) {
			if(h.getNombre().equalsIgnoreCase(nHehizo)) {
				return h;
			}
		}
		return null;
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


	//MEJORARLO CON STRING BUILDER
	@Override
	public String toString() {
		return "LibroHechizos [paginasTotales=" + paginasTotales + ", paginasOcupadas=" + paginasOcupadas
				+ ", hechizos=" + hechizos + "]";
	}
	
	
}
