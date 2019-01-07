package webService;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
 


import javax.ws.rs.QueryParam;

import com.google.gson.Gson;

import dto.Course14;
import model.AccessManager14;

 @Path("/user211")
public class UploadProjectName1
{
@GET
@Path("/user322")
@Produces("application/json")
public String courses(@QueryParam("la") String LastName,@QueryParam("abc1") String table)throws SQLException
//public String courses()
{
String courses = null;
//String table="SMilestoneDetails";

//String table="SRevenueDetails";
ArrayList<Course14> courseList = new ArrayList<Course14>();
try
{
courseList = new AccessManager14().getCourses(table);
Gson gson = new Gson();
courses = gson.toJson(courseList);
} catch (Exception e)
{
e.printStackTrace();
}
return courses;
}
}
