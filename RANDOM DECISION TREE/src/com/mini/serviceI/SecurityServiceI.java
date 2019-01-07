package com.mini.serviceI;

import com.mini.beans.ChangePasswordTo;
import com.mini.beans.LoginTo;
import com.mini.beans.RegisterTo;
import com.mini.exception.ConnectionException;

public interface SecurityServiceI {

	public String loginCheck(RegisterTo lt) throws ConnectionException;

	public boolean changePassword(ChangePasswordTo cp)
			throws ConnectionException;

}
