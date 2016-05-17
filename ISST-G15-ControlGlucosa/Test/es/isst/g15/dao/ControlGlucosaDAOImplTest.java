package es.isst.g15.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import es.isst.g15.model.Medico;
import es.isst.g15.model.Usuario;





public class ControlGlucosaDAOImplTest {
	
	private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	

	@Before
	public void setUp() throws Exception {
		helper.setUp();
	}

	@After
	public void tearDown() throws Exception {
		helper.tearDown();
	}

	@Test
	public void testNuevaMedida() {
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		
		dao.nuevoUsuario("a", "a", "55555555M", "a@a.com", null, null, null, null, "a" , "a");
		Usuario usuario = dao.getUsuario("a@a.com", "a");
		List<String> medidas = new ArrayList<String>();
		medidas.add("50, 2015/10/10");
		dao.nuevaMedida(medidas, usuario);
		assertEquals(dao.getUsuario("a@a.com", "a").getMedidas().get(0), "50, 2015/10/10" );
		
	}


	@Test
	public void testNuevoUsuario() {
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		
		dao.nuevoUsuario("a", "a", "55555555M", "a@a.com", null, null, null, null, "a" , "a");
		assertEquals(dao.getUsuario("a@a.com", "a").getCorreo(), "a@a.com" );
	}

	@Test
	public void testUploadCsv() {
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		
		dao.nuevoUsuario("a", "a", "55555555M", "a@a.com", null, null, null, null, "a" , "a");
		Usuario usuario = dao.getUsuario("a@a.com", "a");
		List<String> medidas = new ArrayList<String>();
		medidas.add("50, 2015/10/10");
		dao.nuevaMedida(medidas, usuario);
		assertEquals(dao.getUsuario("a@a.com", "a").getMedidas().get(0), "50, 2015/10/10" );
	}

	@Test
	public void testGetUsuario() {
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		
		dao.nuevoUsuario("a", "a", "55555555M", "a@a.com", null, null, null, null, "a" , "a");
		assertEquals(dao.getUsuario("a@a.com", "a").getCorreo(), "a@a.com" );
	}

	@Test
	public void testCorrectLogIn() {
		
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		List<String> pacientes = new ArrayList<String>();
		dao.nuevoUsuario("a", "a", "55555555M", "a@a.com", null, null, null, null, "a" , "a");
		dao.nuevoMedico("medico1@medico1.com", "medico1", "medico1", pacientes , "medico1");
		
		assertEquals(dao.correctLogIn("a@a.com", "a"), true);
		assertEquals(dao.correctLogIn("medico1@medico1.com", "medico1"), true);
		
		
	}

	@Test
	public void testNuevoMedico() {
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		dao.nuevoMedico("medico1@medico1.com", "medico1", "medico1", null, "medico1");
		Medico medico = dao.getMedico("medico1@medico1.com", "medico1");
		assertEquals(medico.correo, "medico1@medico1.com");
	}

	@Test
	public void testGetMedicoStringString() {
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		dao.nuevoMedico("medico1@medico1.com", "medico1", "medico1", null, "medico1");
		Medico medico = dao.getMedico("medico1@medico1.com", "medico1");
		assertEquals(medico.correo, "medico1@medico1.com");
	}

	@Test
	public void testGetAllMedico() {
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		dao.nuevoMedico("medico1@medico1.com", "medico1", "medico1", null, "medico1");
		List<Medico> medicos = dao.getAllMedico();
		assertEquals(medicos.size(), 1);
		
	}

	@Test
	public void testGetMedicoString() {
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		dao.nuevoMedico("medico1@medico1.com", "medico1", "medico1", null, "medico1");
		Medico medico = dao.getMedico("medico1@medico1.com");
		assertEquals(medico.correo, "medico1@medico1.com");
	}

	@Test
	public void testChangeMedico() {
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		dao.nuevoMedico("medico1@medico1.com", "medico1", "medico1", null, "medico1");
		Medico medico = dao.getMedico("medico1@medico1.com");
		assertEquals(medico.correo, "medico1@medico1.com");
	}

	@Test
	public void testGetPaciente() {
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		List<String> pacientes = new ArrayList<String>();
		dao.nuevoUsuario("a", "a", "55555555M", "a@a.com", null, null, null, null, "a" , "a");
		Usuario usuario = dao.getUsuario("a@a.com", "a");
		pacientes.add(usuario.getCorreo());
		dao.nuevoMedico("medico1@medico1.com", "medico1", "medico1", pacientes , "medico1");
		Medico medico = dao.getMedico("medico1@medico1.com", "medico1");
		assertEquals(medico.getPacientes().get(0), "a@a.com");
	}

}
