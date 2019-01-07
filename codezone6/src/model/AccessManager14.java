
package model;

import java.sql.Connection;
import java.util.ArrayList;
 



import dao.Access14;
import dao.Database;
import dto.Course14;

public class AccessManager14
{
public ArrayList<Course14> getCourses(String table) throws Exception
{
ArrayList<Course14> courseList = new ArrayList<Course14>();
Database db = new Database();
Connection con = db.getConnection();
Access14 access = new Access14();
courseList = access.getCourses(con,table);
return courseList;
}
}