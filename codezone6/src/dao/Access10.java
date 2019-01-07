
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 



import dto.Course5;

 
public class Access10
{
public ArrayList<Course5> getCourses(Connection con,String table) throws SQLException
{
ArrayList<Course5> courseList = new ArrayList<Course5>();
//PreparedStatement stmt = con.prepareStatement("SELECT UserName FROM TestTable1");
PreparedStatement stmt = con.prepareStatement("select distinct UserName from " + table + " where CategoryName='"+table+"'");
//PreparedStatement stmt = con.prepareStatement("select distinct UserName from " + table + "");
ResultSet rs = stmt.executeQuery();
try
{
while(rs.next())
{
	Course5 courseObj = new Course5();

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