package com.mysql.conn;


import com.mysql.jdbc.Connection;  
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class MySqlConn {

	

	
	public static void main(String args[]){  
	try{  
	Class.forName("com.mysql.jdbc.Driver");  
	  
	//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB","root","root");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB","root","root");   
	//here sonoo is database name, root is username and password  
	  
	Statement stmt=con.createStatement();  
	  
	ResultSet rs=stmt.executeQuery("select * from testtable");  
	  
	while(rs.next())  
	System.out.println(rs.getString(1)+"  "+rs.getString(2));  
  
	con.close();  
	
	  
	}catch(Exception e){ System.out.println(e);}  
	  
	}  
	
	
	
	
	}  

