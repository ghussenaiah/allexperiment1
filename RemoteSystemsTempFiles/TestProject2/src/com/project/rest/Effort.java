package com.project.rest;

import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;
@Path("/ef1")
public class Effort{

	

	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    
	
    
    @Path("/ef2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String Metric(@QueryParam("la") String LastName,@QueryParam("te1") String TotalEffort,			
		@QueryParam("re1") String ReviewEffort,
			@QueryParam("de1") String DesignEffort,@QueryParam("ce1") String CodingEffort,
			
			@QueryParam("te11") String TestEffort,
			@QueryParam("re11") String ReworkEffort,
			
			
			@QueryParam("pid1") String PID,@QueryParam("month1") String Month,
			@QueryParam("status") String Status,@QueryParam("use2") String Username,
			@QueryParam("pname1") String CategoryName,@QueryParam("dt1") String Dt,@QueryParam("sp2") String Sprint) throws SQLException
    {
    
 
       
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
         //  String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
         // String sql="INSERT INTO SMetric_Details (Phase,Resources,Comments,Cost,Risk,Quality,Status1,PID,Month,Status,Username,CategoryName) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
          String sql="INSERT INTO Effort (TotalEffort,ReviewEffort,DesignEffort,CodingEffort,TestEffort,ReworkEffort,PID,Month,Status,Username,CategoryName,Dt,Sprint) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
          
      
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
       
         
         pst.setString(1,TotalEffort);
         pst.setString(2, ReviewEffort);
            pst.setString(3,DesignEffort);
        pst.setString(4, CodingEffort);
        pst.setString(5, TestEffort);
        pst.setString(6,ReworkEffort );
      
        pst.setString(7, PID);
        pst.setString(8, Month);
        pst.setString(9, Status);
        pst.setString(10, Username);
        pst.setString(11, CategoryName);
        pst.setString(12, Dt);
        pst.setString(13, Sprint);

int n1=pst.executeUpdate();
if(n1>0)
    {
//	System.out.println(Phase);
	//  System.out.println(Resource);
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
