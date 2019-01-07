


<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>

<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript"></script>
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js"></script>
		<script language="JavaScript1.1" src="scripts/pass.js">
</script>
		<script type="text/javascript" src="scripts/image.js"> </script>
		<script type="text/javascript" src="scripts/general.js"> </script>
		<script type="text/javascript" src="scripts/adi.js"> </script>
		<script type="text/javascript" src="scripts/form_validation.js"> </script>
        <script type="text/javascript" src="scripts/project.js"> </script>
		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>
		<script>

//var x_win = window.self; 

function goOn() {
var port=document.register.port.value;
var host=document.register.host.value;
var username=document.register.username.value;
window.location.href='http://'+host+':'+port+'/sample/CheckAvailabilityAction?username='+username+"&path=./RegisterForm.jsp";

} 
</script>

		
		
		<style type="text/css">
.Title {
font-family:Verdana;
font-weight:bold;
font-size:8pt
}
.Title1 {font-family:Verdana;
font-weight:bold;
font-size:8pt
}
        </style>
        </head>
<body background="./images/vv3.jpg" >
<jsp:include page="Header.jsp"></jsp:include>
<div align="center" >
					
					
<%
		String s1 = (String) request.getAttribute("status123");if(s1!=null){%>
		<center>
		<td align=center><font color=red><b><%=s1 %> <%} %></b></font></td></center>
		<br/><br/>
<table background="./images/bg2.jpeg" align=center">
<h5><div align="center"><span class=subHead><font size="30" color="white"><marquee align=left>REGISTER HERE</marquee> </font></span></div></h5>
<    <form action="./RegisterAction" method="get" name="register" >
<!--  onSubmit="return validate() -->
 <!--<table border="1"><tr><td></td></tr></table>-->
 <input type="hidden" name="port" value="<%=request.getLocalPort() %>">
 <input type="hidden" name="host" value="<%=request.getServerName() %>">
 <br>

 
<th colspan="6" bgcolor="#808"><span class=Title><font color="red" size="3"><b>Account Details</b></font></span></th>
<tr></tr><tr></tr>

 <tr>
					<td align='left'><b>
						<font color=yellow>User Name </b>
					</td>
					<td width="303">
						<input type="text" name="username"
							value="<% if(request.getParameter("username")!=null)
    out.print(request.getParameter("username")); %>"
							size="20"  />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<!--  onblur="goOn()"-->

					
					
						<font color="red"> ${requestScope.status } </font>
				

					<td align='left'>

						<b><font color="green"> <c:if
									test="${'requestScope.status1'!='null'}">

									<c:out value="${param.status1}"></c:out>
								</c:if> </font>
						</b>


					</td>
					<td></td><td></td>
					<td></td>
				</tr>
<tr>
 <td><pre><span class=Title>    <font color=yellow>PassWord</span></pre></td>
  <td>
    
        <input type="password" name="password"  
        onkeyup="testPassword(document.forms.register.password.value);" 
        onChange="Encrypt(document.forms.register.password.value);"></td></tr>
        <tr><td></td><td>
     <span class=Title><a id="Words"> <font color=yellow>Strength:</a></td>
      <td><table cellpadding=0 cellspacing=0><tr><td height=15  bgcolor=#dddddd></td></tr></table></td>
</tr>
<tr>
    <td><pre><span class=Title>    <font color=yellow>Confirm</span><pre></td>
    <td><input type="password" name="conformpassword" value="" size="20" onBlur="checkconformpassword()"/></td>
   
</tr>
<tr>
    <td><pre><span class=Title>    <font color=yellow>SecurityQuestion</span></pre></td>
    <td><select name="sq">
      <option value="select" selected="true"><font size="3" face="Verdana">--Select One---</font></option>
      <option value="What is your favorite pastime?"><font size="3" face="Verdana">What is your favorite pastime?</font></option>
      <option value="Who your childhood hero?"><font size="3" face="Verdana">Who your childhood hero?</font></option>
      <option value="What is the name of your first school?"><font size="3" face="Verdana">What is the name of your first school?</font></option>
      <option value="Where did you meet your spouse?"><font size="3" face="Verdana">Where did you meet your spouse?</font></option>
      <option value="What is your favorite sports team?"><font size="3" face="Verdana">What is your favorite sports team?</font></option>
      <option value="What is your father middle name?"><font size="3" face="Verdana">What is your father middle name?</font></option>
      <option value="What was your high school mascot?"><font size="3" face="Verdana">What was your high school mascot?</font></option>
      <option value="What make was your first car or bike?"><font size="3" face="Verdana">What make was your first car or bike?</font></option>
      <option value="What is your pet name?"><font size="3" face="Verdana">What is your pet name?</font></option>
    </select></td>
</tr>
<tr>
    <td><pre><span class=Title>    <font color=yellow>Security Answer</span></pre></td>
    <td><input type="text" name="sa" value="" size="20"/></td>
</tr>


<tr></tr><tr></tr>
  <th colspan="6" bgcolor="#808"><span class=Title><font color="red" size="3"><b>Personal Details</b></font></span>  </th>
  <tr></tr><tr></tr>
  <tr>
    <td><pre><span class=Title>    <font color=yellow>First Name</span></pre></td>
    <td width="276"><input type="text" name="firstname" value=""></td>
  </tr>
