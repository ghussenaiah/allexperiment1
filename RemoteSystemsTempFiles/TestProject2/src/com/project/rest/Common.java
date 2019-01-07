package com.project.rest;


import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;
@Path("/cm1")
public class Common{

	

	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    
	
    
    @Path("/cm2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String Metric(@QueryParam("la") String LastName,@QueryParam("hs1") String HSEScore,			
		@QueryParam("am1") String Automation,
			@QueryParam("ps1") String ProductivitySavings,@QueryParam("kb1") String KBriefs,
			
			@QueryParam("pt1") String Patents,
			@QueryParam("wids1") String WIDS,
			@QueryParam("ppv1") String PPVPOC,			
			@QueryParam("kr1") String KaizensResolved,
				@QueryParam("tm1") String TeamSize,
				
			
			@QueryParam("pid1") String PID,@QueryParam("month1") String Month,
			@QueryParam("status") String Status,@QueryParam("use2") String Username,
			@QueryParam("pname1") String CategoryName,@QueryParam("dt1") String Dt,@QueryParam("sp2") String Sprint) throws SQLException
    {
    
 
       
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
         //  String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
         // String sql="INSERT INTO SMetric_Details (Phase,Resources,Comments,Cost,Risk,Quality,Status1,PID,Month,Status,Username,CategoryName) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
          String sql="INSERT INTO Common (HSEScore,Automation,ProductivitySavings,KBriefs,Patents,WIDS,PPVPOC,KaizensResolved,TeamSize,PID,Month,Status,Username,CategoryName,Dt,Sprint) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          
      
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
       
         
         pst.setString(1, HSEScore);
         pst.setString(2, Automation);
            pst.setString(3,ProductivitySavings );
        pst.setString(4, KBriefs);
        pst.setString(5, Patents);
        pst.setString(6,WIDS );
        pst.setString(7, PPVPOC);
        pst.setString(8, KaizensResolved);
        pst.setString(9, TeamSize);
        pst.setString(10, PID);
        pst.setString(11, Month);
        
        pst.setString(12, Status);
        pst.setString(13, Username);
        pst.setString(14, CategoryName);
        pst.setString(15, Dt);
        pst.setString(16, Sprint);

int n1=pst.executeUpdate();
if(n1>0)
    {
//	System.out.println(Phase);
	//  System.out.println(Resource);
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
