package es.isst.g15;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogOut extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		req.getSession().invalidate();
		//resp.getWriter().println(req.getParameter("nombre"));
		resp.sendRedirect("/index.html");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		req.getSession().invalidate();
		//resp.sendRedirect("/index.html");
	}

}
