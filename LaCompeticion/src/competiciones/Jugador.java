package competiciones;

public class Jugador {
	String dniJugador, nombre, apellidos, equipo;
	boolean estado;

	public Jugador(String dniJugador, String nombre, String apellidos, String equipo, boolean disponible) {
		this.dniJugador = dniJugador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.equipo = equipo;
		this.estado = false;
	}

	public String getDni() {
		return dniJugador;
	}

	public void setDni(String dniJugador) {
		this.dniJugador = dniJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
	
	
}

