package es.isst.g15.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.isst.g15.model.Medicion;
import es.isst.g15.model.Medico;
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
	public void nuevaMedida(Medicion medicion, String correo){
		
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
		List<Usuario> usuarios = q.getResultList();
		if(usuarios.size()!= 0){
			usuario = (Usuario)q.getResultList().get(0);
		}
		
		em.close(); 
		if(usuario != null && usuario.getContraseña().equals(password)){
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
		
		if(q.getResultList().isEmpty()){		
			
			Query t = em.createQuery("select t from Medico t where t.correo=:email");
			t.setParameter("email", email);
			//System.out.println("Comprobando medico");
			Medico medico = null;
			
			if(t.getResultList().isEmpty()){
				//System.out.println("No hay medico");
				em.close();
				return false;
				
			}
			//System.out.println("Si hay medico");
			medico = (Medico)t.getResultList().get(0);
			
			 
			if(medico.getPassword().equals(password)){
				em.close();
				return true;
			}			
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

	@Override
	public void nuevoMedico(String correo, String nombre, String apellidos,
			List<String> pacientes, String password) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Medico nuevoMedico = new Medico(correo,nombre, apellidos, pacientes, password);	
		
		em.persist(nuevoMedico);
		em.close();
		
	}
	
	@Override
	public Medico getMedico(String email, String password){
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from Medico t where t.correo=:email");
		q.setParameter("email", email);
		Medico medico = null;
		//List<Usuario> usuarios = q.getResultList();
		medico = (Medico)q.getResultList().get(0);
		
		em.close(); 
		if(medico.getPassword().equals(password)){
			return medico;
		}
		
		
		else return null;
	}
	
	@Override
	public List<Medico> getAllMedico(){
		EntityManager em = EMFService.get().createEntityManager();

		List<Medico> resultado = em.createQuery("select m from Medico m").getResultList();
		
		em.close();
		return resultado;
	}
	
	@Override
	public Medico getMedico(String email){
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from Medico t where t.correo=:email");
		q.setParameter("email", email);
		Medico medico = null;
		
		medico = (Medico)q.getResultList().get(0);
		
		em.close(); 
		
			return medico;
	
	}
	
	@Override
	public void changeMedico(Medico medico) {
		EntityManager em = EMFService.get().createEntityManager();
		Medico resultado = em.merge(medico);
		em.close();
		

	}
}
