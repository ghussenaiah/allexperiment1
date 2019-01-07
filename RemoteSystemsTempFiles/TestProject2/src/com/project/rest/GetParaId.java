
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
@Path("/getpa1")
public class GetParaId {

	Connection conn;
ResultSet rslt;
String r2=null;
String Vuser ="Valid";
String Iuser="Invalid";
Statement stmt;
PreparedStatement pst;

	

@Path("/getpa2")

@POST
@Produces(MediaType.TEXT_HTML)


//1public String LoginUser(@QueryParam("la") String LastName,@QueryParam("para11") String ParameterName ) throws SQLException

	public String LoginUser(@QueryParam("la") String LastName,@QueryParam("para11") String CategoryName) throws SQLException
	{
String k2=LastName;
   
   try{
	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      // String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
       String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
      conn=DriverManager.getConnection(url,"sa","Password@1");
  
    //1  String sql ="select * from SParameterTable where ParameterName=?";
      String sql ="select * from CategoryTable where CategoryName=?";
     java.sql.PreparedStatement pst= conn.prepareStatement(sql);
                  
     pst.setString(1,CategoryName);
   
   

   
     ResultSet rs1=pst.executeQuery();
      if(rs1.next())
      {
          
      	//1 String r2=rs1.getString("Parameter");
    	  String r2=rs1.getString("CategoryID");
      	System.out.println(k2);
    	 //return Vuser;
      	System.out.println("Parameter"+r2);
      	System.out.println("username"+CategoryName);
      	return r2;
    	
      }
      

   }catch(Exception e){
	   System.out.println(e);
   }

  return r2;  

   
}
	
}
