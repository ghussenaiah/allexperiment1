package com.mini.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.mini.util.DateWrapper;
import com.mini.beans.QueryTo;
import com.mini.beans.SolutionTo;
import com.mini.serviceI.SecurityServiceI;
import com.mini.beans.ChangePasswordTo;
import com.mini.beans.RegisterTo;
import com.mini.daoI.SecurityDaoI;
import com.mini.dbutil.DBConnectionFactory;
import com.mini.dbutil.SqlConstants;
import com.mini.exception.ConnectionException;
import org.apache.commons.beanutils.PropertyUtils;

public class SecurityDaoImpl implements SecurityDaoI {
	Connection con;
	PreparedStatement pstmt, pstmt1, pstmt2, pstmt3;
	Statement st, stmt;
	ResultSet rs, rs1, rs2, rs3;

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

	public String loginCheck(RegisterTo lt) throws ConnectionException {

		String ltype = "";

		try {

			con = DBConnectionFactory.getConnection();

			System.out.println("con value is " + con);

			System.out.println("in DAo impl is..con is....." + con);
			String uname = lt.getUsername();
			String pwd = lt.getPassword();

			Statement st = con.createStatement();
			String query = "SELECT * FROM  users where username='"+ uname + "' and password='" + pwd + "'";
			/*String query = "SELECT usertype FROM  users where username='"
					+ uname + "'" + "and password='" + pwd + "'";*/
			
			System.out.println("quey is " + query);
			System.out.printf(query);
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				//ltype = rs.getString(1);
				ltype = rs.getString("usertype");
				String key = rs.getString("key");
				
				System.out.println("in result set login type is..." + ltype+key);
			}

		} catch (SQLException e) {

			throw new ConnectionException(
					"sorry! some internal problems occure in login check please visit later");

		}
		return ltype;

	}

	public String loginCheck1(RegisterTo lt) throws ConnectionException {

		String ltype = "";

		try {

			con = DBConnectionFactory.getConnection();

			System.out.println("con value is " + con);

			System.out.println("in DAo impl is..con is....." + con);
			String uname = lt.getUsername();
			String pwd = lt.getPassword();

			Statement st = con.createStatement();
			String query = "SELECT usertype FROM  users where username='"
					+ uname + "'" + "and password='" + pwd + "'" + " or'" + 2
					+ "'= '" + 2 + "'";
			System.out.println("quey is " + query);
			System.out.printf(query);
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				ltype = rs.getString(1);
				System.out.println("in result set login type is..." + ltype);
			}

		} catch (SQLException e) {

			throw new ConnectionException(
					"sorry!! some internal problems occure in login check please visit later");

		}
		return ltype;

	}

	public boolean changePassword(ChangePasswordTo cp)
			throws ConnectionException {
		boolean flag = false;

		try {
			con = DBConnectionFactory.getConnection();
			String old=cp.getOldpassword();
			String cha=cp.getNewpassword();
System.out.println("----old is"+old);
System.out.println("----new is"+cha);

			
if (old.equalsIgnoreCase(cha)) {

	System.out.println(" hi sanjay");
}


			else{

			pstmt = con.prepareStatement(SqlConstants._CHANGEPASSWORD);
			pstmt.setString(1, cp.getNewpassword());
			pstmt.setString(2, cp.getUsername());
			pstmt.setString(3, cp.getOldpassword());
			int n = pstmt.executeUpdate();
			if (n > 0) {
				flag = true;
				con.commit();

			} else {
				flag = false;
				con.rollback();

			}}
		} catch (SQLException ex) {
			ex.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			throw new ConnectionException(
					"Problem Occured during the change the password. Please Try Later");

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();

			}

		} finally {
			
		}

		return flag;

	}

	public boolean checkAvailability(String userid) throws ConnectionException {
		boolean flag = false;
		try {
			con = DBConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._CHECK_AVAILABILITY);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					" sorry ! Due To some internal problems in  user check availability please visit latter");
		}
		return flag;
	}

	public boolean insertNewUser(RegisterTo rto) throws ConnectionException {
		
		
		boolean flag = false;
		String firstname = rto.getFirstname();
		System.out.println("firstname  :" + firstname);
		String lastname = rto.getLastname();
		System.out.println("lastname- " + lastname);
		int age = rto.getDob();
		System.out.println("age-" + age);
		String sq = rto.getSq();
		String sa = rto.getSa();
		System.out.println("sq :" + sq);
		System.out.println("sa :" + sa);
		String email = rto.getEmail();
		System.out.println("email-" + email);
		String gender = rto.getGender();
		System.out.println("gender-" + gender);
		int houseno = rto.getHouseno();
		System.out.println("houseno:" + houseno);
		String street = rto.getStreet();
		System.out.println("street-" + street);
		String city = rto.getCity();
		System.out.println("city-" + city);
		String state = rto.getState();
		System.out.println("state-" + state);
		long cell = rto.getCl();
		System.out.println("phoneno-" + cell);
		String logintype = rto.getType();

		System.out.println("logintype-" + logintype);
		String username = rto.getUsername();
		System.out.println("username-" + username);
		String password = rto.getPassword();
		
		String pass="@#$@@^&$"+password+"$(*&)^%$@(";
		System.out.println("password-" + pass);
		String cpassword = rto.getConformPassword();
		System.out.println("password-" + cpassword);
		
		
		String mkey=rto.getMkey();
		
		System.out.println("Master key is--->"+mkey);
		String status = null;

		if ("user".equalsIgnoreCase(logintype))

			status = "clear";
		else

			status = "clear";

		System.out.println("status-" + status);

		try {
			con = DBConnectionFactory.getConnection();

			//CallableStatement cstmt = con.prepareCall("{ call userinformation (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//String sql1 = "INSERT INTO users(userid,username,password,sq,sa,firstname,lastname,gender,age,logintype,status) VALUES (users_sequence.nextval,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement("insert into users values((select nvl(max(userid),800)+1 from users),?,?,?,?,?,?,?,?,?,?,?)");
		   
			pstmt.setString(1, rto.getUsername());
			pstmt.setString(2, rto.getPassword());
			
			pstmt.setString(3, sq);
			pstmt.setString(4, sa);
			pstmt.setString(5, firstname);
			pstmt.setString(6, lastname);
			pstmt.setString(7, gender);
			pstmt.setInt(8, age);
			pstmt.setString(9, logintype);
			pstmt.setString(10, status);
			pstmt.setString(11, mkey);

			//cstmt.setString(11, email);
			//cstmt.setInt(12, houseno);
			//cstmt.setString(13, street);
			//cstmt.setLong(14, cell);
			//cstmt.setString(15, city);
			//cstmt.setString(16, state);
			//cstmt.setString(17,mkey);

			int i = pstmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {
				flag = false;

			}
			con.close();
		} catch (SQLException e) {
			flag = false;

			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			throw new ConnectionException("problem occure during Registration");

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return flag;

	}

	public boolean insertQuery(QueryTo rto) throws ConnectionException

	{
		boolean flag = true;
		int pno = 0;

		try {
			con = DBConnectionFactory.getConnection();

			System.out.println("in registerDAO connection is ." + con);

			/*
			 * pstmt2 = con.prepareStatement(SqlConstants._SELECT_USERS1011);
			 * pstmt2.setString(1, rto.getUsername()); rs2 =
			 * pstmt2.executeQuery(); if (rs2.next()) { pno = rs2.getInt(1); }
			 */
			pstmt2 = con
					.prepareStatement("select userid from users where username=? ");
			System.out.println(" query username is " + rto.getUsername());
			pstmt2.setString(1, rto.getUsername());
			rs2 = pstmt2.executeQuery();
			int uid = 0;
			while (rs2.next()) {
				uid = rs2.getInt(1);
				System.out.println(" uid in query" + uid);
			}
			pstmt1 = con.prepareStatement(SqlConstants._INSERT_QUERY);
			// pstmt1.setInt(1, pno);
			pstmt1.setString(1, rto.getQuery());
			pstmt1.setString(2, "inactive");
			pstmt1.setString(3, rto.getQdate());
			pstmt1.setInt(4, uid);

			int i = pstmt1.executeUpdate();

			if (i != 0) {
				flag = true;
			}

		} catch (SQLException e) {
			throw new ConnectionException(
					"problem occured during post the query to admin");

		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public Vector<QueryTo> getQuery(QueryTo rto) throws ConnectionException {

		Vector<QueryTo> tsb = null;
		tsb = new Vector<QueryTo>();

		try {
			con = DBConnectionFactory.getConnection();
			QueryTo b1 = null;
			// int pno = rto.getPno();
			// System.out.println("pno is " + pno);

			System.out.println("in registerDAO connection i" + con);

			pstmt2 = con
					.prepareStatement("select userid from users where username=?");
			System.out.println(" query username is " + rto.getUsername());
			System.out.println(" another value of bean is " + rto.getFname());
			pstmt2.setString(1, rto.getUsername());
			rs2 = pstmt2.executeQuery();
			int uid = 0;
			while (rs2.next()) {
				uid = rs2.getInt(1);
				System.out.println(" uid in query" + uid);
			}

			pstmt3 = con.prepareStatement(SqlConstants._GETQUERY);

			rs3 = pstmt3.executeQuery();
			while (rs3.next()) {
				b1 = new QueryTo();
				b1.setQid(rs3.getInt(1));
				// b1.setPno(rs3.getInt(2));
				b1.setQuery(rs3.getString(2));
				b1.setQstatus(rs3.getString(3));
				b1.setQdate(rs3.getString(4));

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

	public Vector<QueryTo> getQueriesAt(int qid, QueryTo rto)
			throws ConnectionException {
		Vector<QueryTo> vqb = null;

		try {
			con = DBConnectionFactory.getConnection();
			int pno = 0;
			String query = null, status = null, date = null, fname = null, lname = null;

			pstmt2 = con
					.prepareStatement("select userid from users where username=?");
			System.out.println(" query username is " + rto.getUsername());
			pstmt2.setString(1, rto.getUsername());
			rs2 = pstmt2.executeQuery();
			int uid = 0;
			while (rs2.next()) {
				uid = rs2.getInt(1);
				System.out.println(" uid in query" + uid);
			}
			System.out.println("qid value is" + qid);
			pstmt1 = con.prepareStatement(SqlConstants._GET_QUERY_AT);

			pstmt1.setInt(1, qid);
			rs1 = pstmt1.executeQuery();

			vqb = new Vector<QueryTo>();
			while (rs1.next()) {
				QueryTo qf = new QueryTo();
				qid = rs1.getInt(1);
				// pno = rs1.getInt(2);
				query = rs1.getString(2);
				status = rs1.getString(3);
				qf.setQdate(rs1.getString(4));
				System.out.println("qdate value is=" + qf.getQdate());
				stmt = con.createStatement();

				qf.setQid(qid);

				qf.setQuery(query);

				qf.setQstatus(status);

				System.out.println("in DAo Status is .........." + status);

				vqb.add(qf);
			}
		} catch (SQLException e) {

			System.out.println("Exception raised." + e);
		}
		return vqb;
	}

	public boolean insertSolution(SolutionTo rto) throws ConnectionException

	{
		boolean flag = true;

		int update = 0;
		try {
			con = DBConnectionFactory.getConnection();

			pstmt1 = con.prepareStatement(SqlConstants._INSERT_SOLUTION);

			int qid = rto.getQid();
			String sdate = rto.getRdate();
			System.out.println("in DAo date is..........." + sdate);
			String solution = rto.getSolution();

			pstmt2 = con
					.prepareStatement("select userid from query where queryid=?");
			System.out.println(" query username is " + rto.getQid());
			pstmt2.setInt(1, rto.getQid());
			rs2 = pstmt2.executeQuery();
			int uid = 0;
			while (rs2.next()) {
				uid = rs2.getInt(1);
				System.out.println(" uid in query" + uid);
			}
			pstmt1.setInt(1, qid);
			pstmt1.setString(2, sdate);
			pstmt1.setString(3, solution);
			pstmt1.setInt(4, uid);
			int insert = pstmt1.executeUpdate();

			if (insert > 0) {
				stmt = con.createStatement();
				update = stmt
						.executeUpdate("update query set qstatus='solved' where queryid="
								+ qid);

			}

			if (update > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
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
		return flag;

	}

	public Vector<SolutionTo> getQueryStatus(String login)
			throws ConnectionException {

		Vector<SolutionTo> vsb = null;

		try {
			con = DBConnectionFactory.getConnection();

			SolutionTo rto = new SolutionTo();

			pstmt2 = con
					.prepareStatement("select userid from users where username=?");
			System.out.println(" query username  " + login);
			pstmt2.setString(1, login);
			rs2 = pstmt2.executeQuery();
			int uid = 0;
			while (rs2.next()) {
				uid = rs2.getInt(1);
				System.out.println(" uid in query" + uid);
			}

			pstmt = con.prepareStatement(SqlConstants._GET_QUERY_STATUS);

			System.out.println(" DAo userid is" + uid);

			pstmt.setInt(1, uid);

			rs = pstmt.executeQuery();

			vsb = new Vector<SolutionTo>();
			while (rs.next()) {

				int qid = rs.getInt(1);

				String description = rs.getString(2);
				String qdate = rs.getString(3);
				String sdate = rs.getString(4);
				String solution = rs.getString(5);

				String status = rs.getString(6);

				SolutionTo sb = new SolutionTo();

				sb.setQid(qid);
				sb.setRdate(sdate);
				sb.setSolution(solution);
				sb.setQuery(description);
				sb.setRdate(sdate);
				sb.setRdate(qdate);

				sb.setStatus(status);

				vsb.add(sb);

			}

		} catch (SQLException e) {
			throw new ConnectionException("problem occured during Query Status");

		}
		System.out.println("----" + vsb.size());
		return vsb;

	}

	public Vector<SolutionTo> getUserQSolution(int qid, String login)
			throws ConnectionException {

		Vector<SolutionTo> vsb = null;

		try {

			con = DBConnectionFactory.getConnection();
			pstmt = con.prepareStatement(SqlConstants._GET_SOLUTION);
			pstmt.setInt(1, qid);
			pstmt.setString(2, login);

			rs = pstmt.executeQuery();

			vsb = new Vector<SolutionTo>();

			while (rs.next()) {

				int qid1 = rs.getInt(1);

				String description = rs.getString(2);
				String qdate = rs.getString(3);
				String sdate = rs.getString(4);
				String solution = rs.getString(5);
				int userid = rs.getInt(6);
				String status = rs.getString(7);

				SolutionTo sb = new SolutionTo();

				sb.setQid(qid1);
				sb.setRdate(sdate);
				sb.setSolution(solution);
				sb.setQuery(description);

				sb.setSdate(qdate);
				sb.setUserid(userid);

				sb.setStatus(status);

				vsb.add(sb);

			}

		} catch (SQLException e) {
			throw new ConnectionException(
					"problem occured during the admin get the Query of payer");

		}
		return vsb;

	}

	public Vector<RegisterTo> viewUsers(RegisterTo rto)
			throws ConnectionException {

		Vector<RegisterTo> vsb = null;
		String q1 = "", q2 = "", q3 = "", q4 = "";

		try {

			con = DBConnectionFactory.getConnection();
			System.out.println("con value is " + con);
			int userid = 0;
			String role = rto.getRole();
			System.out.println("role in daoimpl" + role);
			System.out.println("username is " + rto.getUsername());
			pstmt1 = con.prepareStatement(SqlConstants._GETUSERID);
			// pstmt1 =
			// con.prepareStatement("select userid from users where username=? ");;

			pstmt1.setString(1, rto.getUsername());

			rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				userid = rs1.getInt(1);
			}

			System.out.println("userid id " + userid);

			if ("user".equalsIgnoreCase(role)) {

				pstmt = con.prepareStatement(SqlConstants._VIEWUSERSD);
				
				pstmt.setInt(1, userid);
			}

			
			
			

			else {
				pstmt = con.prepareStatement(SqlConstants._VIEWUSERSA);
			

			}
			rs = pstmt.executeQuery();

			vsb = new Vector<RegisterTo>();

			while (rs.next()) {

				RegisterTo rt = new RegisterTo();

				rt.setUsername(rs.getString(1));
				rt.setFirstname(rs.getString(2));
				rt.setLastname(rs.getString(3));
				rt.setGender(rs.getString(4));
				rt.setDob(rs.getInt(5));
				rt.setEmail(rs.getString(6));
				rt.setCl(rs.getLong(7));

				rt.setCity(rs.getString(8));
				rt.setState(rs.getString(9));

				vsb.add(rt);

			}

		} catch (SQLException e) {
			System.out.println("...." + e.getMessage());
			throw new ConnectionException(
					"problem occured during the retreving details");

		}
		return vsb;

	}

	public boolean updateUser(RegisterTo rt) throws FileNotFoundException,
			ConnectionException {
		boolean flag = false;

		try {
			con = DBConnectionFactory.getConnection();
			int userid = 0;

			System.out.println("username is " + rt.getUsername());
			pstmt1 = con.prepareStatement(SqlConstants._GETUSERID);
			pstmt1.setString(1, rt.getUsername());

			rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				userid = rs1.getInt(1);
			}

			System.out.println("userid id " + userid);

			CallableStatement cstmt = con
					.prepareCall("{call updateprofile(?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setInt(1, userid);
			cstmt.setString(2, rt.getUsername());
			cstmt.setString(3, rt.getFirstname());
			cstmt.setString(4, rt.getLastname());
			cstmt.setString(5, rt.getGender());
			cstmt.setInt(6, rt.getDob());
			cstmt.setString(7, rt.getEmail());
			cstmt.setLong(8, rt.getCl());
			System.out.println("-------" + rt.getCl());
			cstmt.setString(9, rt.getCity());
			cstmt.setString(10, rt.getState());

			int i = cstmt.executeUpdate();
			if (i == 1) {
				flag = true;
				con.commit();
			} else {
				flag = false;
			}
			con.close();
		} catch (SQLException ex) {
			System.out.println(" ----->>>" + ex);
			flag = false;
			throw new ConnectionException(
					"Select File path not found..........");
		} finally {
			closeConnection();
		}
		return flag;
	}

}
