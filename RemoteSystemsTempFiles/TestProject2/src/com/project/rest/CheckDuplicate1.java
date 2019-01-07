package com.project.rest;


import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;


@Path("/npd33")
public class CheckDuplicate1 {

	Connection conn;
    ResultSet rslt;
    String Vuser ="Green";
    String Iuser="Red";
    Statement stmt;
    PreparedStatement pst;
    
	String name;
    String name1;
    @Path("/npd44")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String User(@QueryParam("la") String LastName,@QueryParam("pro11") String PID,@QueryParam("user11") String Username,@QueryParam("para11") String CategoryID) throws SQLException
    {
    
   	//public String LoginUser() throws SQLException
   //     {
       
    	//String Username="aa";
    	//String PID="1";
    	//String CategoryID="C5";
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
          // String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
          
          String sql="select Username from SUserTable3 where Username='"+Username+"' and PID='"+PID+"' and CategoryID='"+CategoryID+"'";
     
          stmt = conn.createStatement();

          ResultSet res = stmt.executeQuery(sql);
             int count = 0;
                while(res.next())
                      {
                         count = count + 1;
                	
                       }
             
                 if(count >= 1 )
               //      if( name1 !="Green")
                    	//if( Vuser.equalsIgnoreCase(name1))
                            { 
                    	 System.out.println("duplicate data");
             	           return Vuser;
                            }
                        else
                             { 
                        	System.out.println("Not Duplicate Data");
                        	return Iuser;
                        	
                             }
                 
 
       }catch(Exception e){
    	   System.out.println(e);
       }
    
      return Iuser;  

       
}
	
	
}
