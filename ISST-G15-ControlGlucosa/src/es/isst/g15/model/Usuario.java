package es.isst.g15.model;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 01L;
	
	@Id
	private String correo;
	
	private String apellidos;
	private String dni;
	private String nombre;
	private String fechaNacimiento;
	private String grupoSanguineo;
	private String tipoDiabetes;
	private String peso;
	private String telefono;
	private String contraseña;
	private List<String> medidas;
	public String csv;
	
	
	public Usuario(String nombre, String apellidos, String dni, String correo,
			String fechaNacimiento, String grupoSanguineo, String tipoDiabetes,
			String peso, String telefono, String contraseña, List<String> medidas) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.grupoSanguineo = grupoSanguineo;
		this.tipoDiabetes = tipoDiabetes;
		this.peso = peso;
		this.telefono = telefono;
		this.contraseña = contraseña;
		this.medidas = medidas;
		this.csv = null;
		
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


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}


	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}


	public String getTipoDiabetes() {
		return tipoDiabetes;
	}


	public void setTipoDiabetes(String tipoDiabetes) {
		this.tipoDiabetes = tipoDiabetes;
	}


	public String getPeso() {
		return peso;
	}


	public void setPeso(String peso) {
		this.peso = peso;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public List<String> getMedidas() {
		return medidas;
	}


	public void setMedidas(List<String> medidas) {
		this.medidas = medidas;
	}


	public String getCsv() {
		return csv;
	}


	public void setCsv(String csv) {
		this.csv = csv;
	}
	
	

}
