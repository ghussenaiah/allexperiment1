package webService;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
 




import model.AccessManager7;
import dto.Member7;

 
@Path("/rv1")
public class RetriveParameter {

	
	
	@GET
	@Path("/rv2")
	@Produces("application/json")
	
		public String ManagerService(@QueryParam("la") String LastName,@QueryParam("user2") String Username,@QueryParam("pid2") String PID,@QueryParam("month2") String Month) throws SQLException{
//public String ManagerService() throws SQLException{
		
		//String Username="pm";
		//String PID="1";
		//String Month="January";
	String mser = null;
	ArrayList<Member7> mservice = new ArrayList<Member7>();
	try
	{
		
		
		//System.out.println("selected username"+Username);
		//System.out.println("selected pid"+PID);
	//String Username="u5";
	//String PID="2";
	mservice = new AccessManager7().getM(Username,PID,Month);
	//	mservice = new AccessManager7().getM();
	Gson gson = new Gson();
	mser = gson.toJson(mservice);
	} catch (Exception e)
	{
	e.printStackTrace();
	}
	return mser;
	}
}