package org.dstech.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServeltRequest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		String nome=req.getParameter("nome");
		PrintWriter writer=resp.getWriter();
		if("giovanni".equalsIgnoreCase(nome)){
			writer.append("ciao giovanni");
		}
		else if("antonio".equalsIgnoreCase(nome)){
			writer.append("antonio vattene via");
			
		}else
			writer.append("e tu chi sei?");
		
		writer.flush();
		writer.close();
		// TODO Auto-generated method stub
		
	}

}
