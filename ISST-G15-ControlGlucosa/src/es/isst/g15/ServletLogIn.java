package es.isst.g15;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.isst.g15.dao.ControlGlucosaDAOImpl;
import es.isst.g15.dao.ControlGlucosaDao;

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
		
		
		resp.setContentType("text/plain");
		/*resp.getWriter().println("Hello, world");
		resp.getWriter().println("Usuario "+ correo);
		resp.getWriter().println("Contraseña " + password);*/
		
		if(logInCorrecto){
			//resp.getWriter().println("Usuario correcto");
			resp.sendRedirect("paciente.html");
		}
		else{
			//resp.getWriter().println("El usuario no existe");
			resp.sendRedirect("/logIn.jsp");
		}
		
	
		
		
		
	}

}
