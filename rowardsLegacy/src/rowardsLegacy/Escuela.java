package rowardsLegacy;

import java.util.HashMap;
import java.util.Scanner;

public class Escuela {
	Scanner sc = new Scanner(System.in);
	private HashMap<String, Mago> escuela;
	
	public Escuela() {
		this.escuela = new HashMap<String, Mago>();
	}
	
	public void mostrarMagos() {
		for(Mago m : escuela.values()) {
			System.out.println(m.toString());
		}
	}
	
	
	public void obtenerMago() {
		System.out.println("Ingresa el nombre del mago");
		String nombre = sc.nextLine();
		
		Mago m = escuela.get(nombre);
		if(m == null) {
			System.out.println("El mago llamado " + nombre + " no existe");
			return;
		}
		System.out.println(m.toString());
	}
	
	
	public void anadirMago() {
		Mago mago = null;
		
		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		
		System.out.println("Vida: ");
		int v = sc.nextInt();
		
		System.out.println("Afinidad: ");
		int a = sc.nextInt();
		
		System.out.println("Resistencia: ");
		int r = sc.nextInt();
		
		System.out.println("Plomo: ");
		double p = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Orden: ");
		String orden = sc.nextLine();
		
		switch(orden) {
			case "Meeplepuf":
				System.out.println("Ingresa la eficiencia(entre 0-100): ");
				int eficiencia = sc.nextInt();
				if(!(eficiencia >= 0) && !(eficiencia <= 100)) {
					System.out.println("La eficiencia no puede ser menos de 0 ni mas de 100");
					break;
				}
				
				System.out.println("Ingresa el honor(entre 0-100): ");
				int honor = sc.nextInt();
				if(!(honor >= 0) && !(honor <= 100)) {
					System.out.println("La eficiencia no puede ser menos de 0 ni mas de 100");
					break;
				}
				
				mago = new Meeplepuf(nombre, v, a, r, p, eficiencia, honor);
				System.out.println(nombre + " se ha añadido a la escuela");
				break;
				
			case "Dicendorf":
				System.out.println("Ingresa la predisposicion(entre 0-100): ");
				int predisposicion = sc.nextInt();
				if(!(predisposicion >= 0) && !(predisposicion <= 100)) {
					System.out.println("La predisposicion no puede ser menos de 0 ni mas de 100");
					break;
				}
				
				System.out.println("Ingresa la inconsciencia(entre 0-100): ");
				int inconsciencia = sc.nextInt();
				if(!(inconsciencia >= 0) && !(inconsciencia <= 100)) {
					System.out.println("La inconsciencia no puede ser menos de 0 ni mas de 100");
					break;
				}
				
				System.out.println("Ingresa el protagonismo(entre 0-100): ");
				int protagonismo = sc.nextInt();
				if(!(protagonismo >= 0) && !(protagonismo <= 100)) {
					System.out.println("El protagonismo no puede ser menos de 0 ni mas de 100");
					break;
				}
				
				mago = new Dicendorf(nombre, v, a, r, p, predisposicion, inconsciencia, protagonismo);
				System.out.println(nombre + " se ha añadido a la escuela");
				break;
				
			case "Tokenclau":
				System.out.println("Ingresa el arrojo(entre 0-100): ");
				int arrojo = sc.nextInt();
				if(!(arrojo >= 0) && !(arrojo <= 100)) {
					System.out.println("El arrojo no puede ser menos de 0 ni mas de 100");
					break;
				}
				
				System.out.println("Ingresa la carisma(entre 0-100): ");
				int carisma = sc.nextInt();
				if(!(carisma >= 0) && !(carisma <= 100)) {
					System.out.println("La carisma no puede ser menos de 0 ni mas de 100");
					break;
				}
				
				mago = new Tokenclau(nombre, v, a, r, p, arrojo, carisma);
				System.out.println(nombre + " se ha añadido a la escuela");
				break;
				
			case "Sleeverin":
				System.out.println("Ingresa el sigilo(entre 0-100): ");
				int sigilo = sc.nextInt();
				if(!(sigilo >= 0) && !(sigilo <= 100)) {
					System.out.println("El sigilo no puede ser menos de 0 ni mas de 100");
					break;
				}
				
				System.out.println("Ingresa el veneno(entre 0-100): ");
				int veneno = sc.nextInt();
				if(!(veneno >= 0) && !(veneno <= 100)) {
					System.out.println("El veneno no puede ser menos de 0 ni mas de 100");
					break;
				}
				
				System.out.println("Ingresa el habla con animales(entre 0-100): ");
				int habla = sc.nextInt();
				if(!(habla >= 0) && !(habla <= 100)) {
					System.out.println("El habla con animales no puede ser menos de 0 ni mas de 100");
					break;
				}
				
				mago = new Sleeverin(nombre, v, a, r, p, sigilo, veneno, habla);
				System.out.println(nombre + " se ha añadido a la escuela");
				break;
				
			default:
				System.out.println("Tipo de mago incorrecto");
		}
	}
	
	
	public void eliminarMago() {
		System.out.println("Ingresa el nombre del mago que quieres eliminar");
		String nombre = sc.nextLine();
		
		if(!escuela.containsKey(nombre)) {
			System.out.println("Este mago no existe");
			return;
		}
		
		escuela.remove(nombre);
		System.out.println(nombre + " se ha eliminado correctamente");
	}
	
	
	public void modificarMago() {
		
	}
}
