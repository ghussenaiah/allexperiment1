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
import com.mini.exception.ConnectionException;
import com.mini.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class UpdateUserProfileAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
			vcb = new SecurityDaoImpl().viewUsers(rto);
		} catch (ConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!vcb.isEmpty()) {
			request.setAttribute("vcb", vcb);
			request.setAttribute("status", "USERS INFORMATION");
			
			path = UtilConstants._UPDATEUSER;
		} else {
			request.setAttribute("status", "NO DATA");
	
			path = UtilConstants._UPDATEUSER;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
