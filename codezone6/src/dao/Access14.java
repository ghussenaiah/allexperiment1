
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 



import dto.Course14;

 
public class Access14
{
public ArrayList<Course14> getCourses(Connection con,String table) throws SQLException
{
ArrayList<Course14> courseList = new ArrayList<Course14>();
//PreparedStatement stmt = con.prepareStatement("SELECT UserName FROM TestTable1");
//PreparedStatement stmt = con.prepareStatement("select ProjectName from SProjetctitle where  PID=any(select distinct PID from " + table + " where CategoryName='"+table+"')");
//PreparedStatement stmt = con.prepareStatement("select ProjectName from SProjetctitle where  PID=any(select distinct PID from " + table + " where CategoryName='"+table+"')");
PreparedStatement stmt = con.prepareStatement("select ProjectName from SProjetctitle where  PID=any(select distinct PID from " + table + " where CategoryName='"+table+"')");
ResultSet rs = stmt.executeQuery();
try
{
while(rs.next())
{
	Course14 courseObj = new Course14();

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