package es.isst.g15;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ISST_G15_ControlGlucosaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
	
}
