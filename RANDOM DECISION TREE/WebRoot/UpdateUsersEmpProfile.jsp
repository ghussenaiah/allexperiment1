<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="com.mini.beans.RegisterTo"%>


<%
	String path;
	String usertype;
	String s;
	Vector c;
	Iterator it;
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html
	xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<head id="ctl00_header">
	<head>
		<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript"></script>
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js"></script>
		<script language="JavaScript1.1" src="scripts/pass.js"></script>
		<script type="text/javascript" src="scripts/image.js"></script>
		<script type="text/javascript" src="scripts/general.js"></script>
		<script type="text/javascript" src="scripts/adi.js"></script>
		<script type="text/javascript" src="scripts/form_validation.js"></script>
		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>
		<script>

//var x_win = window.self; 

function goOn() {
var port=document.register.port.value;
var host=document.register.host.value;
var userName=document.register.userName.value;
window.location.href='http://'+host+':'+port+'/IndianWildLife/CheckUserAction?userName='+userName+"&path=./RegistrationForm.jsp";
} 
</script>



		<style type="text/css">
.Title {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}

.Title1 {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}
</style>
	</head>
	<body background="./images/gb2.jpg">

		<jsp:include page="Header.jsp"></jsp:include>
		<br /><%
		String s2 = (String) request.getAttribute("status300");if(s2!=null){%>
		<center>
		<td align=center><font color=red><b><%=s2 %> <%} %></b></font></td></center>
		<br/><br/>

		    <form action="./UpdateProfilesAction" method='post' name="register"
			onsubmit="return validate()">
			<!--<table border="1"><tr><td></td></tr></table>-->
			<input type="hidden" name="port" value="<%=request.getLocalPort()%>" />
			<input type="hidden" name="host" value="<%=request.getServerName()%>" />
			<br />

			<table border='0' align="center">
				<th colspan="6" bgcolor="#999933">
					<font color=yellow>Personal Details
				</th>
				<%
					c = (Vector) request.getAttribute("vcb");
							it = c.listIterator();
							if (it.hasNext()) {
								RegisterTo pro = (RegisterTo) it.next();
								
				%>

				<tr></tr>
				<tr></tr>
				<tr>
					<td align='right'>
						<font color=white>UserName :
					</td>
					<td>
						<input type="text" name="username"
							value="<%=pro.getUsername()%>"  />
					</td>
					
				</tr>
				<tr>
					<td align='right'>
						<font color=white>First Name :
					</td>
					<td>
						<input type="text" name="firstname"
							value="<%=pro.getFirstname()%>" size="20"  />
					</td>
					
				</tr>
				<tr>
					<td align='right'>
						<font color=white>Last Name :
					</td>
					<td>
						<input type="text" name="lastname" value="<%=pro.getLastname()%>"
							size="20"  />
					</td>
					<td align='right'>

					</td>
					<td>

					</td>
				</tr>
						<tr>
					<td align='right'>
						<font color=white>Gender :
					</td>
					<td>
						<input type="text" name="gender" value="<%=pro.getGender()%>"
							size="20"  />
					</td>
					<td align='right'>

					</td>
					<td>

					</td>
				</tr>
				<tr>
					<td align='right'>
						<font color=white>Age :
					</td>
					<td width='256'>

						<input type="text" name="dob"
							value="<%=pro.getDob()%>" size="20"  />
						
					</td>
					<td align='right'>

					</td>
					<td>

					</td>
				</tr>
				
				<tr>
					<td align='right'>

					</td>
					<td>

					</td>
					<td></td>
					<td></td>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<th colspan="6" bgcolor="#999933">
					<center>
						<font color=yellow>Contact Details
					</center>
				</th>
				<tr></tr>
				<tr></tr>
						<tr>
					<td align='right'>
						<font color=white>Email :
					</td>
					<td>
						<input type="text" name="email" value="<%=pro.getEmail()%>"
							size="20" />
					</td>
					<td></td>
					<td></td>
				</tr>
				
				
					<td align='right'>
						<font color=white>State :
					</td>
					<td>
						<input type="text" name="state" value="<%=pro.getState()%>"
							size="20"  />
					</td>
				</tr>
				<tr>
					<td width="120" align='right'>
						<font color=white>City :
					</td>
					<td width="273">
						<input type="text" name="city" value="<%=pro.getCity()%>"
							size="20"  />
					</td>

					
				<tr>
					<td align='right'>
						<font color=white>Phone No :
					</td>
					<td>
						<input type="text" name="cl" value="<%=pro.getCl()%>"
							size="10" />
					</td>
					
				
				
				</tr>

				<%
					}
				%>
				<tr>
					<td></td>
					<td align="right">
						 <input type="image" alt="submit" src="./images/update.png " >
					</td>

					<td></td>
				</tr>
			</table>
		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");
  
  frmvalidator.addValidation("userName","req","Please enter your Username");
  frmvalidator.addValidation("firstName","req","Please enter your First Name");
  frmvalidator.addValidation("firstName","maxlen=20",	"Max length for FirstName is 20");
  frmvalidator.addValidation("firstName","alpha"," First Name Alphabetic chars only");
  
  frmvalidator.addValidation("lastName","req","Please enter your Last Name");
  frmvalidator.addValidation("lastName","maxlen=20","Max length is 20");
  frmvalidator.addValidation("lastName","alpha"," Last Name Alphabetic chars only");
  
  
  frmvalidator.addValidation("email","maxlen=50");
  frmvalidator.addValidation("email","req");
  frmvalidator.addValidation("email","email");
   
  frmvalidator.addValidation("state","req","Please enter your State Name");
    frmvalidator.addValidation("city","req","Please enter your city Name");
  frmvalidator.addValidation("cl","maxlen=10");
  frmvalidator.addValidation("cl","minlen=10");
  frmvalidator.addValidation("cl","numeric");
 frmvalidator.addValidation("cl","Phone");
   
   frmvalidator.addValidation("houseNo","req","Please enter your House Number");
   frmvalidator.addValidation("gender","dontselect=0");
   frmvalidator.addValidation("birthdate","req","Please enter your birthdate"); 
  
   frmvalidator.addValidation("photo","req","Please Load Your Photo"); 
  
  
  
   frmvalidator.addValidation("addressType","dontselect=0");
  
   frmvalidator.addValidation("street","req","Please enter your Street Number");
   //frmvalidator.addValidation("phoneType","dontselect=0");
  // frmvalidator.addValidation("phoneNo","req");
  
  
 
   
   frmvalidator.addValidation("country","req","Please enter your Country Name");
   frmvalidator.addValidation("pin","req","Please enter your pin Number");
   
  
   frmvalidator.addValidation("password","req","Please enter your Password");
   frmvalidator.addValidation("conformpassword","req","Please enter your Confirm Password");
   frmvalidator.addValidation("secrete","req","Please enter your Answer");
    frmvalidator.addValidation("squest","dontselect=0");
   frmvalidator.addValidation("fax","req","Please enter Fax Number");
      
 </script>
		<br />
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>