package com.project.rest;


import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;
@Path("/nmd1")
public class NewMetricDetails {

	

	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    
	
    
    @Path("/nmd2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String Metric(@QueryParam("la") String LastName,@QueryParam("phase") String Phase,			
		@QueryParam("resource") String Resource,
			@QueryParam("comment") String Comment,@QueryParam("cost") String Cost,
			
			@QueryParam("risk") String Risk,
			@QueryParam("quality") String Quality,@QueryParam("status") String Status1,
			@QueryParam("pid1") String PID,@QueryParam("month1") String Month,
			@QueryParam("status") String Status,@QueryParam("use2") String Username,
			@QueryParam("pname1") String CategoryName,@QueryParam("dt1") String Dt) throws SQLException
    {
    
 
       
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
         //  String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
         // String sql="INSERT INTO SMetric_Details (Phase,Resources,Comments,Cost,Risk,Quality,Status1,PID,Month,Status,Username,CategoryName) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
          String sql="INSERT INTO MetricDetails (Phase,Resources,Comments,Cost,Risk,Quality,Status1,PID,Month,Status,Username,CategoryName,Dt) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
          
      
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
       
         
         pst.setString(1, Phase);
         pst.setString(2, Resource);
            pst.setString(3,Comment );
        pst.setString(4, Cost);
        pst.setString(5, Risk);
        pst.setString(6,Quality );
        pst.setString(7, Status1);
        pst.setString(8, PID);
        pst.setString(9, Month);
        pst.setString(10, Status);
        pst.setString(11, Username);
        pst.setString(12, CategoryName);
        pst.setString(13, Dt);

int n1=pst.executeUpdate();
if(n1>0)
    {
	System.out.println(Phase);
	  System.out.println(Resource);
	//  System.out.println(Owner);
        	 return Vuser;
        	
          }
          else
          {
        	//  System.out.println(Projectdesc);
        	//  System.out.println(Vam);
        	//  System.out.println(Owner);
        	return Iuser;
          }
 
       }catch(Exception e){
    	   System.out.println(e);
       }
    
      return Iuser;  

       
}
	
}
