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
import com.mini.daoImpl.UserdaoImpl;
//import com.mini.daoImpl.UserdaoImpl;
import com.mini.exception.ConnectionException;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class WRegisterAction extends HttpServlet {

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
		String out = request.getParameter("out");
		
		String temp = request.getParameter("temp");
		
		String hum = request.getParameter("hum");
	
		String wind = request.getParameter("wind");
		String play = request.getParameter("play");
	
		System.out.println(out+temp+hum+wind+play);
			rto.setOut(out);
			rto.setTmp(temp);
			rto.setHum(hum);
			rto.setWind(wind);
		    rto.setPlay(play);

		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(rto, map);

		} catch (IllegalAccessException e1) {

			e1.printStackTrace();
		} catch (InvocationTargetException e1) {

			e1.printStackTrace();

		}

		try {

			flag = new  UserdaoImpl(). insw( rto);

			if (flag) {

				path = "./AddWeather.jsp";

				request.setAttribute("status200",
						"  weather details inseted successfull");
			} else {

				path = "./AddWeather.jsp";

				request.setAttribute("status200", "Failed");
			}
		} catch (ConnectionException e) {
			request.setAttribute("status200", e.getMessage());
			path = "./AddWeather.jsp";

		}

		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