<tr>
    <td width="139"><pre><span class=Title>   <font color=yellow> Last Name</span></pre></td>
    <td width="276">
      <input type="text" name="lastname" value="" size="20"/>
    </td>
  </tr>
  <tr>
  <tr>
    <td><pre><span class=Title>    <font color=yellow>Gender</span></pre></td>
    <td><select name="gender">
    <option value="select" selected="true"><font size="3" face="Verdana">Select </font></option>
    <option value="Male"><font size="3" face="Verdana">Male</font></option>
    <option value="Female"><font size="3" face="Verdana">Female</font></option>
    </select>
    </td>
    <tr>
    <td><pre><span class=Title> <font color=yellow>AGE</span>(no of years from establishing year in case of company)</pre></td>
    
    <td><input type="text" name="dob" value="" size="20"/></td>
</tr>
<tr>
  
  <tr></tr><tr></tr>
<th colspan="6" bgcolor="#808"><center><span class=Title><font color="red" size="3"><b>Contact Details</b></font></span>
</center></th>
<tr></tr><tr></tr>

 
    <td><pre><span class=Title>   <font color=yellow>Email</span></pre></td>
    <td><input type="text" name="email" value="" size="20" onchange="emailvalidation(this,'Invlid Email')"/></td>
  </tr>
 
  
<tr>
    <td><pre><span class=Title>    <font color=yellow>House No</span></pre></td>
    <td><input type="text" name="houseno" value="" size="20"/></td>
</tr>
<tr>
    <td><pre><span class=Title>    <font color=yellow>Street</span></pre></td>
    <td><input type="text" name="street" value="" size="20"/></td>
</tr>

<tr>
    <td><pre><span class=Title>   <font color=yellow>Cell No</span></pre></td>
    <td><input type="text" name="cl" value="" size="20"/></td>
</tr>

   <tr>
    <td><pre><span class=Title>  <font color=yellow>city  </span></pre></td>
    <td><input type="text" name="city" value="" size="20" /></td>
</tr>

	<tr>
    <td><pre><span class=Title> <font color=yellow> State  </span></pre></td>
    <td><input type="text" name="state" value="" size="20" /></td>
</tr>
<tr>
    <td><pre><span class=Title> <font color=yellow> Master Key  </span></pre></td>
    <td><input type="text" name="mkey" value="" size="20" /></td>
</tr>

 <td><pre><span class=Title>    <font color=yellow>UserType</span></pre></td>
 
 
    <td><select name="type">
    <option value="select" selected="true"><font size="3" face="Verdana">select </font></option>
     <option value="user"><font size="3" face="Verdana">USER</font></option>
      </select>
    
    </td>
    
    
    
      </tr>
 <tr><td></td>
    <td align="center"><font size="3" face="Verdana">
    <pre>                   <input type="submit" name="register" value="Register" style="background-color: lightblue"/>&nbsp;  <input type="reset" name="cancel" value="Cancel" style="background-color: lightblue"/>
   </pre> </font></td>
    <td align="center"></td>
</tr>
</table>
<a href="LoginForm.jsp"><font color=white>GoTO Home With Out Registration</a>


  
     


</table>
</form>

<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");
    
  frmvalidator.addValidation("username","req","Please enter your user Name");
  frmvalidator.addValidation("username","maxlen=15",	"Max length for username is 15");
  frmvalidator.addValidation("username","alpha"," user Name Alphabetic chars only");
  
  frmvalidator.addValidation("password","req","Please enter your password");
  frmvalidator.addValidation("password","maxlen=15","Max length is 15");
  frmvalidator.addValidation("password","alpha"," password Alphabetic chars only");
  
  frmvalidator.addValidation("firstname","req","Please enter your First Name");
  frmvalidator.addValidation("firstname","maxlen=20",	"Max length for FirstName is 20");
  frmvalidator.addValidation("firstname","alpha"," First Name Alphabetic chars only");
  
  frmvalidator.addValidation("lastname","req","Please enter your Last Name");
  frmvalidator.addValidation("lastname","maxlen=20","Max length is 20");
  frmvalidator.addValidation("lastname","alpha"," Last Name Alphabetic chars only");
  
   frmvalidator.addValidation("gender","dontselect=0");
    frmvalidator.addValidation("dob","req","Please enter your Age");
  frmvalidator.addValidation("dob","maxlen=3",	"Max length for Age is 3");
  frmvalidator.addValidation("dob","numeric"," Age is Numaric only"); 
  
    frmvalidator.addValidation("type","dontselect=0");
  frmvalidator.addValidation("email","maxlen=50");
  frmvalidator.addValidation("email","req");
  frmvalidator.addValidation("email","email");
   frmvalidator.addValidation("cell","req");
  
  frmvalidator.addValidation("cell","maxlen=10");
  frmvalidator.addValidation("cell","numeric");
 frmvalidator.addValidation("cell","Cell");
      frmvalidator.addValidation("cell","req","Please enter your Phone Number");
   frmvalidator.addValidation("houseno","req","Please enter your House Number");
    frmvalidator.addValidation("houseno", "numeric", "Please enter Numeric only for House No ");
   frmvalidator.addValidation("street","req","Please enter your Street Number");
    frmvalidator.addValidation("street","alpha","Please enter char only for street");
      frmvalidator.addValidation("city","req","Please enter your city Name");
      frmvalidator.addValidation("city","alpha","Please enter char only");
     frmvalidator.addValidation("state","req","Please enter your State Name");
      frmvalidator.addValidation("state","alpha","Please enter char only");
  frmvalidator.addValidation("conformpassword","req","Please enter your Confirm Password");
   frmvalidator.addValidation("sa","req","Please enter your Answer");
    frmvalidator.addValidation("sq","dontselect=0");
  
 </script>
</table>
 										
 
	</body>
</html>



