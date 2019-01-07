package com.project.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/t1")
public class Example {

	
	  @Path("/t2")
	  @GET
	  public String Exam(String name)
	  {
	  
		   return "welcome Honey";
	  }
	  @Path("/t3")
	  @GET
	  public String Exam1(String name)
	  {
	  
		   return "welcome to Honeywell";
	  }
}