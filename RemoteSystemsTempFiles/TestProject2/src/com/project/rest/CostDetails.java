package com.project.rest;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;





import javax.swing.JOptionPane;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import java.sql.*;
@Path("/c4")

public class CostDetails {
	
	
	
	Connection conn;
    ResultSet rslt;
    String data ="successfully inserted11";
    Statement stmt;
    
    @Path("/c5")
    @POST
	//@Produces(MediaType.TEXT_HTML)
	
	public void ProjectCost(@FormParam("projectcost") Integer Projectcost) throws SQLException {
    
    	
    	
    	String sql="INSERT INTO ProjectCost (Cost) VALUES (?)";
    	

		 
			  try{
				  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		          //   String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
		             String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
		            conn=DriverManager.getConnection(url,"sa","Password@1");
		        
     
    PreparedStatement pst=conn.prepareStatement(sql);
	                
		            pst.setInt(1, Projectcost);
		           
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
  

































