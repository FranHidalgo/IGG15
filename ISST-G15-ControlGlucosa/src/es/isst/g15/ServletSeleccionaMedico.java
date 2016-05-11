package es.isst.g15;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.isst.g15.dao.ControlGlucosaDAOImpl;
import es.isst.g15.dao.ControlGlucosaDao;
import es.isst.g15.model.Medico;

public class ServletSeleccionaMedico<Medico> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String medico = req.getParameter("medico");	
		/*resp.setContentType("text/plain");
		resp.getWriter().println("El paciente "+ req.getSession().getAttribute("usuario")+ " ha elegido al médico " + medico );*/
		
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
	
			
		es.isst.g15.model.Medico doctor = dao.getMedico(medico);
		
		String usuario = (String) req.getSession().getAttribute("usuario");
		doctor.pacientes.add(usuario);
		dao.changeMedico(doctor);

		//resp.getWriter().println("El doctor tiene al paciente " +doctor.getPacientes());
		resp.sendRedirect("/paciente.html");
		
		
	}

}
