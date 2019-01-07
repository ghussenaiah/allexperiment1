package model;
import java.sql.Connection;
import java.util.ArrayList;
 



import dao.Access15;
import dao.Database;
import dto.Course15;

public class AccessManager15
{
public ArrayList<Course15> getCourses() throws Exception
{
ArrayList<Course15> courseList = new ArrayList<Course15>();
Database db = new Database();
Connection con = db.getConnection();
Access15 access = new Access15();
courseList = access.getCourses(con);
return courseList;
}
}