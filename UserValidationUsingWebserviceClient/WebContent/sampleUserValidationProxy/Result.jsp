<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleUserValidationProxyid" scope="session" class="com.mysql.conn.UserValidationProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleUserValidationProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleUserValidationProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleUserValidationProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.mysql.conn.UserValidation getUserValidation10mtemp = sampleUserValidationProxyid.getUserValidation();
if(getUserValidation10mtemp == null){
%>
<%=getUserValidation10mtemp %>
<%
}else{
        if(getUserValidation10mtemp!= null){
        String tempreturnp11 = getUserValidation10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String userName_1id=  request.getParameter("userName16");
            java.lang.String userName_1idTemp = null;
        if(!userName_1id.equals("")){
         userName_1idTemp  = userName_1id;
        }
        String passWord_2id=  request.getParameter("passWord18");
            java.lang.String passWord_2idTemp = null;
        if(!passWord_2id.equals("")){
         passWord_2idTemp  = passWord_2id;
        }
        java.lang.String loginUser13mtemp = sampleUserValidationProxyid.loginUser(userName_1idTemp,passWord_2idTemp);
if(loginUser13mtemp == null){
%>
<%=loginUser13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(loginUser13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>