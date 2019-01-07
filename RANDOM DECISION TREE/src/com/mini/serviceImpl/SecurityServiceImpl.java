package com.mini.serviceImpl;

import java.util.Vector;

import com.mini.beans.ChangePasswordTo;
import com.mini.serviceI.SecurityServiceI;
import com.mini.exception.ConnectionException;
import com.mini.beans.RegisterTo;
import com.mini.daoI.SecurityDaoI;
import com.mini.daoImpl.SecurityDaoImpl;

public class SecurityServiceImpl implements SecurityServiceI {
	boolean flag = false;
	Vector<RegisterTo> vdo = null;

	SecurityDaoI rdao = new SecurityDaoImpl();

	public String loginCheck(RegisterTo lt) throws ConnectionException {

		return rdao.loginCheck(lt);

	}

	public boolean changePassword(ChangePasswordTo cp)
			throws ConnectionException {

		return rdao.changePassword(cp);

	}

}
