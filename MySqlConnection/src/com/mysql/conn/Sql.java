package com.mysql.conn;





public class Sql {


	public static void main(String args[]){  
		try{  
		
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			 mCon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root"); 
		Statement stmt=mCon.createStatement();  
		  
		ResultSet rs=stmt.executeQuery("select * from users");  
		  
		while(rs.next())  
		System.out.println(rs.getString(1)+"  "+rs.getString(2));  
	  
		con.close();  
		
		  
		}catch(Exception e){ System.out.println(e);}  
		  
		}  
		
		
}
