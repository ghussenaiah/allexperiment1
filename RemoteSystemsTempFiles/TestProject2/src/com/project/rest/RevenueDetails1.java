package com.project.rest;
import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;
@Path("/r1")
public class RevenueDetails1 {
	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    
	
    
    @Path("/r2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String Revenue(@QueryParam("la") String LastName,@QueryParam("npi1") Integer Npi,@QueryParam("rd1") Integer Rd,@QueryParam("rdb1") Integer Rdb,
			@QueryParam("rev") Integer Rev1,@QueryParam("rev3") Integer Rev2) throws SQLException
    {
    
 
       
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
          // String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
         
          String sql="INSERT INTO RevenueDetails (NpiRevenue,RDBudget,RDBudgetActual,revenue2016,revenue2017) VALUES (?,?,?,?,?)";
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
       
         pst.setInt(1,Npi);
         pst.setInt(2, Rd);
            pst.setInt(3,Rdb);
        pst.setInt(4, Rev1);
        pst.setInt(5, Rev2);
         

int n1=pst.executeUpdate();
if(n1>0)
    {
//	System.out.println(Phase);
//	  System.out.println(Resource);
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
