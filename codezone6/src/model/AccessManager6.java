package model;

import java.sql.Connection;
import java.util.ArrayList;
 
import dao.Access6;
import dao.Database;
import dto.Mser;
public class AccessManager6 {

	
//public ArrayList<Mser> getM(String Month) throws Exception
	public ArrayList<Mser> getM(String Username) throws Exception
//	public ArrayList<Mser> getM() throws Exception
	{
	//	System.out.println("selected month in AccessMAnger" +Month);
		System.out.println("selected month in AccessMAnger" +Username);
	ArrayList<Mser> mservice = new ArrayList<Mser>();
	Database db = new Database();
	Connection con = db.getConnection();
	Access6 access7 = new Access6();
	//mservice = access7.getM(con, Month);
	mservice = access7.getM(con, Username);
	//mservice = access7.getM(con);
	return mservice;
	}
}