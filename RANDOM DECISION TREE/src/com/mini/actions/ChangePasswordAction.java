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

import com.mini.beans.ChangePasswordTo;
import com.mini.delegate.SecurityDelegate;
import com.mini.beans.RegisterTo;
import com.mini.delegate.SecurityDelegate;
import com.mini.exception.ConnectionException;
import com.mini.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ChangePasswordAction extends HttpServlet {

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

		ChangePasswordTo cp = new ChangePasswordTo();

		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(cp, map);

		} catch (IllegalAccessException e1) {

			e1.printStackTrace();
		} catch (InvocationTargetException e1) {

			e1.printStackTrace();

		}

		try {

			flag = new SecurityDelegate().changePassword(cp);

			if (flag) {

				session.setAttribute("status1", "PASSWORD CHANGE SUCCESSFULLY");
				String s1 = (String) session.getAttribute("role");

				path = "./ChangePasswordForm.jsp";

			} else {

				path = "./ChangePasswordForm.jsp";

				request.setAttribute("status1", "ChangePassword is Failed");
			}
		} catch (ConnectionException e) {
			request.setAttribute("status1", e.getMessage());
			path = "./Changepassword.jsp";

		} finally {
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);

		}
	}

}
