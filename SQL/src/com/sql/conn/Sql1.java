package com.sql.conn;

import java.sql.DriverManager;



import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Sql1 {

	

	
	public static void main(String args[]){  
	try{  
	Class.forName("com.mysql.jdbc.Driver");  
	  
	//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB","root","root");  
	Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/xe","system","root");   
	//here sonoo is database name, root is username and password  
	  
	java.sql.Statement stmt=con.createStatement();  
	  
	java.sql.ResultSet rs=stmt.executeQuery("select * from users");  
	  
	while(rs.next())  
	System.out.println(rs.getString(1)+"  "+rs.getString(2));  
  
	con.close();  
	
	  
	}catch(Exception e){ System.out.println(e);}  
	  
	} 
}