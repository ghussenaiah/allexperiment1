package webService;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
 


import javax.ws.rs.QueryParam;

import com.google.gson.Gson;

import dto.Course13;

import model.AccessManager13;

 @Path("/user111")
public class UploadMonth
{
@GET
@Path("/user222")
@Produces("application/json")
public String courses(@QueryParam("la") String LastName,@QueryParam("abc1") String table)throws SQLException{
//public String courses(){

String courses = null;
//String table="SMilestoneDetails";
ArrayList<Course13> courseList = new ArrayList<Course13>();
try
{
courseList = new AccessManager13().getCourses(table);
Gson gson = new Gson();
courses = gson.toJson(courseList);
} catch (Exception e)
{
e.printStackTrace();
}
return courses;
}
}
