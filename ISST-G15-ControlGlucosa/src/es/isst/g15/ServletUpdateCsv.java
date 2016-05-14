package es.isst.g15;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import es.isst.g15.dao.ControlGlucosaDAOImpl;
import es.isst.g15.dao.ControlGlucosaDao;
import es.isst.g15.model.Medico;
import es.isst.g15.model.Usuario;

public class ServletUpdateCsv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException, NullPointerException {
		
		String correo = (String) req.getSession().getAttribute("correo");	
		String password = (String) req.getSession().getAttribute("password");
		
		ControlGlucosaDao dao = ControlGlucosaDAOImpl.getInstance();		
		 
		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        List<BlobKey> blobKeys = blobs.get("file");
   
        dao.uploadCsv(correo, password, blobKeys.get(0).getKeyString()); 
        
        if (blobKeys == null || blobKeys.isEmpty()) {
            resp.sendRedirect("/");
        } else {

        	resp.sendRedirect("/enterData.jsp");
        }
	}

}
		