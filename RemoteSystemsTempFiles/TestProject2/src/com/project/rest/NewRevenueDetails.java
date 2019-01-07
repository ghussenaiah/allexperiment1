package com.project.rest;


import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;
@Path("/rv1")
public class NewRevenueDetails {
	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    
	
    
    @Path("/rv2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String Revenue(@QueryParam("la") String LastName,@QueryParam("npi1") String NpiRevenue,@QueryParam("rd1") String RDBudget,@QueryParam("rdb1") String RDBudgetActual,
			@QueryParam("rev") String revenue2016,@QueryParam("rev3") String revenue2017,@QueryParam("pid1") String PID,@QueryParam("month1") String Month,
			@QueryParam("status") String Status,@QueryParam("use2") String Username,
			@QueryParam("pname1") String CategoryName,@QueryParam("dt1") String Dt) throws SQLException
    {
    
 
       
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
          // String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
         
         
        // String sql="INSERT INTO SRevenueDetails (NpiRevenue,RDBudget,RDBudgetActual,revenue2016,revenue2017,PID,Month,Status,Username,CategoryName) VALUES (?,?,?,?,?,?,?,?,?,?)";
         String sql="INSERT INTO RevenueDetails (NpiRevenue,RDBudget,RDBudgetActual,revenue2016,revenue2017,PID,Month,Status,Username,CategoryName,Dt) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
         
       
         pst.setString(1,NpiRevenue);
         pst.setString(2, RDBudget);
            pst.setString(3,RDBudgetActual);
        pst.setString(4, revenue2016);
        pst.setString(5, revenue2017);
        pst.setString(6, PID);
        pst.setString(7, Month);
        pst.setString(8, Status);
        pst.setString(9, Username);
        pst.setString(10,CategoryName);
        pst.setString(11,Dt);
         

int n1=pst.executeUpdate();
if(n1>0)
    {

        	 return Vuser;
        	
          }
          else
          {
        	
        	return Iuser;
          }
 
       }catch(Exception e){
    	   System.out.println(e);
       }
    
      return Iuser;  

       
}
}

