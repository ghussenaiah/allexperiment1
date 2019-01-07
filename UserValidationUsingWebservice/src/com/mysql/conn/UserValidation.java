package com.mysql.conn;

import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;



public class UserValidation {



		Connection conn;
	    ResultSet rslt;
	    String Vuser ="Valid";
	    String Iuser="Invalid";
	    Statement stmt;
	    PreparedStatement pst;
	    
		
	    
	 
	    
	    
	    public String loginUser(  String UserName, String PassWord ) throws SQLException
	    {
	    
	 
	       
	       try{
	    	   Class.forName("com.mysql.jdbc.Driver");  
	    		  
	    		//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB","root","root");  
	    		Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB","root","root");   
	          String sql ="select * from testtable where UserName=? and PassWord=?";
	         java.sql.PreparedStatement pst= ((java.sql.Connection) conn).prepareStatement(sql);
	    
	          
	         pst.setString(1,UserName);
	       pst.setString(2,PassWord);
	       
	   
	       
	          ResultSet rs1=pst.executeQuery();
	          if(rs1.next())
	          {
	              
	        	 return Vuser;
	        	
	          }
	          else
	          {
	        	 // System.out.println(UserName+"  "+PassWord);
	            
	        	return Iuser;
	          }
	 
	       }catch(Exception e){
	    	   System.out.println(e);
	       }
	    
	      return Iuser;  

	       
	}
	
	}
