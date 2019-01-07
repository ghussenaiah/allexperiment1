package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 

import dto.Member7;

public class Access7 {

	public ArrayList<Member7> getM(Connection con,String Username,String PID,String Month) throws SQLException
//	public ArrayList<Member7> getM(Connection con) throws SQLException
	{
	ArrayList<Member7> mservice = new ArrayList<Member7>();
	
	//2String sql="select Parameter,ParameterName from SParameterTable where Parameter =any(select Parameter from SUserTable1 where Username='"+Username+"' and PID='"+PID+"')";				
	//String sql="select CategoryID,CategoryName from CategoryTable where  CategoryID=any(select CategoryID from SUserTable3 where Username='"+Username+"' and PID='"+PID+"')";
	String sql="Select c.CategoryID,c.CategoryName,s3.Status,s3.Dt from CategoryTable c inner join SUserTable3 s3 on s3.CategoryID=c.CategoryID where Username='"+Username+"' and PID='"+PID+"' and Month='"+Month+"';";
	PreparedStatement stmt = con.prepareStatement(sql);
	
	ResultSet rs = stmt.executeQuery();
	try
	{
	while(rs.next())
	{
	Member7 courseObj1 = new Member7();

	courseObj1.setCategoryID(rs.getString("CategoryID"));
	courseObj1.setCategoryName(rs.getString("CategoryName"));
	courseObj1.setDt(rs.getString("Dt"));
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