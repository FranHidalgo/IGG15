package es.isst.g15;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.isst.g15.dao.ControlGlucosaDAOImpl;
import es.isst.g15.dao.ControlGlucosaDao;
import es.isst.g15.model.Usuario;

public class ServletMedidaNueva extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String correo = (String) req.getSession().getAttribute("correo");	
		String password = (String) req.getSession().getAttribute("password");
		String valor = req.getParameter("valor");
		String fecha = req.getParameter("fechaMedicion");
		
		String medida = valor + ", " + fecha;
		
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();
		Usuario user = dao.getUsuario(correo, password);
		
		List<String> medidas = user.getMedidas();
		
		medidas.add(medida);
		
		dao.nuevaMedida(medidas, user);
		
		resp.sendRedirect("enterData.jsp");
	}
		
		
}
