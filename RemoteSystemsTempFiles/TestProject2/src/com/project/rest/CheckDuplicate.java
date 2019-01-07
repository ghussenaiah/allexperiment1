package com.project.rest;


import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;


@Path("/npd11")
public class CheckDuplicate {

	Connection conn;
    ResultSet rslt;
    String Vuser ="Green";
    String Iuser="Red";
    Statement stmt;
    PreparedStatement pst;
    
	String name;
    String name1;
    @Path("/npd22")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String LoginUser(@QueryParam("la") String LastName,@QueryParam("user2") String Username,@QueryParam("pid1") String PID,
			
			@QueryParam("pname1") String CategoryID,@QueryParam("month1") String Month) throws SQLException
   {
    
   // 	public String LoginUser() throws SQLException
      //  {
       
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
          // String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           String url="jdbc:sqlserver://IE1FVWISOP016\\SQLSER2008R2;databaseName=TestDB";
          conn=DriverManager.getConnection(url,"sa","Password@1");
          
          //String Username="user3";
        // String PID="3";
         // String CategoryID="C4";
         // String Month="January";
         
        //  String sql ="Insert into ProjectDetails values ('" + Projectdesc + "','" +Vam + "','" +Owner+ "')";
          String sql="select Status from SUserTable3 where Username='"+Username+"' and PID='"+PID+"' and CategoryID='"+CategoryID+"' and Month='"+Month+"'";
     
         //java.sql.PreparedStatement pst=conn.prepareStatement(sql);
         
    
          stmt = conn.createStatement();



//int n1=pst.executeUpdate();
             ResultSet res = stmt.executeQuery(sql);
             int count = 0;
            
                  while(res.next())
                      {
                         count = count + 1;
                	 name= res.getString("Status");
                	 System.out.println("name is"+name);
                	
                      }
                  name1=name.trim();
                             
                  //if(count >= 1 && name=="Green")
               //      if( name1 !="Green")
                    	if( Vuser.equalsIgnoreCase(name1))
                            { 
                    	  System.out.println("count1"+count);
                    	  System.out.println("username1"+Username);
                     	 System.out.println("pid1"+PID);
                     	 System.out.println("cid1"+CategoryID);
                     	 System.out.println("month1"+Month);
             	         //  return Vuser;
             	          return Vuser;
                            }
                        else
                                  {
                        	
             	             //return "mass1";
                        	 //String n1=Integer.toString(count);
                        	 System.out.println("count"+count);
                       	  System.out.println("username"+Username);
                        	 System.out.println("pid"+PID);
                        	 System.out.println("cid"+CategoryID);
                        	 System.out.println("month"+Month);
                        	  // return "Green";
                        	  // return Iuser;
                        	   return "red11";
                        	 //return n1;
                             }
                 
 
       }catch(Exception e){
    	   System.out.println(e);
       }
    
      return "Red1";  

       
}
	
	
}

