package es.isst.g15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.isst.g15.dao.ControlGlucosaDAOImpl;
import es.isst.g15.dao.ControlGlucosaDao;
import es.isst.g15.model.Medico;
import es.isst.g15.model.Usuario;

public class ServletLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String correo = req.getParameter("correo");		
		String password = req.getParameter("password");
		
		
		
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		Boolean logInCorrecto = dao.correctLogIn(correo, password);
		
		req.getSession().setAttribute("correo", correo);
		req.getSession().setAttribute("password", password);
		
		if(logInCorrecto){
			Usuario usuario = dao.getUsuario(correo, password);
			if (usuario != null){
				req.getSession().setAttribute("usuario", correo);
				req.getSession().setAttribute("nombre", usuario.getNombre());
				req.getSession().setAttribute("apellidos", usuario.getApellidos());
				req.getSession().setAttribute("dni", usuario.getDni());
				req.getSession().setAttribute("nacimiento", usuario.getFechaNacimiento());
				req.getSession().setAttribute("gsanguineo", usuario.getGrupoSanguineo());
				req.getSession().setAttribute("tipoDiabetes", usuario.getTipoDiabetes());
				req.getSession().setAttribute("peso", usuario.getPeso());
				req.getSession().setAttribute("telefono", usuario.getTelefono());
				List<Medico> medicos = dao.getAllMedico();
				
				req.getSession().setAttribute("medicos", new ArrayList<Medico>(medicos));
				resp.sendRedirect("paciente.html");
			
			}else{
				
				Medico medico = dao.getMedico(correo, password);
				if (medico != null){
					req.getSession().setAttribute("medico", correo);
					req.getSession().setAttribute("nombre", medico.getNombre());
					req.getSession().setAttribute("apellidos", medico.getApellidos());
					List<String> pacientes = medico.getPacientes();
					req.getSession().setAttribute("pacientes", new ArrayList<String>(pacientes));
					resp.sendRedirect("medico.html");
				}
				
			}
		}
		else{
			resp.setContentType("text/plain");
			resp.getWriter().println("Error");
		}
	}
}
