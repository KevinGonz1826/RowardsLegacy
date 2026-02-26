package rowardsLegacy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Escuela {
	Scanner sc = new Scanner(System.in);
	private HashMap<String, Mago> escuela;
	
	public Escuela() {
		this.escuela = new HashMap<String, Mago>();
	}
	
	
	//SUBMENU MAGO
	public void menuMagos() {
		int opc;
		do {
			System.out.println("=======GESTION DE MAGOS=======");
			System.out.println("1. Mostrar todos los magos");
			System.out.println("2. Mostrar un mago");
			System.out.println("3. Añadir un mago");
			System.out.println("4. Modificar un mago");
			System.out.println("5. Eliminar un mago");
			System.out.println("6. Buscar mago por orden y hechizo");
			System.out.println("7. Volver al menu principal");
			System.out.println("Elige una opcion: ");
			
			opc = sc.nextInt();
			sc.nextLine();
			
			switch(opc) {
				case 1:
					mostrarMagos();
					break;
				case 2:
					obtenerMago();
					break;
				case 3:
					anadirMago();
					break;
				case 4:
					modificarMago();
					break;
				case 5:
					eliminarMago();
					break;
				case 6:
					buscarPorOrdenHechizo();
					break;
				case 7:
					System.out.println("Volviendo al menu principal");
					break;
				default:
					System.out.println("Opcion invalida");
			}
		}while(opc != 7);
	}
	
	
	//SUBMENU HECHIZO
	public void menuHechizos() {
		int opc;
		do {
			System.out.println("=======GESTION DE LIBROS HECHIZOS=======");
			System.out.println("1. Mostrar todos los libros");
			System.out.println("2. Mostrar libro de un mago");
			System.out.println("3. Añadir hechizo a un mago");
			System.out.println("4. Modificar un hechizo");
			System.out.println("5. Eliminar un hechizo");
			System.out.println("6. Volver al menu principal");
			System.out.println("Elige una opcion: ");
			
			opc = sc.nextInt();
			sc.nextLine();
			
			switch(opc) {
			case 1:
				mostrarLibros();
				break;
			case 2:
				mostrarlibroMago();
				break;
			case 3:
				anadirHechizos();
				break;
			case 4:
				modificarHechizo();
				break;
			case 5:
				eliminarHechizo();
				break;
			case 6:
				System.out.println("Volviendo al menu principal");
				break;
			default:
				System.out.println("Opcion invalida");
			}
		}while(opc != 6);	
	}
	
	
	
	//FICHEROS
	public void datosPrueba() {
		
		Mago m1 = new Meeplepuf("Pepe", 100, 80, 20, 15.0, 90, 85);
		Mago m2 = new Dicendorf("Manolo", 90, 70, 25, 100.0, 75, 80, 90);
		
		Hechizo h1 = new Ofensivo("Helada", "Congela al rival", 0, 30, 2, 10);
		Hechizo h2 = new Sanacion("Cura", "Restaura salud", 25, 0, 1, 15);
		Hechizo h3 = new Confusion("Neblina", "Ciega al enemigo", 0, 20, 2, 12);
		
		m1.getLibro().anadirHechizo(h1);
		m1.getLibro().anadirHechizo(h2);
		
		m2.getLibro().anadirHechizo(h1);
		m2.getLibro().anadirHechizo(h3);
		
		escuela.put(m1.getNombre(), m1);
		escuela.put(m2.getNombre(), m2);
	}

	
	
	public void guardarDatos() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("RowardsPegacy.bkp"))) {
			oos.writeObject(escuela);
			System.out.println("Partida guardada correctamente");
		} catch (Exception e) {
			System.out.println("Error al guardar los datos: " + e.getMessage());
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void cargarDatos() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("RowardsPegacy.bkp"))){

			escuela = (HashMap<String, Mago>) ois.readObject();
			System.out.println("Partida cargada");
		}catch(IOException e) {
			System.out.println("Error al leer el backup: " + e.getMessage());
		}catch(ClassNotFoundException e) {
			System.out.println(e.getStackTrace());
			e.printStackTrace();
		}
	}
	
	
	
	//METODO PARA PEDIR MAGO
	public Mago pedirMago() {
		System.out.println("Ingresa el nombre del mago: ");
		String nombre = sc.nextLine();
		
		Mago m = escuela.get(nombre);
		if(m == null) {
			System.out.println(nombre + " no existe en la escuela");
		}
		return m;
	}
	
	
	//GESTION DE MAGOS
	public void mostrarMagos() {
		if(escuela.isEmpty()) {
			System.out.println("No existe ningun mago");
			return;
		}
		for(Mago m : escuela.values()) {
			System.out.println(m.toString());
		}
	}
	
	
	private void obtenerMago() {
		Mago m = pedirMago();
		if(m != null)
			System.out.println(m.toString());
	}
	
	
	public void buscarPorOrdenHechizo() {
		System.out.println("Introduce la orden");
		System.out.println("Dicendorf, Meeplepuf, Tokenclau o Sleeverin");
		String orden = sc.nextLine();
		
		System.out.println("Ingresa el nombre del hechizo");
		String hechizo = sc.nextLine();
		
		boolean encontrado = false;
		
		System.out.println("Magos de " + orden + " con el hechizo " + hechizo);
		
		for(Mago m : escuela.values()) {
			if((orden.equalsIgnoreCase("Dicendorf") && m instanceof Dicendorf) ||
			(orden.equalsIgnoreCase("Meeplepuf") && m instanceof Meeplepuf) ||
			(orden.equalsIgnoreCase("Tokenclau") && m instanceof Tokenclau) ||
			(orden.equalsIgnoreCase("Sleeverin") && m instanceof Sleeverin)){
				
				if(m.getLibro().obtenerHechizo(hechizo) != null) {
					System.out.println("-" + m.getNombre());
					encontrado = true;
				}
			}	
		}
		
		if(!encontrado) {
			System.out.println("no se encontro nada");
		}
	}
	
	
	public void anadirMago() {
		Mago mago = null;
		
		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		
		if(escuela.containsKey(nombre)) {
			System.out.println("Ya existe un mago con el nombre " + nombre);
			return;
		}
		
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
				int eficiencia = Mago.pedirAtributos(sc, "la eficiencia");
				int honor = Mago.pedirAtributos(sc, "el honor");
				
				mago = new Meeplepuf(nombre, v, a, r, p, eficiencia, honor);
				System.out.println(nombre + " ha ingresado a la escuela");
				break;
				
			case "Dicendorf":
				int predisposicion = Mago.pedirAtributos(sc, "la predisposicion");
				int inconsciencia = Mago.pedirAtributos(sc, "la inconsciencia");
				int protagonismo = Mago.pedirAtributos(sc, "el protagonismo");
				
				mago = new Dicendorf(nombre, v, a, r, p, predisposicion, inconsciencia, protagonismo);
				System.out.println(nombre + " ha ingresado a la escuela");
				break;
				
			case "Tokenclau":
				int arrojo = Mago.pedirAtributos(sc, "el arrojo");
				int carisma = Mago.pedirAtributos(sc, "la carisma");
				
				mago = new Tokenclau(nombre, v, a, r, p, arrojo, carisma);
				System.out.println(nombre + " ha ingresado a la escuela");
				break;
				
			case "Sleeverin":
				int sigilo = Mago.pedirAtributos(sc, "el sigilo");
				int venenoso = Mago.pedirAtributos(sc, "el veneno");
				int habla = Mago.pedirAtributos(sc, "el habla con animales");
				mago = new Sleeverin(nombre, v, a, r, p, sigilo, venenoso, habla);
				System.out.println(nombre + " ha ingresado a la escuela");
				break;
				
			default:
				System.out.println("Tipo de mago incorrecto");
		}
		
		escuela.put(nombre, mago);
	}
	
	
	public void eliminarMago() {
		Mago m = pedirMago();
		if(m !=null) {
			escuela.remove(m.getNombre());
			System.out.println(m.getNombre() + " se ha eliminado correctamente");
		}
	}
	
	
	public void modificarMago() {
		Mago m = pedirMago();
		
		System.out.println("Que atributo deseas modificar?");
		System.out.println("1. Nombre");
		System.out.println("2. Vida");
		System.out.println("3. Afinidad");
		System.out.println("4. Resistencia");
		System.out.println("5. Plomo");
		System.out.println("6. Otros (Datos especificos de cada tipo de mago)");
		int opc = sc.nextInt();
		sc.nextLine();
		
		switch(opc){
			case 1:
				m.setNombre(sc.nextLine());
				break;
			
			case 2:
				m.setVida(sc.nextInt());
				break;
			
			case 3:
				m.setAfinidad(sc.nextInt());
				break;
			
			case 4:
				m.setResistencia(sc.nextInt());
				break;
				
			case 5:
				m.setPlomo(sc.nextDouble());
				break;
				
			case 6:
				m.modificarAtributos(sc);
				break;
				
			default:
				System.out.println("Opcion invalida");
		}
	}
	
	
	
	
	//GESTION DE HECHIZOS
	public void mostrarLibros() {
		if(escuela.isEmpty()) {System.out.println("No se ha encontrado nada"); return;}
		System.out.println("========LIBROS DE MAGOS========");
		for(Mago m : escuela.values()) {
			System.out.println("Mago: " + m.getNombre());
			System.out.println(m.getLibro().toString());
		}
	}
	
	public void mostrarlibroMago() {
		Mago m = pedirMago();
		
		if(m == null) {return;}
		System.out.println(m.getLibro().toString());
	}
	
	
	public void anadirHechizos() {
		Mago m = pedirMago();
		Hechizo h = null;
		
		if(m == null) {return;}
		System.out.println("Ingresa el nombre: ");
		String n = sc.nextLine();
		
		System.out.println("Ingresa la descripcion: ");
		String des = sc.nextLine();
		
		System.out.println("Ingresa la defensa obtenida: ");
		int def = sc.nextInt();
		
		System.out.println("Ingresa el ataque causado: ");
		int at = sc.nextInt();
		
		System.out.println("Ingresa el espacio: ");
		int es = sc.nextInt();
		
		System.out.println("Ingresa el coste: ");
		double cos = sc.nextDouble();
		
		System.out.println("Que tipo de hechizo quieres que sea?");
		System.out.println("1. Sanacion");
		System.out.println("2. Confusion");
		System.out.println("3. Defensivo");
		System.out.println("4. Ofensivo");
		int opc = sc.nextInt();
		
		switch(opc){
			case 1:
				h = new Sanacion(n, des, def, at, es, cos);
				m.getLibro().anadirHechizo(h);
				break;
				
			case 2:
				h = new Confusion(n, des, def, at, es, cos);
				m.getLibro().anadirHechizo(h);
				break;
				
			case 3:
				h = new Defensivo(n, des, def, at, es, cos);
				m.getLibro().anadirHechizo(h);
				break;
				
			case 4: 
				h = new Ofensivo(n, des, def, at, es, cos);
				m.getLibro().anadirHechizo(h);
				break;
			
			default:
				System.out.println("Opcion invalida");
		}
	}
	
	
	public void modificarHechizo() {
		Mago m = pedirMago();

		if(m == null) {return;}
		for(Hechizo h : m.getLibro().getHechizos()) {
			System.out.println("-" + h.getNombre());
		}
		
		System.out.println("Ingresa el nombre del hechizo que quieres modificar");
		String nombre = sc.nextLine();
		
		Hechizo h = m.getLibro().obtenerHechizo(nombre);
		System.out.println("Que atributo deseas modificar?");
		System.out.println("1. Nombre");
		System.out.println("2. Descripcion");
		System.out.println("3. Defensa obtenida");
		System.out.println("4. Ataque causado");
		System.out.println("5. Espacio");
		System.out.println("6. Coste");
		
		int opc = sc.nextInt();
		sc.nextLine();
		
		switch(opc) {
			case 1:
				h.setNombre(sc.nextLine());
				break;
				
			case 2:
				h.setDescripcion(sc.nextLine());
				break;
			
			case 3:
				h.setDefensaObtenida(sc.nextInt());
				break;
				
			case 4:
				h.setAtaqueCausado(sc.nextInt());
				break;
				
			case 5:
				h.setEspacio(sc.nextInt());
				break;
				
			case 6:
				h.setCoste(sc.nextDouble());
				break;
				
			default:
				System.out.println("Opcion invalida");
		}
	}
	
	
	public void eliminarHechizo() {
		Mago m = pedirMago();
		
		if(m == null) {return;}
		for(Hechizo h : m.getLibro().getHechizos()) {
			System.out.println("-" + h.getNombre());
		}
		
		System.out.println("Ingresa el nombre del hechizo que quieres eliminar: ");
		String nombre = sc.nextLine();
		
		m.getLibro().eliminarHechizo(nombre);
	}
	
	
	
	
	//DUELO DE MAGOS
	public void dueloMagos() {
		Mago atacante = pedirMago();
		if(atacante == null) {return;}
		
		System.out.println("Magos para enfrentarse");
		for(Mago m : escuela.values()) {
			if(!m.getNombre().equalsIgnoreCase(atacante.getNombre())) {
				System.out.println("-" + m.getNombre());
			}
		}
		
		System.out.println("Elige uno: ");
		Mago defensor = pedirMago();
		if(defensor == null) {return;}
		
		//VERIFICA SI EL NOMBRE INGRESADO NO SEA EL MISMO QUE EL NOMBRE DEL ATACANTE
		if(defensor.getNombre().equalsIgnoreCase(atacante.getNombre())) {
			System.out.println("Rival no valido");
		}
		
		System.out.println(atacante.getNombre() + " VS " + defensor.getNombre());
		
		boolean combate = true;
		Mago turnoActual = atacante;
		Mago rival = defensor;
		
		
		//BUCLE PRINCIPAL DEL COMBATE 
		while(combate && atacante.getVida() > 0 && defensor.getVida() > 0) {
			System.out.println("Turno de " + turnoActual.getNombre());
			System.out.println("Vida: " + turnoActual.getVida() + " | Afinidad : " + turnoActual.getAfinidad());
			System.out.println("Vida rival: " + rival.getVida() + " | Afinidad rival: " + rival.getAfinidad());
			
			boolean accion = false;
			
			//BUCLE PARA LA ACCION DE CADA MAGO
			while(!accion) {
				boolean confuso = turnoActual.getTurnosConfuso() > 0;
				
				if(confuso) {
					System.out.println("Tienes " + turnoActual.getTurnosConfuso() + " turnos de confusion");
					turnoActual.setTurnosConfuso(turnoActual.getTurnosConfuso() - 1);
					
					System.out.println("1. Usar habilidad, tienes " + turnoActual.getHabilidad() + " usos");
					System.out.println("2. Rendirse");
					
					int opc = sc.nextInt();
					sc.nextLine();
					
					switch(opc) {
						case 1:
							accion = usarHabilidad(turnoActual, rival);
							accion = true;
							break;
						case 2:
							System.out.println(turnoActual.getNombre() + " huye del combate");
							combate = false;
							accion = true;
							break;
						default:
							System.out.println("Opcion no valida");
					}
					
				}else {
					for(Hechizo h : turnoActual.getLibro().getHechizos()) {
						System.out.println("-" + h.getNombre());
					}
					
					System.out.println("1. Lanzar hechizo");
					System.out.println("2. Usar habilidad, tienes " + turnoActual.getHabilidad() + " usos");
					System.out.println("3. rendirse");
					
					int opcion = sc.nextInt();
					sc.nextLine();
					
					switch(opcion) {
						case 1:
							//COMPRUEBA SI TIENE HECHIZOS
							if(turnoActual.getLibro().getHechizos().isEmpty()){
								System.out.println("No tienes hechizos");
								break;
							}
							
							System.out.println("Que hechizo quieres lanzar?");
							int i = 1;
							
							//LISTA TODOS LOS HECHIZOS DEL MAGO 
							for(Hechizo h : turnoActual.getLibro().getHechizos()) {
								System.out.println(i + ". " + h.getNombre());
								i++;
							}
							System.out.println(i + ". Cancelar");
							
							int opcionHechizo = sc.nextInt();
							sc.nextLine();
							
							//VALIDACION PARA VER SI EL NUMERO INTRODUCIDO COINCIDE CON UN HECHIZO DE LA LISTA
							if(opcionHechizo > 0 && opcionHechizo <= turnoActual.getLibro().getHechizos().size()) {
								Hechizo h = turnoActual.getLibro().getHechizos().get(opcionHechizo - 1);
								
								//VALIDACION PARA VER SI TIENE AFINIDAD SUFICIENTE
								if(turnoActual.getAfinidad() >= h.getCoste()) {
									turnoActual.setAfinidad((int) (turnoActual.getAfinidad() - h.getCoste()));
									System.out.println(turnoActual.getNombre() + " lanza " + h.getNombre());
									
									int bonificacion = turnoActual.lanzarHechizos(h);
									ejecutarHechizo(h, turnoActual, rival, bonificacion);
									accion = true;	
								}else {
									System.out.println("Afinidad insuficiente");
								}
							}else if(opcionHechizo == i) {
								System.out.println("Cancelado");
							}else {
								System.out.println("Opcion incorrecta");
							}
							break;
							
						case 2:
							accion = usarHabilidad(turnoActual, rival);
							break;
							
						case 3:
							System.out.println(turnoActual.getNombre() + " se rinde");
							combate = false;
							accion = true;
							break;
							
						default:
							System.out.println("Opcion no valida");
					}
				}
			}
			
			//CAMBIO DE TURNO
			if(combate && atacante.getVida() > 0 && defensor.getVida() > 0) {
				Mago temp = turnoActual;
				turnoActual = rival;
				rival = temp;
			}
		}
		
		System.out.println("\nFIN DEL COMBATE ");
		if(atacante.getVida() <= 0) {
			System.out.println("GANADOR: " + defensor.getNombre());
		}else if(defensor.getVida() <= 0) {
			System.out.println("GANADOR: " + atacante.getNombre());
		}else System.out.println(turnoActual.getHabilidad() + " ha perdido");
	}
	
	
	
	private void ejecutarHechizo(Hechizo h, Mago atacante, Mago rival, int bonificacion) {
		int res = 0;
		
		if(h instanceof Ofensivo) {
			res = ((Ofensivo) h).ataqueMagico(bonificacion);
			
			if(res > 0 && res > rival.getResistencia()) {
				int dano = res - rival.getResistencia();
				rival.setVida(rival.getVida() - dano);
				System.out.println(rival.getNombre() + " recibe " + dano + " puntos de daño");
			}else {
				System.out.println("el rival resistio el ataque o fallo el hechizo");
			}
		}else if(h instanceof Sanacion) {
			res = ((Sanacion) h).restaurarSalud(bonificacion);
			
			if(res > 0) {
				int cura = (int) (Math.random() * res + 1);
				atacante.setVida(atacante.getVida() + cura);
				System.out.println(atacante.getNombre() + " recupera " + cura + " puntos de salud");
			}else {
				System.out.println("El hechizo fallo");
			}
		}else if(h instanceof Confusion) {
			res = ((Confusion) h).confundirMago(bonificacion);
			
			if (res > 0 && res > rival.getResistencia()) {
				int turnos = (int) (Math.random() * 4 + 1);
				rival.setTurnosConfuso(rival.getTurnosConfuso() + turnos);
				System.out.println(rival.getNombre() + " estara confuso por " + turnos + " turnos");
			} else {
				System.out.println("El rival resistio la confusion");
			}
		}else if(h instanceof Defensivo) {
			res = ((Defensivo) h).defensaMagico(bonificacion);
			
			if(res > 0) {
				atacante.setResistencia(atacante.getResistencia() + 1);
				System.out.println("Tu resistencia ha aumentado");
			}else {
				System.out.println("El hechizo fallo");
			}
		}
	}
	
	
	
	private boolean usarHabilidad(Mago atacante, Mago rival) {
		
		if (atacante.getHabilidad() <= 0) {
			System.out.println("Ya no te quedan usos de tu habilidad");
			return false;
		}

		if (atacante instanceof Dicendorf) {
			((Dicendorf) atacante).sablazoFactura(rival);
		} 
		else if (atacante instanceof Meeplepuf) {
			((Meeplepuf) atacante).ultimaVamos(rival);
		} 
		else if (atacante instanceof Sleeverin) {
			((Sleeverin) atacante).misOros(rival);
		} 
		else if (atacante instanceof Tokenclau) {
			((Tokenclau) atacante).losPelos();
		}

		return true;
	}
}
