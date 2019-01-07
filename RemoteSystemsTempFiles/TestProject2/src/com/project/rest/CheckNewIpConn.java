 
package com.project.rest;
import java.sql.*; 


public class CheckNewIpConn {

	
	public static void main(String args[]){  
		try{  
		//step1 load the driver class  
			  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	 
	        //   String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
	           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
	          Connection conn = DriverManager.getConnection(url,"sa","Password@1");
		//step3 create the statement object  
		Statement stmt=conn.createStatement();  
		  
		//step4 execute query  
		ResultSet rs=stmt.executeQuery("select * from SUserTable3");  
		while(rs.next())  
		System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		  
		//step5 close the connection object  
		conn.close();  
		  
		}catch(Exception e){ System.out.println(e);}  
		  
		}  
}
