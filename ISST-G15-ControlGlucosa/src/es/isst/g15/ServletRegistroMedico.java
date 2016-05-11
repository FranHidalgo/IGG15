package es.isst.g15;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.isst.g15.dao.ControlGlucosaDAOImpl;
import es.isst.g15.dao.ControlGlucosaDao;

public class ServletRegistroMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException, NullPointerException {
		
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		String correo = req.getParameter("correo");
		String password = req.getParameter("contraseña");
		
		
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		
		dao.nuevoMedico(correo, nombre, apellidos, null, password);
		
		resp.sendRedirect("logIn.jsp");
		
	}
	
}
