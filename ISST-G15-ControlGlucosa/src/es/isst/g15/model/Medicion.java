package es.isst.g15.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medicion implements Serializable{
	
	private static final long serialVersionUID = 01L;
	
	@Id
	private Date fechaMedicion;
	
	private double nivelGlucosa;
	
	private boolean antesDeComida;
	private String usuario;

	public Medicion(Date fechaMedicion, double nivelGlucosa,
			boolean antesDeComida, String usuario) {
		super();
		this.fechaMedicion = fechaMedicion;
		this.nivelGlucosa = nivelGlucosa;
		this.antesDeComida = antesDeComida;
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFechaMedicion() {
		return fechaMedicion;
	}

	public void setFechaMedicion(Date fechaMedicion) {
		this.fechaMedicion = fechaMedicion;
	}

	public double getNivelGlucosa() {
		return nivelGlucosa;
	}

	public void setNivelGlucosa(double nivelGlucosa) {
		this.nivelGlucosa = nivelGlucosa;
	}

	public boolean isAntesDeComida() {
		return antesDeComida;
	}

	public void setAntesDeComida(boolean antesDeComida) {
		this.antesDeComida = antesDeComida;
	}
	
	

}
