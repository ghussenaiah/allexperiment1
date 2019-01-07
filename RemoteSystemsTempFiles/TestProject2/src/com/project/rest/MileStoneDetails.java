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
@Path("/mi4")

public class MileStoneDetails {
	
	
	
	Connection conn;
    ResultSet rslt;
    String data ="successfully inserted11";
    Statement stmt;
    
    @Path("/mi5")
    @POST
	//@Produces(MediaType.TEXT_HTML)
	
	public void MileStone(@FormParam("rfpcomm") String RFPC,@FormParam("prodevhigh") String ProduDev,@FormParam("keyevent") String KeyEv,
			@FormParam("innovation") String Inno) throws SQLException {
    
    	
    	String sql="INSERT INTO MilestoneDetails (RFPComment,Product_Dev_High,keyeve,Innolvation) VALUES (?,?,?,?)";
    	
    	//String lLoginQuery1 ="Insert into MilestoneDetails values ('" + RFPC + "','" +ProduDev + "','" +KeyEv+ "','" + Inno + "')";

		 
			  try{
				  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            // String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
		             String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
		            conn=DriverManager.getConnection(url,"sa","Password@1");
		          
		    		  
		    		//Statement stmt=(Statement) conn.createStatement();  
		       		//stmt.executeQuery(lLoginQuery1);  
		       		//stmt.executeQuery(lLoginQuery);
		    		//rslt.close();
		    		 
		    		//System.out.println("successfully inserted");
		    		
				            PreparedStatement pst=conn.prepareStatement(sql);
			                
				            pst.setString(1,RFPC);
				            pst.setString(2, ProduDev);
				               pst.setString(3,KeyEv);
				           pst.setString(4, Inno);
				          
				           
				          
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
  