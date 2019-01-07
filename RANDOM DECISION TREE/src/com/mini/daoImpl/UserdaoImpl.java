package com.mini.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import com.mini.beans.QueryTo;
import com.mini.beans.RegisterTo;
import com.mini.beans.SolutionTo;
import com.mini.dbutil.DBConnectionFactory;
import com.mini.dbutil.SqlConstants;
import com.mini.exception.ConnectionException;

public class UserdaoImpl {

	Connection con;
	PreparedStatement pstmt, pstmt1, pstmt2, pstmt3, pstmt4, pstmt5, pstmt6,
			pstmt11, pstmt12, pstmt13, pstmt14, pstmt7, pstmt8, pstmt9,
			pstmt10, pstmt100;
	Statement st, stmt;
	ResultSet rs, rs1, rs2, rs3, rs6, rs7, rs8, rs9, rs10, rs11,rs4,rs5,rs12;
	String q1 = null, q2 = null, q3 = null, q4 = null, q5 = null;
	
	
	

	public void closeConnection() throws ConnectionException {
		try {

			if (pstmt != null)
				pstmt.close();

			if (con != null)
				con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new ConnectionException(
					"Some Problem Occured during the closing connections");
		}
	}



	public boolean insertDoctorDetails(RegisterTo rto)
			throws ConnectionException

	{
		boolean flag = true;
		int pno = 0;

		try {
			con = DBConnectionFactory.getConnection();

			System.out.println("in registerDAO connection is ." + con);

			pstmt2 = con
					.prepareStatement("select userid from users where username=? ");
			System.out.println(" query username is @@@@@ " + rto.getUsername());
			pstmt2.setString(1, rto.getUsername());
			rs2 = pstmt2.executeQuery();

			int uid = 0;
			int uid1 = 0;
			while (rs2.next()) {
				uid = rs2.getInt(1);
				System.out.println(" uid in query @@@@@@" + uid);
			}

			pstmt3 = con
					.prepareStatement("select userid  from doct where  userid=? ");

			pstmt3.setInt(1, uid);
			rs3 = pstmt3.executeQuery();
			while (rs3.next()) {
				uid1 = rs3.getInt(1);
				System.out.println(" uid1 in query @@@@@@" + uid);
			}
			if (uid1 == 0) {

				pstmt1 = con.prepareStatement(SqlConstants._INSERT_DOCQUERY);

				pstmt1.setInt(1, uid);
				pstmt1.setInt(2, rto.getExp());
				pstmt1.setString(3, rto.getSpl());

				int i = pstmt1.executeUpdate();

				if (i != 0) {
					flag = true;
				}

			} else
				flag = false;
		} catch (SQLException e) {
			throw new ConnectionException(
					"problem occured during post the query to admin");

		}

		return flag;
	}

