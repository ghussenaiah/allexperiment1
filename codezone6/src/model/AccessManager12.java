
package model;

import java.sql.Connection;
import java.util.ArrayList;
 
import dao.Access12;
import dao.Database;
import dto.Mser11;
public class AccessManager12 {

	
//public ArrayList<Mser> getM(String Month) throws Exception
	public ArrayList<Mser11> getM(String Username,String PID) throws Exception
//	public ArrayList<Mser> getM() throws Exception
	{
	//	System.out.println("selected month in AccessMAnger" +Month);
		System.out.println("selected month in AccessMAnger" +Username);
	ArrayList<Mser11> mservice = new ArrayList<Mser11>();
	Database db = new Database();
	Connection con = db.getConnection();
	Access12 access7 = new Access12();
	//mservice = access7.getM(con, Month);
	mservice = access7.getM(con, Username,PID);
	//mservice = access7.getM(con);
	return mservice;
	}
}