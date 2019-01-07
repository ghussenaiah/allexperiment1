<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		

	</head>

	<body>
	
		<tr><img src="./images/hai.jpg" width="960" height="150"/>
		
		
		<center>
			
					<c:choose>
						<c:when test="${sessionScope.role eq 'user'}">
							<jsp:include page="UserMenu.jsp" />
						</c:when>
						
						<c:when test="${sessionScope.role eq 'admin'}">
							<jsp:include page="AdminMenu.jsp" />
						</c:when>
						<c:otherwise>
							<jsp:include page="GeneralMenu.jsp"></jsp:include>
						</c:otherwise>
					</c:choose>
					</center>
						
	</body>
</html>
