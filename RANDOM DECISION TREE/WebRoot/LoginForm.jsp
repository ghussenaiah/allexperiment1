<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'LoginForm.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 
  
  <body background="./images/wtt.jpg">
  <jsp:include page="Header.jsp"></jsp:include>
  
  
   <form action="./LoginAction" method="get" name="register" >
   
   
    <%
		String s2 = (String) request.getAttribute("status200");if(s2!=null){%>
		<center>
		<td align=center><font color=red><b><%=s2 %> <%} %></b></font></td></center>
		<br/><br/>
   
   
     <%
		String s1 = (String) request.getAttribute("status1");if(s1!=null){%>
		<center>
		<td align=center><font color=red><b><%=s1 %> <%} %></b></font></td></center>
		<br/><br/>
         <table width="200" border="0" align="center">
          <tr>
             <td>
<center><h2><font color="green">Login Form</font></h2></center>             <table  border="0" align="center">
               <tr></tr><tr>
                 <td height="120" align="right"></td><td><img src="./images/lg2.jpg"></td>
                 <td><table border="0" align="center" style="width: 234px;">
                   <tr>
                     <td ><font color="black"><b>UserName</b></font></td>
                      <td ><input type="text" name="username">                      </td>
                      </tr>
                   <tr>
                     <td><font color="black"><b>Password</b></td>
                      <td>
                        <input type="password" name="password" maxlength="500">                      </td>
                      </tr>
                   <tr>
                     <td colspan="2">
                       <div align="center">
                         <input type="image" alt="submit" src="./images/col3.png">
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                          <input type="image" alt="reset" src="./images/col4.png" name="Input2">
                        
                         </div>                        </td>
                      </tr>
                 </table></td>
                 <td>&nbsp;</td>
               </tr>
               <tr>
                
                 
               <tr>
                 <td >&nbsp;</td>
                 <td valign="baseline">
                 <div align="center"><a href="RegisterForm.jsp"><font color="green"><b>New User....?Please Register</a></div></td>
                 <td>&nbsp;</td>
               </tr>
               
             </table></td>
           </tr>
           </table>
                    </form> 
                    
                    
                    
      
    <jsp:include page="Footer.jsp"></jsp:include>
  </body>
</html>
