package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.Manager;

public class Access8 {

	public ArrayList<Manager> getA(Connection con,String Month) throws SQLException

	{
	ArrayList<Manager> mservice = new ArrayList<Manager>();
	System.out.println("selected month in Access8" +Month);
	
	//String sql="select PID,ProjectName,Status from SProjetctitle where PID IN(select PID from SUserTable1 where Username='"+Username+"')";
	
	//String sql="select SUserTable1.PID,SProjetctitle.ProjectName,SUserTable1.Username,SUserTable1.Parameter,SUserTable1.Status from SUserTable1,SProjetctitle on SUserTable1.PID=SProjetctitle.PID  where Month='"+Month+"'";
	
	//String sql="select s1.PID,p1.ProjectName,s1.Username,s1.Parameter,s1.Status from SUserTable1 s1 INNER JOIN SProjetctitle p1 ON s1.PID=p1.PID  where Month='"+Month+"'";
	String sql="select s1.PID,p1.ProjectName,s1.Username,s1.CategoryID,s1.Status from SUserTable3 s1 INNER JOIN SProjetctitle p1 ON s1.PID=p1.PID  where Month='"+Month+"'";
	PreparedStatement stmt = con.prepareStatement(sql);
	
	ResultSet rs = stmt.executeQuery();
	try
	{
	while(rs.next())
	{
		System.out.println("selected month in Access8" +Month);
	Manager courseObj1 = new Manager();
	courseObj1.setPID(rs.getString("PID"));
	courseObj1.setProjectName(rs.getString("ProjectName"));
	courseObj1.setUsername(rs.getString("Username"));
	courseObj1.setCategoryID(rs.getString("CategoryID"));
	courseObj1.setStatus(rs.getString("Status"));
	
	mservice.add(courseObj1);
	}
	} catch (SQLException e)
	{
	e.printStackTrace();
	}
	return mservice;
	}
}