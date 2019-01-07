package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 


import dto.ProjectName;
 
public class Access9
{
public ArrayList<ProjectName> getCourses(Connection con) throws SQLException
{
ArrayList<ProjectName> courseList = new ArrayList<ProjectName>();
PreparedStatement stmt = con.prepareStatement("SELECT * FROM SProjetctitle");
ResultSet rs = stmt.executeQuery();
try
{
while(rs.next())
{
	ProjectName courseObj = new ProjectName();
courseObj.setPID(rs.getInt("PID"));
courseObj.setProjectName(rs.getString("ProjectName"));

courseList.add(courseObj);
}
} catch (SQLException e)
{
e.printStackTrace();
}
return courseList;
 
}
}