package es.isst.g15;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.isst.g15.model.Medicion;

public class ServletMedidaNueva {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		/*if(req.getAttribute("usuario") == null){
			resp.sendRedirect("/logIn");
		}
		else{
			
		}*/
		
		String nivelGlucosa = req.getParameter("nivelGlucosa");
		String fecha = req.getParameter("hora");
		
		List<Medicion> mediciones = new ArrayList<Medicion>();
		
		
		
	}
		
		
}
