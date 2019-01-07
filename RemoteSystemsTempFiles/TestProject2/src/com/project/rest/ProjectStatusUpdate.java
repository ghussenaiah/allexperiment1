package com.project.rest;


import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;
@Path("/up1")
public class ProjectStatusUpdate {

	

	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    
	
    
    @Path("/up2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String Metric(@QueryParam("la") String LastName,@QueryParam("use2") String Username,			
		@QueryParam("month1") String Month,
			@QueryParam("pam") String CategoryID) throws SQLException
    {
    
 
       
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
           //String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
         // String sql="INSERT INTO SMetric_Details (Phase,Resources,Comments,Cost,Risk,Quality,Status1,PID,Month,Status,Username,ParameterName) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        
          String sql="update SUserTable3 set Status='Green' where Username='"+ Username+"' and  Month='"+ Month+"' and  Parameter='"+CategoryID+"'";
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
       
         
        

int n1=pst.executeUpdate();
if(n1>0)
    {
	
        	
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

