package webService;

//import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
 


//import javax.ws.rs.QueryParam;

import com.google.gson.Gson;

import dto.Course15;
import model.AccessManager15;

 @Path("/user33")
public class UploadUsers1
{
@GET
@Path("/user44")
@Produces("application/json")
//public String courses(@QueryParam("la") String LastName,@QueryParam("abc1") String table)throws SQLException
public String courses()
{
String courses = null;
//String table="RevenueDetails";
ArrayList<Course15> courseList = new ArrayList<Course15>();
try
{
courseList = new AccessManager15().getCourses();
Gson gson = new Gson();
courses = gson.toJson(courseList);
} catch (Exception e)
{
e.printStackTrace();
}
return courses;
}
}
