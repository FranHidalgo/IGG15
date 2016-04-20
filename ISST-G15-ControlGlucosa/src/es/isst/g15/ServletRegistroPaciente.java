package es.isst.g15;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.isst.g15.dao.ControlGlucosaDAOImpl;
import es.isst.g15.dao.ControlGlucosaDao;
import es.isst.g15.model.Usuario;


public class ServletRegistroPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException, NullPointerException {
		
		/*resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");*/
		
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		String dni = req.getParameter("DNI");
		String correo = req.getParameter("correo");
		String nacimiento = req.getParameter("nacimiento");
		String gsanguineo = req.getParameter("g_sanguineo");
		String tipoDiabetes = req.getParameter("tipo_diabetes");
		String peso = req.getParameter("peso");
		String telefono = req.getParameter("telefono");
		String password = req.getParameter("contraseña");
		
		
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		
		dao.nuevoUsuario(nombre, apellidos, dni, correo, nacimiento, gsanguineo, tipoDiabetes, peso, telefono, password);
		
		resp.sendRedirect("logIn.jsp");
		/*Usuario nuevoUsuario = new Usuario(nombre, apellidos, dni, correo, nacimiento, gsanguineo, tipoDiabetes, peso, telefono, password);
		
		resp.getWriter().println("El nombre es "+ nombre);
		resp.getWriter().println("El apellidos es "+ apellidos);
		resp.getWriter().println("El DNI es "+ dni);
		resp.getWriter().println("El correo es "+ correo);
		resp.getWriter().println("La fecha de nacimiento es "+ nacimiento);
		resp.getWriter().println("El grupo sanguineo es "+ gsanguineo);
		resp.getWriter().println("El tipo de diabetes es "+ tipoDiabetes);
		resp.getWriter().println("El peso es "+ peso);
		resp.getWriter().println("El telefono es "+ telefono);
		resp.getWriter().println("La contraseña es "+ password);
		
		
		resp.getWriter().println("El paciente es "+ nuevoUsuario.getNombre());*/
		
		/*Usuario registrado = dao.getUsuario(correo, password);
		
		resp.getWriter().println("El paciente es "+ registrado.getContraseña());*/
		
		
	}

}
