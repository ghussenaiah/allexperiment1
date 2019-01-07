
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 



import dto.Course13;

 
public class Access13
{
public ArrayList<Course13> getCourses(Connection con,String table) throws SQLException
{
ArrayList<Course13> courseList = new ArrayList<Course13>();
//PreparedStatement stmt = con.prepareStatement("SELECT UserName FROM TestTable1");
//PreparedStatement stmt = con.prepareStatement("select distinct Month from " + table +" where CategoryName='"+table+"'");
PreparedStatement stmt = con.prepareStatement("select distinct Month from " + table +" where CategoryName='"+table+"'");
ResultSet rs = stmt.executeQuery();
try
{
while(rs.next())
{
	Course13 courseObj = new Course13();

courseObj.setMonth(rs.getString("Month"));

courseList.add(courseObj);
}
} catch (SQLException e)
{
e.printStackTrace();
}
return courseList;
 
}
}