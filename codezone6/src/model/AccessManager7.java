package model;

import java.sql.Connection;
import java.util.ArrayList;
 


import dao.Access7;
import dao.Database;
import dto.Member7;

public class AccessManager7 {

	

	public ArrayList<Member7> getM(String Username,String PID,String Month) throws Exception
//	public ArrayList<Member7> getM() throws Exception
	{
	//	System.out.println("selected month in AccessMAnger" +Month);
	//	System.out.println("selected month in AccessMAnger" +Username);
	ArrayList<Member7> mservice = new ArrayList<Member7>();
	Database db = new Database();
	Connection con = db.getConnection();
	Access7 access7 = new Access7();
	
	mservice = access7.getM(con, Username,PID,Month);
	//mservice = access7.getM(con);
	return mservice;
	}
}