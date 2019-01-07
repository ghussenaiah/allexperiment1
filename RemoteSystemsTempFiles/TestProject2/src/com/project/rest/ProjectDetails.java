package com.project.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




import javax.swing.JOptionPane;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import java.sql.*;
@Path("/p4")

public class ProjectDetails {
	
	
	
	Connection conn;
    ResultSet rslt;
    String data ="successfully inserted11";
    Statement stmt;
    
    @Path("/p5")
    @POST
	//@Produces(MediaType.TEXT_HTML)
	
	public void Project(@FormParam("prodesc") String Projectdesc,
			@FormParam("vam") String Vam,@FormParam("owner") String Owner) throws SQLException {
    
    	 String sql="INSERT INTO ProjectDetails (ProjectDescription,Vam,Owner) VALUES (?,?,?)";
    	
    	
    //	String lLoginQuery1 ="Insert into ProjectDetails values ('" + Projectdesc + "','" +Vam + "','" +Owner+ "')";

		 
			  try{
				  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		             //String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
		             String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
		            conn=DriverManager.getConnection(url,"sa","Password@1");
		        
		            PreparedStatement pst=conn.prepareStatement(sql);
	                 //  String pro = jTextArea1.getText();
	                  // String vam = jTextField1.getText();
	                   //String owner = jTextField2.getText();
	        pst.setString(1, Projectdesc);       
	        pst.setString(2, Vam);
	        pst.setString(3, Owner);
	        //put the rest of the code
	        int n1=pst.executeUpdate();
	        if(n1>0)
	        {
	        JOptionPane.showMessageDialog(null,"Inserted Successfully!");
	        }
	        else
	        {
	        	 JOptionPane.showMessageDialog(null,"Not Inserted!");
	        }
    //		Statement stmt=(Statement) conn.createStatement();  
    //		stmt.executeQuery(lLoginQuery1);  
     //		stmt.close();
   //		rslt.close();
    		}
		catch(Exception e){ System.out.println(e);}  
		//return data;
    } 
}   
  
