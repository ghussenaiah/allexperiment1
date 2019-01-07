
package webService;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
 

import model.AccessManager12;
import dto.Mser11;
 
@Path("/mvpa1")
public class GetParameter {

	
	
	@GET
	@Path("/mvpa2")
	@Produces("application/json")
//	public String ManagerService() throws SQLException{
		public String ManagerService(@QueryParam("la") String LastName,@QueryParam("user1") String Username,@QueryParam("pro11") String PID) throws SQLException{
	
		//String Username="u1";
		// String PID="1";
	
	String mser = null;
	ArrayList<Mser11> mservice = new ArrayList<Mser11>();
	try
	{
		
		
	mservice = new AccessManager12().getM(Username,PID);
	
	Gson gson = new Gson();
	mser = gson.toJson(mservice);
	} catch (Exception e)
	{
	e.printStackTrace();
	}
	return mser;
	}
}