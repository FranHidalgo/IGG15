package es.isst.g15.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.isst.g15.model.Medicion;
import es.isst.g15.model.Usuario;



public class ControlGlucosaDAOImpl implements ControlGlucosaDao{
	
	private static ControlGlucosaDAOImpl instance;
	private ControlGlucosaDAOImpl(){
	}
	
	public static ControlGlucosaDAOImpl getInstance(){
		if(instance==null){
			instance = new ControlGlucosaDAOImpl();
		}
		return instance;
	}
	
	@Override
	public void nuevaMedida(Medicion medicion){
		
		EntityManager em = EMFService.get().createEntityManager();
		
		em.persist(medicion);
		
	}
	
	@Override
	public void sacarResultados(){
		//Hay que implementar este método
	}
	
	@Override
	public void nuevoUsuario(String nombre, String apellidos, String dni, String correo,
			String fechaNacimiento, String grupoSanguineo, String tipoDiabetes,
			String peso, String telefono, String password){
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Usuario nuevoUsuario = new Usuario(nombre, apellidos, dni, correo,fechaNacimiento, grupoSanguineo, tipoDiabetes, peso, telefono, password);	
		
		em.persist(nuevoUsuario);
		em.close();
		
	}
	
	@Override
	public Usuario getUsuario(String email, String password){
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from Usuario t where t.correo=:email");
		q.setParameter("email", email);
		Usuario usuario = null;
		//List<Usuario> usuarios = q.getResultList();
		usuario = (Usuario)q.getResultList().get(0);
		
		em.close(); 
		if(usuario.getContraseña().equals(password)){
			return usuario;
		}
		
		
		else return null;
	}
	
	@Override
	public boolean correctLogIn(String email, String password){
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from Usuario t where t.correo=:email");
		q.setParameter("email", email);
		Usuario usuario = null;
		//List<Usuario> usuarios = q.getResultList();
		if(q.getResultList().isEmpty()){
			em.close();
			return false;
			
		}
		usuario = (Usuario)q.getResultList().get(0);
		 
		if(usuario.getContraseña().equals(password)){
			em.close();
			return true;
		}
		em.close();
		return false;
	}

}
