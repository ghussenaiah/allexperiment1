package com.project.rest;



import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;
@Path("/am1")
public class AgileMetrics{

	

	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    
	
    
    @Path("/am2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String Metric(@QueryParam("la") String LastName,@QueryParam("psp1") String PlannedStoryPoints,			
		@QueryParam("asp1") String ActualStoryPoints,
			@QueryParam("am1") String AgileMaturity,@QueryParam("rl1") String ReleaseLength,
			
			@QueryParam("dw1") String DiscoveredWork,
			@QueryParam("td1") String TechnicalDept,
			@QueryParam("ab1") String AverageBuilds,			
			@QueryParam("abt1") String AverageBuildTime,
				@QueryParam("abv1") String AverageBuildVerification,@QueryParam("cc1") String CodeCoverage,
				
				@QueryParam("sy1") String StoryCycleTime,
		
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
          String sql="INSERT INTO AgileMetrics (PlannedStoryPoints,ActualStoryPoints,AgileMaturity,ReleaseLength,DiscoveredWork,TechnicalDept,AverageBuilds,AverageBuildTime,AverageBuildVerification,CodeCoverage,StoryCycleTime,PID,Month,Status,Username,CategoryName,Dt,Sprint) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          
      
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
       
         
         pst.setString(1, PlannedStoryPoints);
         pst.setString(2, ActualStoryPoints);
            pst.setString(3,AgileMaturity );
        pst.setString(4, ReleaseLength);
        pst.setString(5, DiscoveredWork);
        pst.setString(6,TechnicalDept );
        pst.setString(7, AverageBuilds);
        
        pst.setString(8, AverageBuildTime);
        pst.setString(9, AverageBuildVerification);
        pst.setString(10, CodeCoverage);
        pst.setString(11, StoryCycleTime);
        
        
        pst.setString(12, PID);
        pst.setString(13, Month);
        pst.setString(14, Status);
        pst.setString(15, Username);
        pst.setString(16, CategoryName);
        pst.setString(17, Dt);
        pst.setString(18, Sprint);

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
