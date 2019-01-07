package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 

import dto.Mser11;
public class Access12{

	public ArrayList<Mser11> getM(Connection con,String Username,String PID) throws SQLException
	//public ArrayList<Mser> getM(Connection con) throws SQLException
	{
	ArrayList<Mser11> mservice = new ArrayList<Mser11>();
	System.out.println("selected month in Access6" +Username);
	
 
	String sql="select ParameterName from SParameterTable where Parameter =any(select Parameter from SUserTable1 where Username='"+Username+"' and PID='"+PID+"')";
	PreparedStatement stmt = con.prepareStatement(sql);
	
	ResultSet rs = stmt.executeQuery();
	try
	{
	while(rs.next())
	{
		//System.out.println("selected month in Access6" +Month);
		
	Mser11 courseObj1 = new Mser11();
	
	courseObj1.setParameterName(rs.getString("ParameterName"));
	
	mservice.add(courseObj1);
	}
	} catch (SQLException e)
	{
	e.printStackTrace();
	}
	return mservice;
	}
}