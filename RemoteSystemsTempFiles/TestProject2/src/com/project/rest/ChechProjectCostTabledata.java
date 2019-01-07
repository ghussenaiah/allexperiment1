
package com.project.rest;
import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;
@Path("/cost1")
public class ChechProjectCostTabledata {

	Connection conn;
    ResultSet rslt;
    String Vuser ="Green";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    @Path("/cost2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String LoginUser(@QueryParam("la") String LastName,@QueryParam("u3") String Username,@QueryParam("m3") String Month) throws SQLException
    {
    	//ProjectDetails
    	try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
          // String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
          String sql="select Cost from Newtable where Month='"+Month+"' and Username='"+Username+"'";
          	
         //  String sql="select * from ProjectDetails";
           
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
         ResultSet rs1=pst.executeQuery();
       
//int n1=pst.executeUpdate();
//if(n1>0)
        while(rs1.next())
        {
        	 
        	
             
             String s1 = rs1.getString("Cost");
           
        	
        	if(s1!= null )
        	{
        		return Vuser;
        	}
        	
          
          else
          {
        	
        	return Iuser;
          }
        }
       }catch(Exception e){
    	   System.out.println(e);
       }
    
      return Iuser;  
}
	
}

