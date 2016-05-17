package es.isst.g15.dao;

import java.util.List;

import es.isst.g15.model.Medico;
import es.isst.g15.model.Usuario;


public interface ControlGlucosaDao {
	
	public void nuevaMedida(List<String> medicion, Usuario user);
	
	
	public void nuevoUsuario(String nombre, String apellidos, String dni, String correo,
			String fechaNacimiento, String grupoSanguineo, String tipoDiabetes,
			String peso, String telefono, String password);
	
	public void uploadCsv(String correo, String password, String csv);
	
	public Usuario getUsuario(String email, String password);
	
	public boolean correctLogIn(String email, String password);
	
	public void nuevoMedico(String correo, String nombre, String apellidos, List<String> pacientes, String password);

	public Medico getMedico(String email, String password);

	public List<Medico> getAllMedico();

	public Medico getMedico(String email);

	public void changeMedico(Medico medico);
	
	public Usuario getPaciente(String email);

}
