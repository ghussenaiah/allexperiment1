package com.project.rest;
import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;
@Path("/mm1")
public class MileStoneDetails1 {
	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    
	
    
    @Path("/mm2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String MileStone(@QueryParam("la") String LastName,@QueryParam("rfpcomm") String RFPC,@QueryParam("prodevhigh") String ProduDev,@QueryParam("keyevent") String KeyEv,
			@QueryParam("innovation") String Inno1) throws SQLException
    {
    
 
       
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
           //String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
         
          String sql="INSERT INTO MilestoneDetails (RFPComment,Product_Dev_High,keyeve,Innolvation) VALUES (?,?,?,?)";
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
       

         pst.setString(1,RFPC);
         pst.setString(2, ProduDev);
            pst.setString(3,KeyEv);
        pst.setString(4, Inno1);
       

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
