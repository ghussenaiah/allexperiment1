package com.mini.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini.beans.RegisterTo;
import com.mini.daoImpl.SecurityDaoImpl;
import com.mini.exception.ConnectionException;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class RegisterAction extends HttpServlet {

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

		RegisterTo rto = new RegisterTo();
		
		
		String username = request.getParameter("username");
	
		String pass = request.getParameter("password");
		System.out.println("username=" + username);
		System.out.println("password=" + pass);
		String sq = request.getParameter("sq");
		String sa = request.getParameter("sa");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		int dob= Integer.parseInt(request.getParameter("dob"));
		String type = request.getParameter("type");
		String mkey = request.getParameter("mkey");
		System.out.println(sq+sa+firstname+lastname+gender+dob+type+mkey);
		rto.setUsername(username);
		rto.setPassword(pass);
	    rto.setSq(sq);
		rto.setSa(sa);
		rto.setFirstname(firstname);
		rto.setLastname(lastname);
		rto.setGender(gender);
		rto.setDob(dob);
		rto.setType(type);
		rto.setMkey(mkey);
		
		
	
		
		
		
		
		
		
		
		

		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(rto, map);

		} catch (IllegalAccessException e1) {

			e1.printStackTrace();
		} catch (InvocationTargetException e1) {

			e1.printStackTrace();

		}

		try {

			flag = new SecurityDaoImpl().insertNewUser(rto);

			if (flag) {

				path = "./LoginForm.jsp";

				request.setAttribute("status200",
						"  Registeration is successfull");
			} else {

				path = "./LoginForm.jsp";

				request.setAttribute("status200", "Registeration is Failed");
			}
		} catch (ConnectionException e) {
			request.setAttribute("status200", e.getMessage());
			path = "./LoginForm.jsp";

		}

		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
