package com.mini.actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.mini.beans.RegisterTo;
import com.mini.daoImpl.SecurityDaoImpl;
import com.mini.delegate.SecurityDelegate;

import com.mini.util.UtilConstants;

/**
 * UpdateUserProfileAction Servlet Class for to update UserProfile This class
 * Helps to update user personal and contact details.
 * 
 */
public class UpdateProfilesAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		boolean flag = false;
		String path = "";
		String username = (String) session.getAttribute("username");
		System.out.println("username is " + username);
		String role = (String) session.getAttribute("role");
		System.out.println("role is " + role);
		RegisterTo pro = new RegisterTo();
		pro.setUsername(username);
		pro.setRole(role);
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(pro, map);

		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			flag = new SecurityDaoImpl().updateUser(pro);
			if (flag) {
				path = "Update.jsp";
				request.setAttribute("status300", UtilConstants._UPDATESUCCESS);
			} else {
				path = "Update.jsp";
				request.setAttribute("status300", UtilConstants._UPDATEFAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			path = UtilConstants._UPDATEUSERRESULT;
			request.setAttribute("status", e.getMessage());
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
