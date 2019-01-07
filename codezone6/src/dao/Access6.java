package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 




import dto.Mser;
public class Access6 {

	public ArrayList<Mser> getM(Connection con,String Username) throws SQLException
	//public ArrayList<Mser> getM(Connection con) throws SQLException
	{
	ArrayList<Mser> mservice = new ArrayList<Mser>();
	System.out.println("selected month in Access6" +Username);
	//String sql ="select ProjectDescription,Status from MReview where Month=?";
	//PreparedStatement stmt = con.prepareStatement("select ProjectDescription1,Status from MReview where Month='"+Month+"'");
	//PreparedStatement stmt = con.prepareStatement("select ProjectDescription1,Status from Newtable where Month='"+Username+"'");
//2	String sql="select PID,ProjectName,Status from SProjetctitle where PID IN(select PID from SUserTable1 where Username='"+Username+"')";
	String sql="select PID,ProjectName,Status from SProjetctitle where PID IN(select PID from SUserTable3 where Username='"+Username+"')";
	PreparedStatement stmt = con.prepareStatement(sql);
	//PreparedStatement stmt = con.prepareStatement("select * from MReview");
	//PreparedStatement stmt = con.prepareStatement(sql);
	//PreparedStatement stmt = con.prepareStatement("select ProjectDescription,Status from MReview");
	ResultSet rs = stmt.executeQuery();
	try
	{
	while(rs.next())
	{
		//System.out.println("selected month in Access6" +Month);
	Mser courseObj1 = new Mser();
	courseObj1.setPID(rs.getInt("PID"));
	courseObj1.setProjectName(rs.getString("ProjectName"));
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