	public Vector<RegisterTo> viewDoctorProfile(RegisterTo rto)
			throws ConnectionException {

		Vector<RegisterTo> tsb = null;
		tsb = new Vector<RegisterTo>();

		try {
			con = DBConnectionFactory.getConnection();
			RegisterTo b1 = null;

			System.out.println("in registerDAO connection i" + con);

			pstmt2 = con
					.prepareStatement("select userid from users where username=?");
			System.out.println(" query username is @@@@ " + rto.getUsername());

			pstmt2.setString(1, rto.getUsername());
			rs2 = pstmt2.executeQuery();
			int uid = 0;
			while (rs2.next()) {
				uid = rs2.getInt(1);
				System.out.println(" uid in query" + uid);
			}

			pstmt3 = con.prepareStatement(SqlConstants._GETDOCDETAILS);
			pstmt3.setInt(1, uid);
			rs3 = pstmt3.executeQuery();
			while (rs3.next()) {
				b1 = new RegisterTo();
				b1.setUid(rs3.getInt(1));

				b1.setSpl(rs3.getString(2));
				b1.setExp(rs3.getInt(3));

				tsb.add(b1);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();

			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return tsb;

	}

	public boolean insw(RegisterTo rto)
	throws ConnectionException

{
boolean flag = true;
int pno = 0;

try {
	con = DBConnectionFactory.getConnection();

	System.out.println("in weahter add detailsDAO connection is ." + con);

	pstmt2 = con
			.prepareStatement("select userid from users where username=? ");
	System.out.println(" query username is @@@@@ " + rto.getUsername());
	pstmt2.setString(1, rto.getUsername());
	rs2 = pstmt2.executeQuery();

	int uid = 0;
	int uid1 = 0;
	while (rs2.next()) {
		uid = rs2.getInt(1);
		System.out.println(" uid in query @@@@@@" + uid);
	}

	
	

		pstmt1 = con.prepareStatement("insert into weather values((select nvl(max(wid),800)+1 from weather),?,?,?,?,?)");
		

		     
		pstmt1.setString(1, rto.getOut());
		pstmt1.setString(2, rto.getTmp());
		pstmt1.setString(3, rto.getHum());
		
		pstmt1.setString(4, rto.getWind());
		
	
		pstmt1.setString(5, rto.getPlay());

		int i = pstmt1.executeUpdate();

		if (i != 0) {
			flag = true;
		}

	
} catch (SQLException e) {System.out.println(e);
	throw new ConnectionException(
			"problem occured during  insert details  to database");

}

return flag;
}	

	
	public Vector<RegisterTo> viewSelectedData(RegisterTo rto)
	throws ConnectionException {

Vector<RegisterTo> tsb = null;
tsb = new Vector<RegisterTo>();

try {
	con = DBConnectionFactory.getConnection();
	RegisterTo b1 = null;

	System.out.println("in registerDAO connection i" + con);

	pstmt2 = con
			.prepareStatement("select userid from users where username=?");
	System.out.println(" query username is @@@@ " + rto.getUsername());

	pstmt2.setString(1, rto.getUsername());
	rs2 = pstmt2.executeQuery();
	int uid = 0;
	while (rs2.next()) {
		uid = rs2.getInt(1);
		System.out.println(" uid in query" + uid);
	}
           int i=0,n=0,y=0;
	pstmt3 = con.prepareStatement(" select play from weather where outlook=? and temp=? and humidity=? and windy=?");
	pstmt3.setString(1, rto.getOut());
	pstmt3.setString(2, rto.getTmp());
	pstmt3.setString(3, rto.getHum());
	pstmt3.setString(4, rto.getWind());
	rs3 = pstmt3.executeQuery();
	b1 = new RegisterTo();
	while (rs3.next()) {
		
		i++;
		
		
       if("yes".equalsIgnoreCase(rs3.getString(1)))
       {
    	   y++;
       }
       else
       {
    	n++;   
       }
      
       
       
       
		
		
		

	}
	
	
	
	
	 b1.setYes(y);
     b1.setNo(n);
     
     b1.setOut(rto.getOut());
     b1.setHum(rto.getHum());
     b1.setTmp(rto.getTmp());
     b1.setWind(rto.getWind());
     tsb.add(b1);
     System.out.println(" size is---->> "+tsb.size());
}

catch (SQLException e) {
	e.printStackTrace();

	try {
		con.rollback();
	} catch (SQLException se) {
		se.printStackTrace();
	}
}

finally {
	try {
		if (con != null)
			con.close();
	} catch (SQLException e) {
	}
}
return tsb;

}

	
	
	public Vector<RegisterTo> viewSelectedGroupData(RegisterTo rto)
	throws ConnectionException {

Vector<RegisterTo> tsb = null;
Vector<RegisterTo> tsb1 = null;
Vector<RegisterTo> tsb2 = null;
tsb = new Vector<RegisterTo>();
tsb1 = new Vector<RegisterTo>();
tsb2= new Vector<RegisterTo>();
try {
	con = DBConnectionFactory.getConnection();
	RegisterTo b1 = null;
	RegisterTo b2=null;

	System.out.println("in registerDAO connection i" + con);

	pstmt2 = con
			.prepareStatement("select userid from users where username=?");
	System.out.println(" query username is @@@@ " + rto.getUsername());

	pstmt2.setString(1, rto.getUsername());
	rs2 = pstmt2.executeQuery();
	int uid = 0;
	while (rs2.next()) {
		uid = rs2.getInt(1);
		System.out.println(" uid in query" + uid);
	}
           int full=0,n=0,y=0,half=0,k=0,i=0,j=0,y1=0,n1=0;
           
        pstmt4 = con.prepareStatement(" select * from weather ");
        rs4 = pstmt4.executeQuery();
        while(rs4.next())
        {
        	full++;
        }
          half=full/2; 
          
          System.out.println(" half is "+ half+ " full is   "+ full);
           
          pstmt3 = con.prepareStatement( "select e1.play from  (select e.*  from (select play,rownum r,outlook,temp,humidity,windy from weather)e     where r >=  1 and r <= ? )e1 where  e1.outlook=? and e1.temp=? and e1.humidity=? and e1.windy=? ");
        //  select e1.play from  (select e.*  from (select play,rownum r,outlook,temp,humidity,windy from weather)e     where r >=  1 and r <= ? )e1 where  e1.outlook=? and e1.temp=? and e1.humidity=? and e1.windy=? "select e1.play from  (select e.*  from (select play,rownum r,outlook,temp,humidity,windy from weather)e     where r >=  1 and r <= ? )e1 where  e1.outlook=? and e1.temp=? and e1.humidity=? and e1.windy=? "
         
       	pstmt3.setInt(1, half);
          
          pstmt3.setString(2, rto.getOut());
      	pstmt3.setString(3,  rto.getTmp());
      	pstmt3.setString(4, rto.getHum());
      	pstmt3.setString(5, rto.getWind());
      	
      	rs3 = pstmt3.executeQuery();
	
	
      	b1 = new RegisterTo();
	
	while (rs3.next()) {
		
	
		i++;
		
		
		
		
		
       if("yes".equalsIgnoreCase(rs3.getString(1)))
       {
    	   y++;
       }
       else
       {
    	n++;   
       }
      
		
		
	}

	System.out.println(   " yes "+y +"---- no----"+n);
	
	

	
	
	
	 b1.setYes(y);
     b1.setNo(n);
    
     b1.setOut(rto.getOut());
     b1.setHum(rto.getHum());
     b1.setTmp(rto.getTmp());
     b1.setWind(rto.getWind());
     tsb1.add(b1);
     
     
   
     
     
     
     
     pstmt5 = con.prepareStatement( "select e1.play from  (select e.*  from (select play,rownum r,outlook,temp,humidity,windy from weather)e     where r >=  ? and r <= ? )e1 where  e1.outlook=? and e1.temp=? and e1.humidity=? and e1.windy=? ");
 	
     pstmt5.setInt(1, half);
  	pstmt5.setInt(2, full);
     
     pstmt5.setString(3, rto.getOut());
 	pstmt5.setString(4,  rto.getTmp());
 	pstmt5.setString(5, rto.getHum());
 	pstmt5.setString(6, rto.getWind());
 	
 	rs5 = pstmt5.executeQuery();
 	
	
 	 b2 = new RegisterTo();
		
 	    while (rs5.next()) {
 		
 	    	
 	    	
		i++;
		
		
		
		
		
       if("yes".equalsIgnoreCase(rs5.getString(1)))
       {
    	   y1++;
       }
       else
       {
    	n1++;   
       }
      
 	}
 	System.out.println(   " yes1 "+y1 +" ----- no1----"+n1);
 	
 	
     
 	  b2.setYes1(y1);
      b2.setNo1(n1);
     
      b2.setOut(rto.getOut());
      b2.setHum(rto.getHum());
      b2.setTmp( rto.getTmp());
      b2.setWind(rto.getWind());
     
      tsb2.add(b2);
   
      
      
      
      
      
      tsb.addAll(tsb1);
      tsb.addAll(tsb2);
     
     System.out.println("size of tsb is"+tsb.size());
     
     
     
     
     
     
     
     
}

catch (SQLException e) {
	e.printStackTrace();

	try {
		con.rollback();
	} catch (SQLException se) {
		se.printStackTrace();
	}
}

finally {
	try {
		if (con != null)
			con.close();
	} catch (SQLException e) {
	}
}
return tsb;

}

	public Vector<RegisterTo> viewSelectedVData(RegisterTo rto)
	throws ConnectionException {

Vector<RegisterTo> tsb = null;
tsb = new Vector<RegisterTo>();

try {
	con = DBConnectionFactory.getConnection();
	RegisterTo b1 = null;

	System.out.println("in registerDAO connection i" + con);

	pstmt2 = con
			.prepareStatement("select userid from users where username=?");
	System.out.println(" query username is @@@@ " + rto.getUsername());

	pstmt2.setString(1, rto.getUsername());
	rs2 = pstmt2.executeQuery();
	int uid = 0;
	while (rs2.next()) {
		uid = rs2.getInt(1);
		System.out.println(" uid in query" + uid);
	}
	
   String s1=	rto.getS1();
   String s2=	rto.getS2();
	
           int i=0,n=0,y=0;
           
     pstmt3 = con.prepareStatement(" select play from weather where outlook=? and humidity=? ");
	 pstmt3.setString(1, rto.getOut());
	
	 pstmt3.setString(2, rto.getHum());
	
	rs3 = pstmt3.executeQuery();
	b1 = new RegisterTo();
	 while (rs3.next()) {
		
		i++;
		
		
       if("yes".equalsIgnoreCase(rs3.getString(1)))
       {
    	   y++;
       }
       else
       {
    	n++;   
       }
      
       
       
       
		
		
		

	}
	
	
	
	
	 b1.setYes(y);
     b1.setNo(n);
     
     b1.setOut(rto.getOut());
     b1.setHum(rto.getHum());
     b1.setTmp(rto.getTmp());
     b1.setWind(rto.getWind());
     tsb.add(b1);
     
     
     System.out.println(" size is---->> "+tsb.size()+" "+y+" "+n+" "   );
    
           
           
           
           
               
           
           
           
           
           
}

catch (SQLException e) {
	System.out.println(e);

}



return tsb;

}

	public Vector<RegisterTo> viewSelectedDataVG(RegisterTo rto)
	throws ConnectionException {

Vector<RegisterTo> tsb = null;
tsb = new Vector<RegisterTo>();

try {
	con = DBConnectionFactory.getConnection();
	RegisterTo b1 = null;

	System.out.println("in registerDAO connection i" + con);

	pstmt2 = con
			.prepareStatement("select userid from users where username=?");
	System.out.println(" query username is @@@@ " + rto.getUsername());

	pstmt2.setString(1, rto.getUsername());
	rs2 = pstmt2.executeQuery();
	int uid = 0;
	while (rs2.next()) {
		uid = rs2.getInt(1);
		System.out.println(" uid in query" + uid);
	}
           int i=0,n=0,y=0;
	pstmt3 = con.prepareStatement(" select play from weather where outlook=? and temp=?");
	pstmt3.setString(1, rto.getOut());
	pstmt3.setString(2, rto.getTmp());
	pstmt3.setString(3, rto.getHum());
	pstmt3.setString(4, rto.getWind());
	rs3 = pstmt3.executeQuery();
	b1 = new RegisterTo();
	while (rs3.next()) {
		
		i++;
		
		
       if("yes".equalsIgnoreCase(rs3.getString(1)))
       {
    	   y++;
       }
       else
       {
    	n++;   
       }
      
       
       
       
		
		
		

	}
	
	
	
	
	 b1.setYes(y);
     b1.setNo(n);
     
     b1.setOut(rto.getOut());
     b1.setHum(rto.getHum());
     b1.setTmp(rto.getTmp());
     b1.setWind(rto.getWind());
     tsb.add(b1);
     System.out.println(" size is---->> "+tsb.size());
}

catch (SQLException e) {
	e.printStackTrace();

	try {
		con.rollback();
	} catch (SQLException se) {
		se.printStackTrace();
	}
}

finally {
	try {
		if (con != null)
			con.close();
	} catch (SQLException e) {
	}
}
return tsb;

}

	public Vector<RegisterTo> viewSelectedGroupDataV(RegisterTo rto)
	throws ConnectionException {

Vector<RegisterTo> tsb = null;
Vector<RegisterTo> tsb1 = null;
Vector<RegisterTo> tsb2 = null;
tsb = new Vector<RegisterTo>();
tsb1 = new Vector<RegisterTo>();
tsb2= new Vector<RegisterTo>();
try {
	con = DBConnectionFactory.getConnection();
	RegisterTo b1 = null;
	RegisterTo b2=null;

	System.out.println("in registerDAO connection i" + con);

	pstmt2 = con
			.prepareStatement("select userid from users where username=?");
	System.out.println(" query username is @@@@ " + rto.getUsername());

	pstmt2.setString(1, rto.getUsername());
	rs2 = pstmt2.executeQuery();
	int uid = 0;
	while (rs2.next()) {
		uid = rs2.getInt(1);
		System.out.println(" uid in query" + uid);
	}
           int full=0,n=0,y=0,half=0,k=0,i=0,j=0,y1=0,n1=0;
      
          pstmt3 = con.prepareStatement( "select play from weather where outlook=? and temp=? ");
       	
         
     
          
          pstmt3.setString(1, rto.getOut());
          pstmt3.setString(2,  rto.getTmp());
      	
      	
      	rs3 = pstmt3.executeQuery();
	
	
      	b1 = new RegisterTo();
	
	while (rs3.next()) {
		
	
		i++;
		
		
		
		
		
       if("yes".equalsIgnoreCase(rs3.getString(1)))
       {
    	   y++;
       }
       else
       {
    	n++;   
       }
      
		
		
	}

	System.out.println(   " yes "+y +"---- no----"+n);
	
	

	
	
	
	 b1.setYes(y);
     b1.setNo(n);
    
     b1.setOut(rto.getOut());
     b1.setTmp(rto.getTmp());
    
     tsb1.add(b1);
     
     
   
     
     
     
     
     pstmt5 = con.prepareStatement( "select play from weather where humidity=? and windy=?  ");
 	
    
     
    
 	pstmt5.setString(1, rto.getHum());
 	pstmt5.setString(2, rto.getWind());
 	
 	rs5 = pstmt5.executeQuery();
 	
	
 	 b2 = new RegisterTo();
		
 	    while (rs5.next()) {
 		
 	    	
 	    	
		i++;
		
		
		
		
		
       if("yes".equalsIgnoreCase(rs5.getString(1)))
       {
    	   y1++;
       }
       else
       {
    	n1++;   
       }
      
 	}
 	System.out.println(   " yes1 "+y1 +" ----- no1----"+n1);
 	
 	
     
 	  b2.setYes1(y1);
      b2.setNo1(n1);
     
    
      b2.setHum(rto.getHum());
      b2.setWind(rto.getWind());
     
      tsb2.add(b2);
   
      
      
      
      
      
      tsb.addAll(tsb1);
      tsb.addAll(tsb2);
     
     System.out.println("size of tsb is"+tsb.size());
     
     
     
     
     
     
     
     
}

catch (SQLException e) {
	e.printStackTrace();

	try {
		con.rollback();
	} catch (SQLException se) {
		se.printStackTrace();
	}
}

finally {
	try {
		if (con != null)
			con.close();
	} catch (SQLException e) {
	}
}
return tsb;

}
	public Vector<RegisterTo> viewSelectedVData1(RegisterTo rto)
	throws ConnectionException {

Vector<RegisterTo> tsb = null;
tsb = new Vector<RegisterTo>();

try {
	con = DBConnectionFactory.getConnection();
	RegisterTo b1 = null;

	System.out.println("in registerDAO connection i" + con);

	pstmt2 = con
			.prepareStatement("select userid from users where username=?");
	System.out.println(" query username is @@@@ " + rto.getUsername());

	pstmt2.setString(1, rto.getUsername());
	rs2 = pstmt2.executeQuery();
	int uid = 0;
	while (rs2.next()) {
		uid = rs2.getInt(1);
		System.out.println(" uid in query" + uid);
	}
	
   String s1=	rto.getS1();
   String s2=	rto.getS2();
	
           int i=0,n=0,y=0;
           
     pstmt3 = con.prepareStatement(" select play from weather where temp=? and windy=? ");
	 pstmt3.setString(1, rto.getTmp());
	
	 pstmt3.setString(2, rto.getWind());
	
	rs3 = pstmt3.executeQuery();
	b1 = new RegisterTo();
	 while (rs3.next()) {
		
		i++;
		
		
       if("yes".equalsIgnoreCase(rs3.getString(1)))
       {
    	   y++;
       }
       else
       {
    	n++;   
       }
      
       
       
       
		
		
		

	}
	
	
	
	
	 b1.setYes(y);
     b1.setNo(n);
     
     b1.setOut(rto.getOut());
     b1.setHum(rto.getHum());
     b1.setTmp(rto.getTmp());
     b1.setWind(rto.getWind());
     tsb.add(b1);
     
     
     System.out.println(" size is---->> "+tsb.size()+" "+y+" "+n+" "   );
    
           
           
           
           
               
           
           
           
           
           
}

catch (SQLException e) {
	System.out.println(e);

}



return tsb;

}
	
	public boolean  mkey(RegisterTo rto)
	throws ConnectionException {

Vector<RegisterTo> tsb = null;
tsb = new Vector<RegisterTo>();
boolean flag=false;
try {
	
	
	String name="";
	RegisterTo tsb1=new RegisterTo();
	name=rto.getUsername();
	String key=rto.getMkey();
	con = DBConnectionFactory.getConnection();
	RegisterTo b1 = null;
System.out.println(" username is"+name);
	System.out.println("in registerDAO connection i" + con);

	pstmt2 = con.prepareStatement("select key from users where username=?");
	
	System.out.println(" query username is @@@@ " + rto.getUsername());

	
	
	pstmt2.setString(1,name);
	
	
	rs2 = pstmt2.executeQuery();
	int uid = 0;
	String dbkey=null;
	while (rs2.next()) {
		dbkey=rs2.getString(1);
		
		System.out.println("***************"+rs2.getString(1));
	}
	
	if(key.equalsIgnoreCase(dbkey.trim()))
	{
		
		flag=true;
		
	}
	else
	{
		flag=false;
	}
	
	
	
	
}
catch (SQLException e) {
	e.printStackTrace();

	try {
		con.rollback();
	} catch (SQLException se) {
		se.printStackTrace();
	}
}


return flag;

}
	
}