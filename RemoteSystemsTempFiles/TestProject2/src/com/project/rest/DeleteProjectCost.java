/*package com.project.rest;

import java.sql.*;
import java.util.ArrayList;








//import javax.ws.rs.GET;


import java.util.Arrays;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import pojo.UserVO;










import com.mysql.jdbc.PreparedStatement;

//import java.sql.*;
@Path("/del1")
public class DeleteProjectCost {
	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    String res;
  
    
   @Path("/del2")
    
    @GET
   @Produces(MediaType.TEXT_HTML)
    
    
   // public ArrayList<UserVO> Del() throws SQLException
   // public ArrayList<String> Del() throws SQLException
    public String Del() throws SQLException
    {
    	//ArrayList<UserVO> userList = new ArrayList<UserVO>();
 
    //	ArrayList<String> userList = new ArrayList<String>();
	 Integer[] toppings = new Integer[1000];
    	 int i=0;
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           
          conn=DriverManager.getConnection(url,"sa","Password@1");
     
          String sql ="select * from ProjectCost";
         java.sql.PreparedStatement pst= conn.prepareStatement(sql);
    
          
       
       
   
       
          ResultSet rs1=pst.executeQuery();
          while(rs1.next())
          {
        	  
         // UserVO uservo = new UserVO();
        	//  uservo.setCost(rs1.getInt("Cost"));
        	toppings[i++] = rs1.getInt("Cost");
        	System.out.println("project cost"+toppings[i++]);
        	// Integer al=rs1.getInt("Cost");
        	 // userList.add(al);
        	 // uservo.setPassword(rs1.getString("password"));
        	//  userList.add(uservo);
          } 
          
          res = Arrays.toString(toppings);
          System.out.println(res);
          //userList.add(res);
        //  String dsf[] = new String[userList.size()];              
        //  for(int i =0;i<userList.size();i++){
        //    dsf[i] = userList.get(i);
          
 
           }catch(Exception e){
    	   System.out.println(e);
       }
    return res;
     //  return userList;
}
} */
