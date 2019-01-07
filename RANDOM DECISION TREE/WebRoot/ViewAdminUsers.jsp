

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script language="javascript">
function validate() {
	var temp = document.register;
	if (temp.fname.value == "" || temp.lname.value == ""
			|| temp.bdate.value == "" || temp.loginname.value == ""
			|| temp.password.value == "" || temp.sanswer.value == "") {
		alert("All Fields are manditory");
		return false;
	}
	if (temp.ch.checked && temp.ownquest.value == "") {
		alert("All Fields are manditory");
		return false;
	}
	return true;
}
function check() {
	var form = document.register;
	if (!form.ch.checked) {
		form.ownquest.disabled = true;
		form.squest.disabled = false;
	} else {
		form.ownquest.disabled = false;
		form.squest.disabled = true;
	}
}
</script>
		<script type="text/javascript" src="scripts/general.js">
</script>
		<script type="text/javascript" src="scripts/ts_picker.js">
</script>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

		<meta http-equiv="Last-Modified"
			content="Thu, 02 Aug 2007 10:30:00 GMT" />


		<title>e-Banking</title>

		<link rel="icon" href="http://www.bis.org/favicon.ico"
			type="image/x-icon" />
		<link rel="shortcut icon" href="http://www.bis.org/favicon.ico"
			type="image/x-icon" />

		<link href="cbanks_files/standard.css" type="text/css"
			rel="stylesheet" />

		<!-- JavaScript variable to set the active Menu -->
		<script type="text/javascript" src="cbanks_files/standard.js">
</script>
		<script type="text/javascript">
<!--
		var primaryMenu = "Central bank hub";
		var secondaryMenu = "Central bank websites";
	// -->
	</script>
		<style type="text/css">
<!--
.style1 {
	font-size: 50px
}
-->
</style>
	</head>
	<body background="./images/bbgg2.jpg">


		<jsp:include page="Header.jsp"></jsp:include>

		<center>
			<h2>
				<font color=white>All Query Requests 
			</h2>
		</center>
		<div class="hr">
		</div>
		<p></p>

		<form name="f" method="post" action="DeleteBrandAction.jsp">

			<table width="637" border="1" align="center" bordercolor="#8692E3">



				<tr bgcolor="#50cccc">
					<td width="233" height="16">
						<div align="center" class="style8">
						USERNAME
						</div>
					</td>
					</tr>
					<br/>
					<tr><br/><br/><br/><br/><td width="372">
						<div align="center" class="style8">
							FIRSTNAME
						</div>
					</td></tr>
					<tr><td width="372">
						<div align="center" class="style8">
							LASTNAME
						</div>
					</td></tr>
					<tr><td width="372">
						<div align="center" class="style8">
							GENDER
						</div>
					</td></tr>
					<tr><td width="372">
						<div align="center" class="style8">
							AGE
						</div>
					</td></tr>
					<tr><td width="372">
						<div align="center" class="style8">
							EMAIL
						</div>
					</td></tr>
					<tr><td width="372">
						<div align="center" class="style8">
							CELL NO
						</div>
					</td></tr>
					<tr><td width="372">
						<div align="center" class="style8">
							CITY
						</div>
					</td></tr>
					<tr><td width="372">
						<div align="center" class="style8">
							STATE
						</div>
					</td>
					
				</tr>

				<c:if test="${not empty vcb}">
					<c:forEach var="vcb" items="${vcb}">

						<tr bgcolor="#CcC9cA">
							<td bgcolor="#C3D7BA">
								<div align="center">
									<span class="style7">${vcb.username}</span>
								</div>
							</td>
							<td bgcolor="#C3D7BA">
								<div align="center" class="style7">

									${vcb.firstname }
								</div>
							</td>
							<td>
								${vcb.lastname }
							</td>



							<td bgcolor="skyblue">
								<div align="center">
									<span class="style7">${vcb.gender }</span>
								</div>
							</td>
							<td bgcolor="skyblue">
								<div align="center">
									<span class="style7">${vcb.dob }</span>
								</div>
							</td>
							<td bgcolor="skyblue">
								<div align="center">
									<span class="style7">${vcb.email }</span>
								</div>
							</td>
							<td bgcolor="skyblue">
								<div align="center">
									<span class="style7">${vcb.cell }</span>
								</div>
							</td>
							<td bgcolor="skyblue">
								<div align="center">
									<span class="style7">${vcb.city }</span>
								</div>
							</td>
							<td bgcolor="skyblue">
								<div align="center">
									<span class="style7">${vcb.state }</span>
								</div>
							</td>
							
							<td bgcolor="yellow">
								<div align="center" class="style3">



									
					</c:forEach>
				</c:if>






			</table>

			<br />
			<br />

			<jsp:include page="Footer.jsp"></jsp:include>
		</form>
	</body>
</html>

