
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
import dto.Course6;
 
public class Access11
{
public ArrayList<Course6> getCourses(Connection con) throws SQLException
{
ArrayList<Course6> courseList = new ArrayList<Course6>();
//PreparedStatement stmt = con.prepareStatement("SELECT ParameterName FROM SParameterTable");
PreparedStatement stmt = con.prepareStatement("SELECT CategoryName FROM CategoryTable");
ResultSet rs = stmt.executeQuery();
try
{
while(rs.next())
{
Course6 courseObj = new Course6();

courseObj.setCategoryName(rs.getString("CategoryName"));

courseList.add(courseObj);
}
} catch (SQLException e)
{
e.printStackTrace();
}
return courseList;
 
}
}