
package webService;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
 import com.google.gson.Gson;
 import model.AccessManager11;

import dto.Course6;
 
@Path("/upara1")
public class UploadParameter
{
@GET
@Path("/upara2")
@Produces("application/json")
public String courses()
{
String courses = null;
ArrayList<Course6> courseList = new ArrayList<Course6>();
try
{
courseList = new AccessManager11().getCourses();
Gson gson = new Gson();
courses = gson.toJson(courseList);
} catch (Exception e)
{
e.printStackTrace();
}
return courses;
}
}