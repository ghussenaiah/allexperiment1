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

import com.mini.daoImpl.SecurityDaoImpl;
import com.mini.delegate.SecurityDelegate;
import com.mini.exception.ConnectionException;
import com.mini.exception.DataNotFoundException;
import com.mini.beans.SolutionTo;
import com.mini.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.mini.beans.SolutionTo;

/**
 * * this class is for display the query status if the query status is pending
 * that means admin not given any reply to the payer question if he saw the uery
 * and send the reply to payer then query status is clear then payer see their
 * responses
 */
public class ViewQueryStatusAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String login = (String) session.getAttribute("username");
		System.out.println("login name=" + login);

		String req = request.getParameter("req");
		System.out.println("req value " + req);
		SolutionTo rto = new SolutionTo();
		rto.setReq(req);
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(rto, map);
		} catch (IllegalAccessException e1) {

			e1.printStackTrace();
		} catch (InvocationTargetException e1) {

			e1.printStackTrace();
		}
		String path = "";

		try {
			Vector vsb = null;

			vsb = new SecurityDaoImpl().getQueryStatus(login);

			if (!vsb.isEmpty()) {
				request.setAttribute("Statusvector", vsb);
				request.setAttribute("status", UtilConstants._QUERY_STATUS);
				path = UtilConstants._DISPLAY_QUERY_STATUS;

			} else {
				request.setAttribute("status", UtilConstants._NO_SOLUTION);
				path = UtilConstants._DISPLAY_QUERY_STATUS;
			}

		} catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._DISPLAY_QUERY_STATUS;
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
