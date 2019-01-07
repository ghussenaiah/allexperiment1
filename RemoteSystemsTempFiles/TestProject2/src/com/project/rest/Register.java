package com.project.rest;



import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;
@Path("/reg1")
public class Register {

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
		@QueryParam("uname1") String UserName,
			@QueryParam("pass1") String PassWord,@QueryParam("rpass1") String RePassword,
			
			@QueryParam("email1") String Email,
			@QueryParam("phone1") String Phonenum) throws SQLException
    {
    
 
       
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
          // String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
          String sql="INSERT INTO TestTable1 (UserName,PassWord,RePassWord,Email,Phone) VALUES (?,?,?,?,?)";
        
      
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
       
         
         pst.setString(1, UserName);
            pst.setString(2,PassWord );
        pst.setString(3, RePassword);
        pst.setString(4, Email);
        pst.setString(5,Phonenum );
       
int n1=pst.executeUpdate();
if(n1>0)
    {
	//System.out.println(Phase);
	// System.out.println(Resource);
	// System.out.println(Owner);
        	 return Vuser;
        	
          }
          else
          {
        	  System.out.println(UserName);
        	  System.out.println(Email);
        	  System.out.println(Phonenum);
        	return Iuser;
          }
 
       }catch(Exception e){
    	   System.out.println(e);
       }
    
      return Iuser;  

       
}
	
	
}
