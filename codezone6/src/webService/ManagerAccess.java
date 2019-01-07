package webService;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
 





import dto.Manager;
import model.AccessManager8;

 
@Path("/ma1")
public class ManagerAccess {

	
	
	@GET
	@Path("/ma2")
	@Produces("application/json")
	//public String ManagerService(@QueryParam("la") String LastName,@QueryParam("month1") String Month) throws SQLException{
		public String ManagerService(@QueryParam("la") String LastName,@QueryParam("month1") String Month) throws SQLException{
	//public String ManagerService() throws SQLException{
		
		///String Month="January";
	String mser = null;
	ArrayList<Manager> mservice = new ArrayList<Manager>();
	try
	{
		
		//System.out.println("selected month is Mservice"+Month);
		//System.out.println("selected month is Mservice"+Username);
	//mservice = new AccessManager6().getM(Month);
	mservice = new AccessManager8().getA(Month);
	//mservice = new AccessManager6().getM();
	Gson gson = new Gson();
	mser = gson.toJson(mservice);
	} catch (Exception e)
	{
	e.printStackTrace();
	}
	return mser;
	}
}
