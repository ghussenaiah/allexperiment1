package model;

import java.sql.Connection;
import java.util.ArrayList;
 



import dao.Access9;
import dao.Database;
import dto.ProjectName;
 
public class AccessManager9
{
public ArrayList<ProjectName> getCourses() throws Exception
{
ArrayList<ProjectName> courseList = new ArrayList<ProjectName>();
Database db = new Database();
Connection con = db.getConnection();
Access9 access = new Access9();
courseList = access.getCourses(con);
return courseList;
}
}