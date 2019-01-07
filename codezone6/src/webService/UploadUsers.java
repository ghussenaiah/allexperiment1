package webService;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
 


import javax.ws.rs.QueryParam;

import com.google.gson.Gson;

import dto.Course5;
import model.AccessManager10;

 @Path("/user11")
public class UploadUsers
{
@GET
@Path("/user22")
@Produces("application/json")
public String courses(@QueryParam("la") String LastName,@QueryParam("abc1") String table)throws SQLException
//public String courses()
{
String courses = null;
//String table="RevenueDetails";
ArrayList<Course5> courseList = new ArrayList<Course5>();
try
{
courseList = new AccessManager10().getCourses(table);
Gson gson = new Gson();
courses = gson.toJson(courseList);
} catch (Exception e)
{
e.printStackTrace();
}
return courses;
}
}
