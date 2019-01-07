package com.project.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

//import javax.ws.rs.Produces;





import java.sql.*;

//import com.mysql.jdbc.ResultSet;
//import com.mysql.jdbc.Statement;


@Path("/m4")

public class Metric_Details {

	
	Connection conn;
    ResultSet rslt;
    String data ="successfully inserted11";
    Statement stmt;
    
    @Path("/m5")
    @POST
	//@Produces(MediaType.TEXT_HTML)
	
	public void UserRegistration(@FormParam("phase") Integer Phase,			
		@FormParam("resource") String Resource,
			@FormParam("comment") String Comment,@FormParam("cost") String Cost,
			
			@FormParam("risk") String Risk,
			@FormParam("quality") String Quality,@FormParam("status") String Status) throws SQLException {
    
    	
    	String sql="INSERT INTO MetricDetails (Phase,Resources,Comments,Cost,Risk,Quality,Status) VALUES (?,?,?,?,?,?,?)";
    	
    	//String lLoginQuery1 ="Insert into Metric_Details values ('" + Phase + "','" +Resource + "','" +Comment+ "', '" +Cost+ "',"
    	//		+ "'" + Risk + "','" +Quality + "','" +Status + "')";

		 
			  try{
				  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            // String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
		             String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
		            conn=DriverManager.getConnection(url,"sa","Password@1");
		        
    		  
    		//here sonoo is database name, root is username and password  
    		  
    		//Statement stmt=(Statement) conn.createStatement();  
       		//stmt.executeQuery(lLoginQuery1);  
       		//stmt.executeQuery(lLoginQuery);
    		//rslt.close();
    		 
    		//System.out.println("successfully inserted");
    		
		            PreparedStatement pst=conn.prepareStatement(sql);
	                
		            pst.setInt(1, Phase);
		            pst.setString(2, Resource);
		               pst.setString(3,Comment );
		           pst.setString(4, Cost);
		           pst.setString(5, Risk);
		           pst.setString(6,Quality );
		           pst.setString(7, Status);
	        //put the rest of the code
	        int n1=pst.executeUpdate();
	        if(n1>0)
	        {
	        JOptionPane.showMessageDialog(null,"Inserted Successfully!!");
	        }
	        else
	        {
	        	 JOptionPane.showMessageDialog(null,"Not Inserted!");
	        }
  
   		
    		}
		catch(Exception e){ System.out.println(e);}  
		//return data;
    } 
}   
  /*  public String UserRegistration(@FormParam("phase") Integer Phase			
    		
    			) throws SQLException {
        
        	
        	
        	
        	String lLoginQuery ="Insert into Metricd values ('" + Phase + "',)";

    		 
    			  try{
    		    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		           String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
    		           
    		          conn=DriverManager.getConnection(url,"sa","Password@1");
    		        
        		  
        		//here sonoo is database name, root is username and password  
        		  
        		Statement stmt=(Statement) conn.createStatement();  
        		  
        		stmt.executeUpdate(lLoginQuery);  
        		
        		//stmt.executeQuery(lLoginQuery);
        		//rslt.close();
        		 
        		System.out.println("successfully inserted");
        		
        		stmt.close();
        		//con.close();  
        		return data;
        	//	return "successfully inserted";
        	
        		}
    		catch(Exception e){ System.out.println(e);}  
    		return data; 
} */
