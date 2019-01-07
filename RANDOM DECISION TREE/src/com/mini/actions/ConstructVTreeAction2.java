package com.mini.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini.beans.RegisterTo;
import com.mini.daoImpl.SecurityDaoImpl;
import com.mini.daoImpl.UserdaoImpl;
import com.mini.exception.ConnectionException;
import com.mini.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ConstructVTreeAction2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 long startTime = System.currentTimeMillis();
		
		 System.out.println("------------- " +startTime);
		
		
		

		HttpSession session = request.getSession();
		RequestDispatcher rd = null;

		boolean flag = false;
		String path = "";
		String username = (String) session.getAttribute("username");
		System.out.println("username is " + username);
		String role = (String) session.getAttribute("role");
		System.out.println("role is " + role);
		RegisterTo rto = new RegisterTo();
		rto.setRole(role);
		rto.setUsername(username);
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(rto, map);

		} catch (IllegalAccessException e1) {

			e1.printStackTrace();
		} catch (InvocationTargetException e1) {

			e1.printStackTrace();

		}
		
		
		

		Vector vcb = null;
		try {
			vcb = new UserdaoImpl().viewSelectedVData1(rto);
			
			
			
			 long stopTime = System.currentTimeMillis();
			 System.out.println("------------- " +stopTime);
			 long dur = stopTime - startTime;
		      System.out.println(dur);
		
		
		

		if (!vcb.isEmpty()) {
			request.setAttribute("dur", dur);
			
			request.setAttribute("vcb", vcb);
			request.setAttribute("status", " Selected Criteria and Vertical Group Results are ");
			path = "./SelectedVTreeDetails1.jsp";
		} else {
			request.setAttribute("status",
					"Fail");
			path = "./SelectedVTreeDetails1.jsp";
		}
		
		
		
			
			
		
			
		
		
	
		 
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

		}catch (Exception e) {
			
		}
	}
}
