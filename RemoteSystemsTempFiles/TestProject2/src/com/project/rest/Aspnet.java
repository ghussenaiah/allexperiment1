package com.project.rest;

import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;




@Path("/d1")
public class Aspnet {

	
	 

	@Path("/d2")
	 /* @GET
	 public String Exam(String name)
	 {
	  
		   return "welcome Honey";
	 }
	  */
@POST
@Produces(MediaType.TEXT_HTML)  
	    
//public String Login(@QueryParam("name1") String UserName,@QueryParam("pwd1") String PassWord ) throws SQLException
public String Login(@QueryParam("name1") String UserName,@QueryParam("pwd1") String PassWord,@QueryParam("la") String Lastname) throws SQLException
	    {
		//String name = "hello" + " " + "hai";
		String name = UserName + " " + PassWord+ " "+Lastname;
		  System.out.println("Username is"+ UserName);
		  System.out.println("Password is"+ PassWord);
		return name;
		
	 
	// return PassWord;
		 
	    }
}
