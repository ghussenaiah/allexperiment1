package com.project.rest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import java.sql.*;
//import javax.ws.rs.Produces;


//import com.mysql.jdbc.ResultSet;
//import com.mysql.jdbc.Statement;
@Path("/db2")
public class SqlServerConn {

	Connection conn;
    ResultSet rslt;
    String Iuser ="Invalid User";
    Statement stmt;
    
    @Path("/register2")
    @POST
	//@Produces(MediaType.TEXT_HTML)
	public void UserRegistration(@FormParam("firstname") String FirstName,			
			@FormParam("lastname") String Lastname,
			@FormParam("username") String Username,
			@FormParam("password") String Password) throws SQLException {
    	
    	String lLoginQuery ="Insert into Regi values ('" + FirstName + "','" +Lastname  + "','" +Username + "', '" + Password + "')";
	//	lLoginQuery =lLoginQuery + "" + FirstName + "','" +Lastname  + "','" +
	//			Username + "', '" + Password + "','";
		
//	String lLoginQuery ="insert into regi values ('notnull','nusall','nudasll','nasdull')";
    //	String lLoginQuery="insert into TestTable(firstname, lastname, username, password) values( FirstName, Lastname,Username,password)";
		try{  
    		//Class.forName("com.mysql.jdbc.Driver");  
    		  
    		//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB","root","root");  
    		 

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
             String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
            conn=DriverManager.getConnection(url,"sa","Password@1");
    		//here sonoo is database name, root is username and password  
    		  
    		Statement stmt=(Statement) conn.createStatement();  
    		  
    		stmt.executeUpdate(lLoginQuery);  
    		JOptionPane.showMessageDialog(null, "successfully inserted");
    		
    		//stmt.executeQuery(lLoginQuery);
    		rslt.close();
    		
    		//System.out.println("successfully inserted");
    		
    		conn.close();  
    	//	return "successfully inserted";
    		}catch(Exception e){ System.out.println(e);} }
}
