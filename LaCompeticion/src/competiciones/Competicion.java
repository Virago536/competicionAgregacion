package competiciones;

import java.util.ArrayList;
import java.util.HashMap;


public class Competicion {
	//Atributos
	String codComp, descComp, provinciaComp;
	
	ArrayList<Equipo> listaEquipos;
	HashMap<String,Jugador> mapaJugadores;
	
	
	
	//Constructor
	public Competicion(String codComp, String descComp, String provinciaComp) {
		super();
		this.codComp = codComp;
		this.descComp = descComp;
		this.provinciaComp = provinciaComp;
		
		listaEquipos = new ArrayList<>();
		mapaJugadores = new HashMap<>();
		
	}

	//Métodos getters and setters
	public String getCodComp() {
		return codComp;
	}


	public void setCodComp(String codComp) {
		this.codComp = codComp;
	}


	public String getDescCopm() {
		return descComp;
	}


	public void setDescCopm(String descCopm) {
		this.descComp = descCopm;
	}


	public String getProvinciaComp() {
		return provinciaComp;
	}


	public void setProvinciaComp(String provinciaComp) {
		this.provinciaComp = provinciaComp;
	}
	
	//CRUD equipos
	
	public boolean creaEquipo(String codigo, String descripcion, String nombreResp, String apResp, String ciudad, String email, String tfno, int nJugadores) {
		Equipo equipoCreado = new Equipo(codigo, descripcion, nombreResp, apResp, ciudad, email, tfno, nJugadores);
		if(!estaEquipo(codigo)) {
			listaEquipos.add(equipoCreado);
			return true;
		}
		return false;
	}
	
	public boolean borraEquipo(String codigo) {
		Equipo equipoBorrado = buscaEquipo(codigo);
		if(estaEquipo(codigo)) {
			listaEquipos.remove(equipoBorrado);
			return true;
		}
		
		return false;
	}
	
	
	public boolean estaEquipo(String codigo) {
		return (buscaEquipo(codigo)!=null);
	}
	
	
	public Equipo buscaEquipo(String codigo) {
		for(Equipo e : listaEquipos) {
			if(e.getCodigo().equals(codigo)) {
				return e;
			}
			
		}
		return null;
	}
	
	public Equipo[] listaLosEquipos() {
		ArrayList<Equipo> nuevaListaEquipos = new ArrayList<>();
		
		for(int i = 0; i<listaEquipos.size(); i++) {
				nuevaListaEquipos.add(listaEquipos.get(i));
		}
		return nuevaListaEquipos.toArray(new Equipo[0]);
	}
	
	
	//CRUD jugadores

		public boolean addJugador(Jugador j) {
			if(j != null && !mapaJugadores.containsValue(j)) {
				mapaJugadores.put(j.getDni(), j);
				return true;
			}
			else return false;
		}


		public boolean removeJugador(Jugador j) {
			if(j != null && mapaJugadores.containsValue(j)) {
				mapaJugadores.remove(j.getDni(), j);
				return true;
			}
			return false;
		}

		public boolean estaJugador(String dniJugador) {
			if(mapaJugadores.get(dniJugador) != null) {
				return true;
			}
			else return false;
		}
		
		

		public Jugador buscaJugador(String dni) {
			if(dni!= null) {
				return mapaJugadores.get(dni); 
			}
			else return null;
		}
		
		public Jugador[] listalosJugadores() {
			return mapaJugadores.values().toArray(new Jugador[0]);
		}
		
		public boolean cambiarDisponibilida(String dniJugador, boolean disponible) {
			Jugador jCambiado = buscaJugador(dniJugador);
			
			if(jCambiado!=null && mapaJugadores.containsKey(dniJugador)) {
				jCambiado.setEstado(disponible);
				return true;
			}
			return false;
		}
	
		
		

}

