package java4s;

import java.sql.*;  
public class Proc {  
public static void main(String[] args) throws Exception{  
  
	 Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","aa","root");
    
     System.out.println("connection established successfully...!!");    
  
//CallableStatement stmt=con.prepareCall("{call insertt(?,?)}");  
//stmt.setInt(1,1011);  
//stmt.setString(2,"Amit");
   //  stmt.execute(); 
     //----------------------------------------------------------------------------------------------
   //  int id=2;
   //  String name="rahim";
  //   String sql1 = "INSERT INTO user420(id,name) VALUES (?,?)";
     //----------------------------------------------------------------------------------
     int wid=2;
      String outlook="rahim";
      String temp="rahim";
      String humidity="rahim";
      String windy="rahim";
      String play="rahim";
     String sql1 = "INSERT INTO weather(wid,outlook,temp,humidity,windy,play) VALUES (?,?,?,?,?,?)";
     PreparedStatement pstmt1 = con.prepareStatement(sql1);
     pstmt1.setInt(1, wid);
     pstmt1.setString(2, outlook);
     pstmt1.setString(3, temp);
     pstmt1.setString(4, humidity);
     pstmt1.setString(5, windy);
     pstmt1.setString(6, play); 

    // pstmt1.executeQuery(); 
System.out.println("success");  
System.out.println(con); 
}  
}  