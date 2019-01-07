package com.project.rest;

import java.sql.*;
import java.text.DateFormatSymbols;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;


@Path("/map1")
public class UserMap {

	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
   
	String Status="Red";
    String Month;
    String sql;
    int n1;
    @Path("/map2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String User(@QueryParam("la") String LastName,@QueryParam("pro11") String PID,@QueryParam("user11") String Username,@QueryParam("para11") String CategoryID) throws SQLException
    {
    
 
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
          // String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
        String[] months = new DateFormatSymbols().getMonths();
         for (int i = 0; i < months.length-1; i++) 
          {
                 Month = months[i];
                 sql="INSERT INTO SUserTable3 (PID,Username,Month,Status,CategoryID) VALUES (?,?,?,?,?)";
                  java.sql.PreparedStatement pst=conn.prepareStatement(sql);
       
                   pst.setString(1, PID);
                   pst.setString(2, Username);
                  
                   pst.setString(3, Month);
                   pst.setString(4, Status);
                   pst.setString(5, CategoryID);
                  n1= pst.executeUpdate();
            }

//int n1=pst.executeUpdate();
          
if(n1>0)
    {
	
	System.out.println("Username"+Username);
	System.out.println("Project id "+PID);
	System.out.println("Category Id"+CategoryID);
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

