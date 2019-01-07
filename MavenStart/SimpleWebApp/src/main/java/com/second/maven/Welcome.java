package com.second.maven;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Welcome() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String msg="Hello from Servlet";
		request.setAttribute("message", msg);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
}
