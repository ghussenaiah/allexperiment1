package com.project.rest;

import java.sql.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.Properties;  

import javax.mail.*;  
import javax.mail.internet.*;  

import com.mysql.jdbc.PreparedStatement;
@Path("/send1")
public class SendMail1 {
	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    
	
    
    @Path("/send2")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String MileStone(@QueryParam("la") String LastName,@QueryParam("mailid") String Mailid,@QueryParam("proid1") String Projectid,@QueryParam("pname2") String Projectname,
			@QueryParam("uname1") String Username,@QueryParam("para1") String Parameterid,@QueryParam("sta1") String Status,@QueryParam("month1") String Month) throws SQLException
    {
       	//String to="ghussenaiah@gmail.com";
    	String to=Mailid;
    	  //Get the session object  
    	  Properties props = new Properties();  
    	  props.put("mail.smtp.host", "smtp.gmail.com");  
    	  props.put("mail.smtp.socketFactory.port", "465");  
    	  props.put("mail.smtp.socketFactory.class",  
    	            "javax.net.ssl.SSLSocketFactory");  
    	  props.put("mail.smtp.auth", "true");  
    	  props.put("mail.smtp.port", "465");  
    	  
       	  Session session = Session.getDefaultInstance(props,  
    	   new javax.mail.Authenticator() {  
    	   protected PasswordAuthentication getPasswordAuthentication() {  
    	   return new PasswordAuthentication("ghussenaiah@gmail.com","WANAparthy@544");//change accordingly  
    	   }  
    	  });  
    	   
    	  //compose message  
    	  try {  
    	   MimeMessage message = new MimeMessage(session);  
    	   message.setFrom(new InternetAddress("ghussenaiah@gmail.com"));//change accordingly  
    	   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
    	   message.setSubject("Organisation Review DashBoard");  
    	   message.setText("Mr.'"+Username+"'"
    	   		+ " Your are Not Updated The ProjectId '"+Projectid+"'"
    	   		+ " ProejctName'"+Projectname+"'"
    	   		+ "  Parameterid'"+Parameterid+"'"
    	   		+ "In the Month of '"+Month+"'"
    	   		+ "Try to update the status as soon as possible "
    	   		+ "Thanks");  
    	     
    	   //send message  
    	   Transport.send(message);  
    	  
    	   System.out.println("message sent successfully");  
    	   
    	  } catch (MessagingException e) {throw new RuntimeException(e);}  
    	   
    	  
       


      return Iuser;  

       
}
}