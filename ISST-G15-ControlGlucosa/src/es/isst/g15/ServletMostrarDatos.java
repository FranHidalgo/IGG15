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
import es.isst.g15.model.Usuario;

public class ServletMostrarDatos extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String correo = (String) req.getSession().getAttribute("correo");	
		String password = (String) req.getSession().getAttribute("password");
		
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		Usuario user = dao.getUsuario(correo, password);
		
		List<String> medidas = user.getMedidas();
		List<String> datos = new ArrayList<String>();
		List<String> fechas = new ArrayList<String>();
		
		//req.getSession().setAttribute("medidas", medidas);
		
		for (int i = 0; i<medidas.size(); i++){
			int coma = medidas.get(i).indexOf(",");
			String dato = medidas.get(i).substring(0, coma);
			datos.add(dato);
			String fecha = medidas.get(i).substring(coma+1);
			fechas.add(fecha);
			
		}
		
		req.getSession().setAttribute("datos", datos);
		req.getSession().setAttribute("medidas", medidas);
		req.getSession().setAttribute("fechas", fechas);
//		for (int i =0; i<medidas.size(); i++)
//			resp.getWriter().println(medidas.get(i));
		
		
		resp.sendRedirect("/data.jsp");
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
	}
	
}