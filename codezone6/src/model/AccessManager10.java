
package model;

import java.sql.Connection;
import java.util.ArrayList;
 



import dao.Access10;
import dao.Database;
import dto.Course5;

public class AccessManager10
{
public ArrayList<Course5> getCourses(String table) throws Exception
{
ArrayList<Course5> courseList = new ArrayList<Course5>();
Database db = new Database();
Connection con = db.getConnection();
Access10 access = new Access10();
courseList = access.getCourses(con,table);
return courseList;
}
}