package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 



import dto.Course15;

 
public class Access15
{
public ArrayList<Course15> getCourses(Connection con) throws SQLException
{
ArrayList<Course15> courseList = new ArrayList<Course15>();
PreparedStatement stmt = con.prepareStatement("SELECT UserName FROM TestTable1");
//PreparedStatement stmt = con.prepareStatement("select distinct UserName from " + table + " where CategoryName='"+table+"'");
//PreparedStatement stmt = con.prepareStatement("select distinct UserName from " + table + "");
ResultSet rs = stmt.executeQuery();
try
{
while(rs.next())
{
	Course15 courseObj = new Course15();

courseObj.setUserName(rs.getString("UserName"));

courseList.add(courseObj);
}
} catch (SQLException e)
{
e.printStackTrace();
}
return courseList;
 
}
}
