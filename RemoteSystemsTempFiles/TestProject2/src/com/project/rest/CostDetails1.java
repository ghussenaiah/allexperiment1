package com.project.rest;
import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;
@Path("/c1")
public class CostDetails1 {

	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    @Path("/c2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String LoginUser(@QueryParam("la") String LastName,@QueryParam("cos") Integer Cost) throws SQLException
    {
         
    	try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
          // String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
          
           String sql="INSERT INTO ProjectCost (Cost) VALUES (?)";
           
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
       
         pst.setInt(1, Cost);    
int n1=pst.executeUpdate();
if(n1>0)
    {
	//System.out.println(Projectdesc);
	//  System.out.println(Vam);
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
