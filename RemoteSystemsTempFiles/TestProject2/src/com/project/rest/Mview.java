package com.project.rest;



import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;
@Path("/mv1")
public class Mview {

	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    
	
    
    @Path("/reg2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String Register1(@QueryParam("la") String LastName,			
		@QueryParam("month1") String Month) throws SQLException
    {
    
 
       
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
           //String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
         // String sql="INSERT INTO TestTable1 (UserName,PassWord,RePassWord,Email,Phone) VALUES (?,?,?,?,?)";
        
          String sql ="select * from MReview where Month=?";
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
       
         
         pst.setString(1, Month);
            
         ResultSet rs1=pst.executeQuery();
         if(rs1.next())
         {
             
       	// return Vuser;
       	
         }
         else
         {
       	 // System.out.println(UserName+"  "+PassWord);
           
       	//return Iuser;
         }

      }catch(Exception e){
   	   System.out.println(e);
      }
   
     return Iuser;  

       
}
	
	
	
}
