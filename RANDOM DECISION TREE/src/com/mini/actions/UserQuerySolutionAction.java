package com.mini.actions;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mini.beans.SolutionTo;
import com.mini.daoImpl.SecurityDaoImpl;
import com.mini.delegate.SecurityDelegate;
import com.mini.exception.ConnectionException;
import com.mini.exception.DataNotFoundException;

import com.mini.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * * this class for payer see the solutions for sending queries he send the
 * queries to admin regarding his status and other information then admin gives
 * the replies to payer by using this class he saw the queries
 */
public class UserQuerySolutionAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SolutionTo rto = new SolutionTo();

		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(rto, map);
		} catch (IllegalAccessException e1) {

			e1.printStackTrace();
		} catch (InvocationTargetException e1) {

			e1.printStackTrace();
		}
		String path = "";
		Vector<SolutionTo> getsolution = null;

		try {

			int qid = Integer.parseInt(request.getParameter("qid"));
			String login = request.getParameter("from");
			getsolution = new SecurityDaoImpl().getUserQSolution(qid, login);

			if (!getsolution.isEmpty()) {
				request.setAttribute("Solutionvector", getsolution);
				request.setAttribute("status",
						UtilConstants._POST_SOLUTION_INFO);
				path = UtilConstants._VIEW_SOLUTION;
			} else {
				request.setAttribute("status", UtilConstants._NO_SOLUTION);
				path = UtilConstants._VIEW_SOLUTION;
			}
		} catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());

			path = "./Homematter.jsp";
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
