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

import com.mini.beans.QueryTo;
import com.mini.daoImpl.SecurityDaoImpl;
import com.mini.delegate.SecurityDelegate;
import com.mini.delegate.SecurityDelegate;
import com.mini.exception.ConnectionException;
import com.mini.exception.LoginException;
import com.mini.beans.SolutionTo;
import com.mini.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * * this class is used to send the queries to admin Payer want to clarify some
 * doubts about the process so he want to send queries to admin by using this
 * class he can send the queries to the admin
 */
public class PostQueryAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		QueryTo rto = new QueryTo();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(rto, map);
		} catch (IllegalAccessException e1) {

			e1.printStackTrace();
		} catch (InvocationTargetException e1) {

			e1.printStackTrace();

		}
		String path = "";
		boolean flag = false;

		try {

			flag = new SecurityDaoImpl().insertQuery(rto);
			if (flag == true) {
				request
						.setAttribute("stat1",
								UtilConstants._POST_QUERY_SUCCESS);
				path = UtilConstants._QUERY_HOME;
			} else {
				request.setAttribute("stat1", UtilConstants._POST_QUERY_FAILED);
				path = UtilConstants._QUERY_HOME;
			}
		} catch (Exception e) {
			request.setAttribute("stat1", e.getMessage());
			path = UtilConstants._QUERY_HOME;
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
