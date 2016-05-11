package es.isst.g15.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medico implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	public String correo;
	public String nombre;
	public String apellidos;
	public List<String> pacientes;
	public String password;
	
	
	public Medico(String correo, String nombre, String apellidos,
			List<String> pacientes, String password) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.pacientes = pacientes;
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
	public List<String> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<String> pacientes) {
		this.pacientes = pacientes;
	}
	
	
	
	

}
