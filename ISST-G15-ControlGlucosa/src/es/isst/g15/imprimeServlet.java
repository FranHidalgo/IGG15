package es.isst.g15;




import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class imprimeServlet extends HttpServlet {
	
	
	
	 public void doGet(HttpServletRequest request,
	   HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("application/pdf");	
		   
		
	      Document my_pdf_data = new Document();
	      try {
			
	    	  PdfWriter.getInstance( my_pdf_data,response.getOutputStream());
	    	
	      if(request.getSession().getAttribute("paciente") == null){
	    	  my_pdf_data.open();     
		      my_pdf_data.add(new Paragraph("Estas son las medidas del paciente: "+ request.getSession().getAttribute("nombre") + " "+ request.getSession().getAttribute("apellidos") ));
		      my_pdf_data.add(new Paragraph(" "));
		      my_pdf_data.add(new Paragraph(" "));
	      }
	      else{
	    	  my_pdf_data.open();  
	    	  my_pdf_data.add(new Paragraph("Estas son las medidas del paciente: "+ request.getSession().getAttribute("paciente")));
		      my_pdf_data.add(new Paragraph(" "));
		      my_pdf_data.add(new Paragraph(" "));
	      }
	     

	  
	  	
	      PdfPTable my_first_table = new PdfPTable(3);
	      PdfPCell table_cell;
	       
	      ArrayList<String> fechas = (ArrayList<String>) request.getSession().getAttribute("fechas");
	      ArrayList<String> horas = (ArrayList<String>) request.getSession().getAttribute("horas");
	      ArrayList<String> datos = (ArrayList<String>) request.getSession().getAttribute("datos");
	      table_cell=new PdfPCell(new Phrase("Fecha"));
          my_first_table.addCell(table_cell);
          table_cell=new PdfPCell(new Phrase("Hora"));
          my_first_table.addCell(table_cell);
          table_cell=new PdfPCell(new Phrase("Dato"));
          my_first_table.addCell(table_cell);
	      for(int i = 0; i<fechas.size() ;i++){
	    	  String fecha = fechas.get(i);
	    	  String hora = horas.get(i);
	    	  String dato = datos.get(i);
	    	  table_cell=new PdfPCell(new Phrase(fecha));
              my_first_table.addCell(table_cell);
              table_cell=new PdfPCell(new Phrase(hora));
              my_first_table.addCell(table_cell);
              table_cell=new PdfPCell(new Phrase(dato));
              my_first_table.addCell(table_cell);
	    	  
	      }
	      
	      
	      my_pdf_data.add(my_first_table);                       
	      my_pdf_data.close(); 
	      
		 } catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		  
		 }

		
		 }
	  
	 
	 }