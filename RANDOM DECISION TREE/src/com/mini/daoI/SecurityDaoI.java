package com.mini.daoI;

import com.mini.beans.RegisterTo;
import com.mini.exception.ConnectionException;
import com.mini.beans.ChangePasswordTo;

public interface SecurityDaoI {

	public String loginCheck(RegisterTo lt) throws ConnectionException;

	public boolean changePassword(ChangePasswordTo cp)
			throws ConnectionException;

}
