package com.mysql.conn;


import java.sql.*;

import com.mysql.jdbc.Connection;

public class InsertData {
	  static Connection conn = null;
	   static Statement stmt = null;
  
   
   public static void main(String[] args) {
 
   try{

	   Class.forName("com.mysql.jdbc.Driver");  
		  
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB","root","root"); 


     
      
      
  
     
      stmt = conn.createStatement();
      
      String sql = "INSERT INTO TestTable " +"VALUES ('welcome', 'welcome')";
      stmt.executeUpdate(sql);
     
      System.out.println("Inserted records ...");


   }catch(Exception e){ System.out.println(e);}  
	  
	}  
	}  
