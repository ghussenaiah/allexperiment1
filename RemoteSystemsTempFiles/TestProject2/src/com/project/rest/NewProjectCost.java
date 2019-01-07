package com.project.rest;


import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;


@Path("/npc1")
public class NewProjectCost {

	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    
	
    
    @Path("/npc2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String LoginUser(@QueryParam("la") String LastName,@QueryParam("cos") String Cost,
			@QueryParam("pid1") String PID,@QueryParam("month1") String Month,
			@QueryParam("status") String Status,@QueryParam("use2") String Username,
			@QueryParam("pname1") String CategoryName,@QueryParam("dt1") String Dt) throws SQLException
    {
    
 
       
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
           //String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
         
        //  String sql ="Insert into ProjectDetails values ('" + Projectdesc + "','" +Vam + "','" +Owner+ "')";
        //  String sql="INSERT INTO SProjectCost (Cost,PID,Month,Status,Username,CategoryName) VALUES (?,?,?,?,?,?)";
          String sql="INSERT INTO ProjectCost (Cost,PID,Month,Status,Username,CategoryName,Dt) VALUES (?,?,?,?,?,?,?)";
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
       
pst.setString(1, Cost);       

pst.setString(2, PID);
pst.setString(3, Month);
pst.setString(4, Status);
pst.setString(5, Username);
pst.setString(6, CategoryName);
pst.setString(7, Dt);


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


