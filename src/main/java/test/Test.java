package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome =req.getParameter("username");
		PrintWriter writer=resp.getWriter();
		
		if("Aldo".equalsIgnoreCase(nome)){
			writer.append("Benvenuto al comico");}
			else if("Giovanni".equalsIgnoreCase(nome)){
				writer.append("Benvenuto al comico");
			}
			else if("Giacomo".equalsIgnoreCase(nome)){
				writer.append("Benvenuto al comico");
			}
				
		  
			else if("Francesco".equals(nome)){
//				writer.println("<htlm><body>" +www.google.it+"</html></body>");
			
			}
			
		
			
		writer.flush();
		writer.close();
	}
	}
