package com.mini.actions;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini.beans.RegisterTo;
import com.mini.daoImpl.UserdaoImpl;
import com.mini.exception.ConnectionException;
import com.mini.util.UtilConstants;

public class Mkey extends HttpServlet {
	private int hitCount;

	public void init() {

		hitCount = 0;
	}

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		hitCount++;
		Vector<RegisterTo> role = new Vector<RegisterTo>();
		RegisterTo rto=new RegisterTo();
		String target = "";

		boolean flag=false;
		try {
			
			HttpSession session=request.getSession();
			 
			String username=(String)session.getAttribute("username");
			
			String mkey=request.getParameter("key");
			String val=request.getParameter("s1");
			rto.setMkey(mkey);
			rto.setUsername(username);
			System.out.println("mkey------>"+mkey);
			System.out.println("val------>"+val);
			System.out.println("username------>"+username);
			
			
				flag = new UserdaoImpl().mkey(rto);
			
			System.out.println("in LoginAction Role is.........." + role);

			if (flag) {
				
				
				
				
				if("one".equalsIgnoreCase(val))
				{
					target="SelectTree.jsp";
				}
				else if("two".equalsIgnoreCase(val))
				{
					target="SelectTreeForGroups.jsp";
				}
				else if("three".equalsIgnoreCase(val))
				{
					target="SelectTreev.jsp";
				}
				
				else 
				{
					target="SelectTreep.jsp";
				}
				
			}

			

			
			
			else {
					
				target = "LoginForm.jsp";
			}

		} catch (ConnectionException e) {

			e.getMessage();
			request.setAttribute("status1", e.getMessage());
			target = UtilConstants._LOGIN_FAILED_PAGE;
		} 

		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);

	}

}
