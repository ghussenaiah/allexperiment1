package com.jntu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


//@WebServlet("/login")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter(); 
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	try{
	 Class.forName("oracle.jdbc.OracleDriver");
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","don1","root");
     Statement st=(Statement) con.createStatement();
    
             
    
     ResultSet rs=((java.sql.Statement) st).executeQuery("select * from users where username='"+username+"' and password='"+password+"'");
           
    if(rs.next())
    {

	String role=rs.getString("role");
	
	if(role=="admin" && role!=null)
	{
		   RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
	        rd.forward(request, response);  
		
	}
	
	else if(role=="user" && role!=null)
	{

		   RequestDispatcher rd=request.getRequestDispatcher("servlet3");  
	        rd.forward(request, response); 
		
		
	}
	else{
		
	     out.print("Sorry UserName or Password Error!");  
	        RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
	        rd.include(request, response);  
	}
	
	
	}
    
	
	}catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
                     
   }
	}
       
		
	





