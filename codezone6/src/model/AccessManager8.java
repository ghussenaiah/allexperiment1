package model;

import java.sql.Connection;
import java.util.ArrayList;

 import dao.Access8;
import dao.Database;
import dto.Manager;

public class AccessManager8 {

	
//public ArrayList<Mser> getM(String Month) throws Exception
	public ArrayList<Manager> getA(String Month) throws Exception
//	public ArrayList<Mser> getM() throws Exception
	{
	//	System.out.println("selected month in AccessMAnger" +Month);
		System.out.println("selected month in AccessMAnger" +Month);
	ArrayList<Manager> mservice = new ArrayList<Manager>();
	Database db = new Database();
	Connection con = db.getConnection();
	Access8 access8 = new Access8();
	//mservice = access7.getM(con, Month);
	mservice = access8.getA(con, Month);
	//mservice = access7.getM(con);
	return mservice;
	}
}