package com.project.rest;


import java.sql.*;

//import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;

//import java.sql.*;
@Path("/g1")
public class GetRollId {

	Connection conn;
  ResultSet rslt;
  String r2=null;
  String Vuser ="Valid";
  String Iuser="Invalid";
  Statement stmt;
  PreparedStatement pst;
  
	
  
  @Path("/g2")
  
  @POST
  @Produces(MediaType.TEXT_HTML)
  
  
  public String LoginUser(@QueryParam("la") String LastName,@QueryParam("name1") String UserName,@QueryParam("pwd1") String PassWord ) throws SQLException
  {
  
  String k2=LastName;
     
     try{
  	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
         String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
        conn=DriverManager.getConnection(url,"sa","Password@1");
      //  String sql ="select RollId from TestTable1 where UserName=? and PassWord=?";
        String sql ="select * from TestTable1 where UserName=? and PassWord=?";
       // String sql ="select * from TestTable1 where UserName=? and PassWord=?";
       java.sql.PreparedStatement pst= conn.prepareStatement(sql);
                     // Statement stmt= ((Object) conn).statement();
     //  ResultSet rs1 = stmt.executeQuery();
       pst.setString(1,UserName);
     pst.setString(2,PassWord);
     
 
     
       ResultSet rs1=pst.executeQuery();
        if(rs1.next())
        {
            
        	String r2=rs1.getString("RollId");
        	System.out.println(k2);
      	 //return Vuser;
        	System.out.println(r2);
        	return r2;
      	
        }
        

     }catch(Exception e){
  	   System.out.println(e);
     }
  
    return r2;  

     
}
	
}

