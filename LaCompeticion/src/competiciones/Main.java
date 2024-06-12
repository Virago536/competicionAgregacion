package competiciones;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		//Atributos competición
		String atrCodComp, atrDescComp, atrProvinciaComp;
		
		//Atributos equipos
		String atrCodigo, atrDescE, atrNombreResp, atrApResp, atrCiudad, atrEmail, atrTfno;
		int atrJugadores;
		
		//Atributos jugador
		String atrDni, atrNombre, atrApellidos, atrEquipo, compararEstado;
		boolean atrEstado;
		
		//Atributo respuesta switch
		String resp;
		int respInt = 0;
		
		Equipo[] listaDeEquipos;
		Jugador[] listaDeJugadores;
		
		//Atributos fichero
		String ruta;
		PrintWriter miFichero= null;
		
		Scanner sc = new Scanner(System.in);
		
		boolean loop = true;
		
		Competicion Liga = new Competicion(null, null, null);
		
		
		while(loop==true){
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("A. Proporcionar datos de competición");
			System.out.println("B. Añadir un nuevo equipo");
			System.out.println("C. Eliminar un equipo existente");
			System.out.println("D. Buscar equipos de una localidad");
			System.out.println("E. Listar todos los equipos");
			System.out.println("F. Dar de alta un nuevo jugador en un equipo");
			System.out.println("G. Eliminar un jugador en un equipo");
			System.out.println("H. Cambiar estado/disponibilidada de un jugador de un equipo");
			System.out.println("I. Salir");
			
			resp = sc.nextLine();
			
			switch(resp) {
			case "A":
				if(Liga.getCodComp()!=null) {
					System.out.println("Ya se creó la competición");
					break;
				}
				System.out.println("Introduzca el código de la competición: ");
				atrCodComp = sc.nextLine();
				System.out.println("Introduzca la descripción de la competición: ");
				atrDescComp = sc.nextLine();
				System.out.println("Introduzca la provincia en donde se realizará: ");
				atrProvinciaComp = sc.nextLine();
				
				Liga.setCodComp(atrCodComp);
				Liga.setDescCopm(atrDescComp);
				Liga.setProvinciaComp(atrProvinciaComp);
				
				if(Liga.getCodComp()!=null) {
					System.out.println("Competición creada correctamente");
				}
				else{
					System.out.println("No se pudo crar la competición");
				}
				break;
			case "B":
				if(Liga.getCodComp()==null) {
					System.out.println("Todavía no se ha creado ninguna competición");
					break;
				}
				System.out.println("Introduzca el código del equipo (5 carácteres): ");
				atrCodigo = sc.nextLine();
				if(atrCodigo.length()> 5 || atrCodigo.length()<5) {
					System.out.println("Código de equipo no válido");
				}
				System.out.println("Introduzca descripción del equipo: ");
				atrDescE = sc.nextLine();
				System.out.println("Introduzca nombre del representante: ");
				atrNombreResp = sc.nextLine();
				System.out.println("Introduzca los apellidos del representante: ");
				atrApResp = sc.nextLine();
				System.out.println("Introduzca la ciudad: ");
				atrCiudad = sc.nextLine();
				System.out.println("Introduzca un email para el equipo: ");
				atrEmail = sc.nextLine();
				System.out.println("Introduzca un teléfono para el equipo:");
				atrTfno = sc.nextLine();
				
				atrJugadores = 0;
				
				if(Liga.creaEquipo(atrCodigo, atrDescE, atrNombreResp, atrApResp, atrCiudad, atrEmail, atrTfno, atrJugadores)==true) {
					System.out.println("Equipo creado correctamente");
				}else {
					System.out.println("No se pudo crear el equipo");
				}
				break;
			case "C":
				if(Liga.getCodComp()==null) {
					System.out.println("Todavía no se ha creado ninguna competición");
					break;
				}
				System.out.println("Introduzca el código del equipo que desea eliminar: ");
				atrCodigo = sc.nextLine();
				
				Equipo elEquipo = Liga.buscaEquipo(atrCodigo);
				if(elEquipo.getnJugadores()!=0) {
					System.out.println("No se pudo borrar el equipo");
					break;
				}
				if(Liga.borraEquipo(atrCodigo)==true){
					System.out.println("Equipo borrado correctamente");
				}else {
					System.out.println("No se pudo borrar el equipo");
				}
				break;
			case "D":
				if(Liga.getCodComp()==null) {
					System.out.println("Todavía no se ha creado ninguna competición");
					break;
				}
				System.out.println("Introduzca la localidad:");
				atrCiudad = sc.nextLine();
				
				listaDeEquipos = Liga.listaLosEquipos();
				
				for(Equipo unEquipo : listaDeEquipos) {
					if(unEquipo.getCiudad().equals(atrCiudad)) {
						System.out.println("//Equipo "+ unEquipo.getCodigo()+ "->");
						System.out.println("-- Descripción: "+ unEquipo.getDescripcion());
						System.out.println("-- Representante: "+ unEquipo.getNombreResp()+ " "+ unEquipo.getApResp());
						System.out.println("-- Ciudad: "+ unEquipo.getCiudad());
						System.out.println("-- Email: "+ unEquipo.getEmail());
						System.out.println("-- Teléfono: "+ unEquipo.getTfno());
						System.out.println("-- jugadores: ");
						
						listaDeJugadores = Liga.listalosJugadores();
						
						System.out.println("/Activos. ");
						for(Jugador unJugador : listaDeJugadores) {
							if(unJugador.isEstado()==true && unJugador.getEquipo().equals(unEquipo.getCodigo())) {
								
								System.out.println("- Jugador " + unJugador.getDni()+ ": " + unJugador.getNombre()+ " "+ unJugador.getApellidos());
							}
						}
						System.out.println("/Inactivos. ");
						for(Jugador unJugador : listaDeJugadores) {
							if(unJugador.isEstado()==false && unJugador.getEquipo().equals(unEquipo.getCodigo())) {
								System.out.println("- Jugador " + unJugador.getDni()+ ": " + unJugador.getNombre()+ " "+ unJugador.getApellidos());
							}
							
						}
						
					}
				}
				break;
			case "E":
				if(Liga.getCodComp()==null) {
					System.out.println("Todavía no se ha creado ninguna competición");
					break;
				}
				listaDeEquipos = Liga.listaLosEquipos();
				
				for(Equipo unEquipo : listaDeEquipos) {
					System.out.println("//Equipo "+ unEquipo.getCodigo()+ "->");
					System.out.println("- Descripción: "+ unEquipo.getDescripcion());
					System.out.println("- Representante: "+ unEquipo.getNombreResp()+ " "+ unEquipo.getApResp());
					System.out.println("- Ciudad: "+ unEquipo.getCiudad());
					System.out.println("- Email: "+ unEquipo.getEmail());
					System.out.println("- Teléfono: "+ unEquipo.getTfno());
					System.out.println("- Jugadores: ");
					
					listaDeJugadores = Liga.listalosJugadores();
					
					System.out.println("/Activos. ");
					for(Jugador unJugador : listaDeJugadores) {	
						if(unJugador.isEstado()==true && unJugador.getEquipo().equals(unEquipo.getCodigo())) {
							System.out.println("- Jugador " + unJugador.getDni()+ ": " + unJugador.getNombre()+ " "+ unJugador.getApellidos());
						} 
					}
					System.out.println("/Inactivos. ");
					for(Jugador unJugador : listaDeJugadores) {
						if(unJugador.isEstado()==false && unJugador.getEquipo().equals(unEquipo.getCodigo())){
							
							System.out.println("- Jugador " + unJugador.getDni()+ ": " + unJugador.getNombre()+ " "+ unJugador.getApellidos());
						}
						
					}
					
				}
				break;
			case "F":
				if(Liga.getCodComp()==null) {
					System.out.println("Todavía no se ha creado ninguna competición");
					break;
				}
				System.out.println("Introduzca el código del equipo: ");
				atrCodigo = sc.nextLine();
				if(Liga.buscaEquipo(atrCodigo)!=null) {
					elEquipo = Liga.buscaEquipo(atrCodigo);
					System.out.println("Introduzca el DNI del nuevo jugador: ");
					atrDni = sc.nextLine();
					System.out.println("Introduzca su nombre");
					atrNombre = sc.nextLine();
					System.out.println("Introduzca sus apellidos");
					atrApellidos = sc.nextLine();
					
					atrEquipo = elEquipo.getCodigo();
					atrEstado = false;
					
					Jugador nuevojugador = new Jugador(atrDni, atrNombre, atrApellidos, atrEquipo, atrEstado);
					
					if(Liga.addJugador(nuevojugador)==true) {
						System.out.println("Jugador dado de alta correctamente");
						int sumaJugador = elEquipo.getnJugadores() +1;
						elEquipo.setnJugadores(sumaJugador);
					}else {
						System.out.println("No se pudo dar de alta al jugador");
					}
					break;
				}else {
					System.out.println("El equipo no existe");
				}
				break;
				
			case "G":
				if(Liga.getCodComp()==null) {
					System.out.println("Todavía no se ha creado ninguna competición");
					break;
				}
				System.out.println("Introduzca el DNI del nuevo jugador: ");
				atrDni = sc.nextLine();
				Jugador jBorrado = Liga.buscaJugador(atrDni);
				if(Liga.removeJugador(jBorrado)==true) {
					System.out.println("Jugador borrado correctamente");
				}else {
					System.out.println("No se pudo borrar al jugador");
					break;
				}
					
				break;
			case "H":
				if(Liga.getCodComp()==null) {
					System.out.println("Todavía no se ha creado ninguna competición");
					break;
				}
				System.out.println("Introduzca el DNI del jugador ");
				atrDni = sc.nextLine();
				
				if(Liga.estaJugador(atrDni)) {
					System.out.println("Introduzca el nuevo estado del jugador (Bien, Lesionado, Recuperado)");
					compararEstado = sc.nextLine();
					if(compararEstado.compareTo("Bien")==0 || compararEstado.compareTo("Recuperado")==0) {
						atrEstado = true;
						Liga.cambiarDisponibilida(atrDni, atrEstado);
						System.out.println("Estado del jugador cambiado correctamente");
					}else if(compararEstado.compareTo("Lesionado")==0) {
						atrEstado = false;
						Liga.cambiarDisponibilida(atrDni, atrEstado);
						System.out.println("Estado del jugador cambiado correctamente");
					}
					else {
						System.out.println("No se pudo cambiar el estado del jugador");
					}
				}else {
					System.out.println("El jugador no existe");
				}
				break;
			case "I":
				System.out.println("Adios");
				loop = false;
				
				
			}
			
				
		}

	}
}
