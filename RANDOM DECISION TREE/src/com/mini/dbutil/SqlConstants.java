package com.mini.dbutil;

public class SqlConstants {

	// Query DAo

	public static final String _INSERT_QUERY = "insert into query values((select nvl(max(queryid),6000)+1 from query),?,?,?,?)";
	public static final String _INSERT_DOCQUERY = "insert into doct values(?,?,?)";
	public static final String _INSERT_COMPANY = "insert into company values((select nvl(max(cid),8000)+1 from company),?,?)";
	public static final String _INSERT_PHARMACY = "insert into pharmacy values((select nvl(max(phrid),6000)+1 from pharmacy),?,?,?)";
	public static final String _INSERT_PATIENTQUERY = "insert into patient values(?,?,?,(select nvl(max(pssn),500)+1 from patient),?)";
	public static final String _GETQUERY = "select queryid,qdescription,qstatus,to_char(qdate,'dd-mm-yy') from query";
	public static final String _GETDOCDETAILS = "select userid,specialization,exp from doct where userid=?";
	public static final String _GETALLDOCDETAILS = "select u.userid,u.username,a.city,d.specialization,d.exp from users u,addr a, doct d  where u.userid=d.userid and u.userid=a.userid";
	public static final String _GETALLPATIENTDETAILS = "select unique p.pssn,pr.pssn,pr.pname,p.disese,p.duration  from patient p,patientrequest pr,users u where pr.dssn=? and pr.pssn=p.userid  and p.status='pending' ";
	public static final String _GETSINGLEPATIENTDETAILS = "select unique p.pssn,pr.pssn,pr.pname,p.disese,p.duration  from patient p,patientrequest pr,users u where pr.dssn=? and pr.pssn=p.userid and pr.statusr='pending' and p.pssn=?";
	public static final String _GETALLPSSN = "SELECT PSSN FROM PATIENT WHERE USERID=?  and STATUS='clear'";
	public static final String _GETPRIS = "SELECT doctname,did,pname,prisid,dis,drug,comp,ptext FROM PRISCRIPTION WHERE PSSN=?";
	public static final String _GETALLCOMP = "select cname from company";
	public static final String _GETALLPHR = "select phrname from pharmacy";
	public static final String _INSERT_PRIS = "insert into priscription values((select nvl(max(prisid),600)+1 from priscription),?,?,?,?,?,?,?,?,?)";
	public static final String _GETPRISD = "SELECT doctname,did,pname,prisid,dis,drug,comp,ptext FROM PRISCRIPTION ";
	
	
	
	public static final String _INSERT_WQUERY = "insert into weather values((select nvl(max(wid),800)+1 from weather),?,?,?,?,?)";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static final String _GETCONTRACT = "SELECT CONTRACTID,COMPANY,PHARMACY,SNAME,to_char(startdate,'dd-mm-yy'),to_char(enddate,'dd-mm-yy'),CONTRACTTEXT FROM CONTRACTDETAILS WHERE SNAME=?";
	public static final String _INSERT_DRUG = "insert into drug values((select nvl(max(drugid),3000)+1 from drug),?,?,?,?)";
	public static final String _INSERT_CONTRACT = "insert into contractdetails values((select nvl(max(contractid),4000)+1 from contractdetails),?,?,?,?,?,?)";

	public static final String _INSERT_PATIENTREQUEST = "insert into patientrequest values(?,?,?,?,?)";

	public static final String _GET_QUERY_AT = "select queryid,qdescription,qstatus,TO_CHAR(qdate,'dd-mm-yyyy') from query where queryid=?";
	public static final String _INSERT_SOLUTION = "insert into solution values(?,?,?,?)";
	public static final String _GET_QUERY_STATUS = "select DISTINCT q.queryid,q.qdescription,TO_CHAR(q.qdate,'DD-MM-YYYY'),s.soldate,s.solution ,q.qstatus from query q ,  SOLUTION  s ,users u where q.queryid=s.queryid and s.userid=? ";
	public static final String _GET_SOLUTION = "select q.queryid,q.qdescription,TO_CHAR(q.qdate,'DD-MM-YYYY'),TO_CHAR(s.soldate,'DD-MM-YYYY'),s.solution ,u.userid,q.qstatus from query q , solution s ,users u where q.queryid=s.queryid and s.queryid=? and u.username=? ";

	public static final String _VIEWUSERSA = "select u.username,u.firstname,u.lastname,u.gender,u.age,a.email,a.cellno,a.city,a.state  from users u,addr a where a.userid=u.userid and usertype='admin'";

	public static final String _VIEWUSERSD = "select u.username,u.firstname,u.lastname,u.gender,u.age,a.email,a.cellno,a.city,a.state  from users u,addr a where a.userid=u.userid and u.userid=?";

	public static final String _VIEWUSERSP = "select u.username,u.firstname,u.lastname,u.gender,u.age,a.email,a.cellno,a.city,a.state  from users u,addr a where a.userid=u.userid and u.userid=?";
	public static final String _VIEWUSERSPH = "select u.username,u.firstname,u.lastname,u.gender,u.age,a.email,a.cellno,a.city,a.state  from users u,addr a where a.userid=u.userid and u.userid=?";
	public static final String _VIEWUSERSS = "select u.username,u.firstname,u.lastname,u.gender,u.age,a.email,a.cellno,a.city,a.state  from users u,addr a where a.userid=u.userid and u.userid=?";
	public static final String _VIEWUSERSC = "select u.username,u.firstname,u.lastname,u.gender,u.age,a.email,a.cellno,a.city,a.state  from users u,addr a where a.userid=u.userid and u.userid=?";

	public static final String _GETUSERID = "select userid from users where username=? ";

	// LoginAction

	public static final String _LOGINCHECK = "select usertype from users where username=? and password=?";
	public static final String _CHECKAVAILABLE_LOGINNAME = "select userid from users where loginid=?";
	public static final String _CHANGEPASSWORD = "update users set password=? where  username=? and password=?";
	public static final String _CHANGEQUESTION = "update users set FORGOTPWQUESTION=?,FORGOTPWANSWER =? where loginid=? and password=? ";
	public static final String _CHECK_AVAILABILITY = "select username from users where username=?";

	// BANK details

	
}
