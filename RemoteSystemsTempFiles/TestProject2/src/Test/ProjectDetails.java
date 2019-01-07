package Test;
import java.sql.*;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;


@Path("/p11")
public class ProjectDetails {

	Connection conn;
    ResultSet rslt;
    String Vuser ="Valid";
    String Iuser="Invalid";
    Statement stmt;
    PreparedStatement pst;
    
	
    
    @Path("/p22")
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    
    
    public String LoginUser(@QueryParam("la") String LastName,@QueryParam("prodesc") String Projectdesc,
			@QueryParam("vam") String Vam,@QueryParam("owner") String Owner,
			@QueryParam("pid1") String PID,@QueryParam("month1") String Month,
			@QueryParam("status") String Status,@QueryParam("use2") String Username,
			@QueryParam("pname1") String ParameterName) throws SQLException
    {
    
 
       
       try{
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 
           String url="jdbc:sqlserver://199.63.10.69\\SQLSER2008R2;databaseName=TestDB"; 
           
          conn=DriverManager.getConnection(url,"sa","Password@1");
         
        //  String sql ="Insert into ProjectDetails values ('" + Projectdesc + "','" +Vam + "','" +Owner+ "')";
          String sql="INSERT INTO SProjectDetails (ProjectDescription,Vam,Owner,PID,Month,Status,Username,ParameterName) VALUES (?,?,?,?,?,?,?,?)";
     
         java.sql.PreparedStatement pst=conn.prepareStatement(sql);
       
pst.setString(1, Projectdesc);       
pst.setString(2, Vam);
pst.setString(3, Owner);
pst.setString(4, PID);
pst.setString(5, Month);
pst.setString(6, Status);
pst.setString(7, Username);
pst.setString(8, ParameterName);

int n1=pst.executeUpdate();
if(n1>0)
    {
	System.out.println(Projectdesc);
	  System.out.println(Vam);
	  System.out.println(Owner);
        	 return Vuser;
        	
          }
          else
          {
        	  System.out.println(Projectdesc);
        	  System.out.println(Vam);
        	  System.out.println(Owner);
        	return Iuser;
          }
 
       }catch(Exception e){
    	   System.out.println(e);
       }
    
      return Iuser;  

       
}
	
	
}
