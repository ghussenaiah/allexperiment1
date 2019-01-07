package com.sql.conn;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;



public class Sql {

	public static void main(String args[]){  
		try{  
		
		  
		//here sonoo is database name, root is username and password  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			 Connection mCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root"); 
		java.sql.Statement stmt=mCon.createStatement();  
		//Object pstmt = mCon.prepareStatement(null);
		ResultSet rs=stmt.executeQuery("select * from t");  
		//ResultSet rs=((java.sql.Statement) pstmt).executeQuery("select * from TestTable"); 
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
	  
		mCon.close();  
		
		  
		}catch(Exception e){ System.out.println(e);}  
		  
		}  
		
		
}
