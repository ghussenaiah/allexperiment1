package com.mini.delegate;

import com.mini.beans.ChangePasswordTo;
import com.mini.beans.LoginTo;
import com.mini.beans.RegisterTo;
import com.mini.exception.ConnectionException;
import com.mini.exception.LoginException;
import com.mini.serviceI.SecurityServiceI;
import com.mini.serviceImpl.SecurityServiceImpl;

public class SecurityDelegate {

	SecurityServiceI rsi = new SecurityServiceImpl();

	public String loginCheck(RegisterTo lt) throws ConnectionException {

		return rsi.loginCheck(lt);
	}

	public boolean changePassword(ChangePasswordTo cp)
			throws ConnectionException

	{

		return rsi.changePassword(cp);
	}

}
