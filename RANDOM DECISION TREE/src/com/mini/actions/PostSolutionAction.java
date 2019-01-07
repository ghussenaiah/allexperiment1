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

import com.mini.beans.SolutionTo;
import com.mini.daoImpl.SecurityDaoImpl;
import com.mini.delegate.SecurityDelegate;
import com.mini.exception.ConnectionException;
import com.mini.exception.LoginException;

import com.mini.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * * After getting the queries from payer admin saw the queries and understand
 * the problems and doubts of the payer regarding the process after he saw the
 * query basing on the queries he have give the replies to the user
 */
public class PostSolutionAction extends HttpServlet {

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
		boolean flag = false;
		HttpSession s = request.getSession();
		String login = (String) s.getAttribute("username");

		System.out.println(" username from session is " + login);
		rto.setUname(login);

		System.out.println("&&&&&&&&& qid from previous" + rto.getQid());

		try {

			flag = new SecurityDaoImpl().insertSolution(rto);
			if (flag == true) {
				request.setAttribute("status",
						UtilConstants._POST_SOLUTION_SUCCESS);
				path = UtilConstants._SOLUTION_HOME;
			} else {
				request.setAttribute("status",
						UtilConstants._POST_SOLUTION_FAILED);
				path = UtilConstants._SOLUTION_HOME;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._SOLUTION_HOME;
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
