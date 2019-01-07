<%@ page
	import="java.util.Vector,com.mini.beans.RegisterTo" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script language="javascript">

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
	<body background="./images/gb2.jpg">


		<jsp:include page="Header.jsp"></jsp:include>

		<center>
			<h2>
<font color=gree><% int i=0,uid=0; String username=null;
RegisterTo vcb1=null;
RegisterTo vcb2=null;
 	if ((String) request.getAttribute("status") != null) {
 %> <%=request.getAttribute("status")%> <%
 	}
 
 
   
 username=(String)session.getAttribute("username");
 %> 
 
  </b> </font><BR/><BR/>
			</h2>
		</center>
		<div class="hr">
		</div>
		<p></p>

		<form name="f" method="get" action="./InsertPatientRequestAction">

			<table width="637"  align="center" bordercolor="#8692E3">



			
					
					
					<tr>
					<td>
					
		           <% if ((RegisterTo) request.getAttribute("vcb1") != null) 
		           {
		           
		            vcb1=(RegisterTo) request.getAttribute("vcb1");
                  
                   %> 
 	
                        
                     
                        
                        <font color=red><b>OUT LOOK<BR>
                                                             |<BR>
                                                             |<BR>
                                                             |-----><font color=red><b><%=vcb1.getOut()%><BR>
						
									<font color=red><b>HUMIDITY<BR>
                                                             |<BR>
                                                             |<BR>
                                                             |-----><font color=red><b><%=vcb1.getHum()%><BR>
                                                             <font color=red><b>TEMPERATURE<BR>
                                                             |<BR>
                                                             |<BR>
                                                             |-----><font color=red><b><%=vcb1.getTmp()%><BR>
                                                             <font color=red><b>WINDY<BR>
                                                             |<BR>
                                                             |<BR>
                                                             |-----><font color=red><b><%=vcb1.getWind()%><BR>
									
									
									  <font color=red><b>SEARCH RESULTS  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;FOR&nbsp; &nbsp; &nbsp; <font color=gree><b>PLAY<BR>
                                                                          
                                                         <font color=white>  |<BR>
                                                             |<BR>
                                                             |----------------------><font color=red>yes----->&nbsp; &nbsp; &nbsp;<b><font color=red><%=vcb1.getYes()%><BR>
									<font color=red>  |<BR>
                                                             |<BR>
                                                             |----------------------><font color=red>No----->&nbsp; &nbsp; &nbsp;<b><font color=red><%=vcb1.getNo()%><BR>
									
							<%} %>	
              </td>
              
              <td>
              
                   <% if ((RegisterTo) request.getAttribute("vcb2") != null) 
		           {
		           
		            vcb2=(RegisterTo) request.getAttribute("vcb2");
                  
                   %>
                     
                        
                        <font color=red><b>OUT LOOK<BR>
                                                             |<BR>
                                                             |<BR>
                                                             |-----><font color=red><b><%=vcb2.getOut()%><BR>
						
									<font color=red><b>HUMIDITY<BR>
                                                             |<BR>
                                                             |<BR>
                                                             |-----><font color=red><b><%=vcb2.getHum()%><BR>
                                                             <font color=red><b>TEMPERATURE<BR>
                                                             |<BR>
                                                             |<BR>
                                                             |-----><font color=red><b><%=vcb2.getTmp()%><BR>
                                                             <font color=red><b>WINDY<BR>
                                                             |<BR>
                                                             |<BR>
                                                             |-----><font color=red><b><%=vcb2.getWind()%><BR>
									
									
									  <font color=red><b>SEARCH RESULTS  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;FOR&nbsp; &nbsp; &nbsp; <font color=red><b>PLAY<BR>
                                                                          
                                                         <font color=red>  |<BR>
                                                             |<BR>
                                                             |----------------------><font color=red>yes----->&nbsp; &nbsp; &nbsp;<b><font color=red><%=vcb2.getYes1()%><BR>
									<font color=red>  |<BR>
                                                             |<BR>
                                                             |----------------------><font color=red>No----->&nbsp; &nbsp; &nbsp;<b><font color=red><%=vcb2.getNo1()%><BR>
									
								<%} %><tr>
              
              </td>
              </tr>




			</table><font color=red><B><br> FIRST PARTITION(P1)</B></font></tr><font color=red><B>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; SECOND PARTITION(P2)</B></font></tr>

</center>

			

		</form>
	</body>
</html>

