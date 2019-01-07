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
import com.mini.beans.QueryTo;
import com.mini.daoImpl.SecurityDaoImpl;
import com.mini.delegate.SecurityDelegate;
import com.mini.exception.ConnectionException;
import com.mini.exception.DataNotFoundException;
import com.mini.beans.QueryTo;
import com.mini.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * * this class is for display the query status if the query status is pending
 * that means admin not given any reply to the payer question if he saw the
 * query and send the reply to payer then query status is clear then payer see
 * their responses basing on the above status values payer saw the query
 * response this class for to see the response
 */
public class ViewQuriesAction extends HttpServlet {

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
		Vector<QueryTo> queryInfo = null;

		try {
			queryInfo = new SecurityDaoImpl().getQuery(rto);
		} catch (ConnectionException e) {
			e.getMessage();
			request.setAttribute("status1", e.getMessage());
			e.printStackTrace();
		}

		if (!queryInfo.isEmpty()) {
			request.setAttribute("Queryvector", queryInfo);
			request.setAttribute("status", "Query inf");
			path = UtilConstants._DISPLAY_QUERY;
		} else {
			request.setAttribute("status", "ttttttt");
			path = UtilConstants._DISPLAY_QUERY;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
