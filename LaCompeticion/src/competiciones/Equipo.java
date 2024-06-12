package competiciones;

import java.util.HashMap;

public class Equipo {
	//Atributos
	String codigo, descripcion, nombreResp, apResp, ciudad, email, tfno;
	int nJugadores;
	
	
	

	//Constructor
	public Equipo(String codigo, String descripcion, String nombreResp, String apResp,
			String ciudad, String email, String tfno, int nJugadores) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nombreResp = nombreResp;
		this.apResp = apResp;
		this.ciudad = ciudad;
		this.email = email;
		this.tfno = tfno;
		this.nJugadores = nJugadores;
		
		
		
	}

	//Métodos getters and setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreResp() {
		return nombreResp;
	}

	public void setNombreResp(String nombreResp) {
		this.nombreResp = nombreResp;
	}

	public String getApResp() {
		return apResp;
	}

	public void setApResp(String apResp) {
		this.apResp = apResp;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTfno() {
		return tfno;
	}

	public void setTfno(String tfno) {
		this.tfno = tfno;
	}

	public int getnJugadores() {
		return nJugadores;
	}

	public void setnJugadores(int nJugadores) {
		this.nJugadores = nJugadores;
	}

	
	
	
}

