
<%@page import="com.itextpdf.text.log.SysoLogger"%>

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
				<font color=gree><% int i=0,uid=0;long time=0; String username=null,result1=null,result2=null;
 	if ((String) request.getAttribute("status") != null) {
 %> <%=request.getAttribute("status")%> <%
 if ((String) request.getAttribute("s1") != null) {
 result1=(String) request.getAttribute("s1");
 System.out.println("---------"+result1);
 }
 
  if ((String) request.getAttribute("s2") != null) {
  result2=(String) request.getAttribute("s2");}
  System.out.println("----result is -----"+result2);
 
time=(Long)request.getAttribute("dur");
%><br/>
<font color=red><b>Time taken for fetch data( in Mill Sec):<%=time%>
   
 
<%} %>
   
 
 
  </b> </font><BR/><BR/>
			</h2>
		</center>
		<div class="hr">
		</div>
		<p></p>

		<form name="f" method="get" action="./">

			<table width="637"  align="center" bordercolor="#8692E3">



			
					
					
					
					
		            <c:if test="${not empty vcb}">
					<c:forEach var="vcb" items="${vcb}">
                        <% i++; %>
                        
                        <c:set var="uid" value="${vcb.uid}" />
                     
                        
                        <font color=white><b>OUT LOOK<BR>
                                                             |<BR>
                                                             |<BR>
                                                             |-----><font color=ORANGE><b>${vcb.out}<BR>
						
									<font color=white><b>HUMIDITY<BR>
                                                             |<BR>
                                                             |<BR>
                                                             |-----><font color=ORANGE><b>${vcb.hum}<BR><!--
                                                             <font color=white><b>TEMPERATURE<BR>
                                                             |<BR>
                                                             |<BR>
                                                             |---<font color=ORANGE><b>${vcb.tmp}<BR>
                                                             <font color=white><b>WINDY<BR>
                                                             |<BR>
                                                             |<BR>
                                                             |---<font color=ORANGE><b>${vcb.wind}<BR>
									
									
									--><font color=white><b>SEARCH RESULTS  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;FOR&nbsp; &nbsp; &nbsp; <font color=gree><b>PLAY<BR>
                                                                          
                                                         <font color=white>  |<BR>
                                                             |<BR>
                                                             |----------------------><font color=yellow>yes----->&nbsp; &nbsp; &nbsp;<b><font color=gree>${vcb.yes}<BR>
									<font color=white>  |<BR>
                                                             |<BR>
                                                             |----------------------><font color=yellow>No----->&nbsp; &nbsp; &nbsp;<b><font color=gree>${vcb.no}<BR>
									
									
								
						
						
						
							
					</c:forEach>
				</c:if>       






			</table>

</center>

			<jsp:include page="Footer.jsp"></jsp:include>
		</form>
	</body>
</html>

