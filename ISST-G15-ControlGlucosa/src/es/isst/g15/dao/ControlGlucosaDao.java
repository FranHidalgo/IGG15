package es.isst.g15.dao;

import es.isst.g15.model.Medicion;
import es.isst.g15.model.Usuario;


public interface ControlGlucosaDao {
	
	public void nuevaMedida(Medicion medicion, String correo);
	
	public void sacarResultados();
	
	public void nuevoUsuario(String nombre, String apellidos, String dni, String correo,
			String fechaNacimiento, String grupoSanguineo, String tipoDiabetes,
			String peso, String telefono, String password);
	
	public Usuario getUsuario(String email, String password);
	
	public boolean correctLogIn(String email, String password);

}
