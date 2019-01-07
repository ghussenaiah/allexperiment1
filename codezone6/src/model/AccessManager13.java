package model;

import java.sql.Connection;
import java.util.ArrayList;
 



import dao.Access13;
import dao.Database;
import dto.Course13;

public class AccessManager13
{
public ArrayList<Course13> getCourses(String table) throws Exception
{
ArrayList<Course13> courseList = new ArrayList<Course13>();
Database db = new Database();
Connection con = db.getConnection();
Access13 access = new Access13();
courseList = access.getCourses(con,table);
return courseList;
}
}