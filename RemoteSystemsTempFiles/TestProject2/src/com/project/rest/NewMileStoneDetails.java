package com.project.rest;


import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;
@Path("/dd1")
public class NewMileStoneDetails {
	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    
	
    
    @Path("/dd2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String MileStone(@QueryParam("la") String LastName,@QueryParam("rfpcomm") String RFPComment,@QueryParam("prodevhigh") String Product_Dev_High,@QueryParam("keyevent") String keyeve,
			@QueryParam("innovation") String Innolvation,@QueryParam("pid1") String PID,@QueryParam("month1") String Month,
			@QueryParam("status") String Status,@QueryParam("use2") String Username,
			@QueryParam("pname1") String CategoryName,@QueryParam("dt1") String Dt) throws SQLException
    {
    
 
       
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
           //String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
         
        //  String sql="INSERT INTO SMilestoneDetails (RFPComment,Product_Dev_High,keyeve,Innolvation,PID,Month,Status,Username,CategoryName) VALUES (?,?,?,?,?,?,?,?,?)";
          
          String sql="INSERT INTO MileStoneDetails (RFPComment,Product_Dev_High,keyeve,Innolvation,PID,Month,Status,Username,CategoryName,Dt) VALUES (?,?,?,?,?,?,?,?,?,?)";  
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
       

         pst.setString(1,RFPComment);
         pst.setString(2, Product_Dev_High);
            pst.setString(3,keyeve);
        pst.setString(4, Innolvation);
        pst.setString(5, PID);
        pst.setString(6, Month);
        pst.setString(7, Status);
        pst.setString(8, Username);
        pst.setString(9, CategoryName);
        pst.setString(10, Dt);
       

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