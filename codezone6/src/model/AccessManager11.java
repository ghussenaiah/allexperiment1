

package model;

import java.sql.Connection;
import java.util.ArrayList;
 
import dao.Access11;
import dao.Database;

import dto.Course6;
 
public class AccessManager11
{
public ArrayList<Course6> getCourses() throws Exception
{
ArrayList<Course6> courseList = new ArrayList<Course6>();
Database db = new Database();
Connection con = db.getConnection();
Access11 access = new Access11();
courseList = access.getCourses(con);
return courseList;
}
}
