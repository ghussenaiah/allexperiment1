package webService;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
 


import com.google.gson.Gson;
 


 

import dto.ProjectName;
import model.AccessManager9;

 
@Path("/proname1")
public class UploadProjectName
{
@GET
@Path("/proname2")
@Produces("application/json")
public String courses()
{
String courses = null;
ArrayList<ProjectName> courseList = new ArrayList<ProjectName>();
try
{
courseList = new AccessManager9().getCourses();
Gson gson = new Gson();
courses = gson.toJson(courseList);
} catch (Exception e)
{
e.printStackTrace();
}
return courses;
}
}