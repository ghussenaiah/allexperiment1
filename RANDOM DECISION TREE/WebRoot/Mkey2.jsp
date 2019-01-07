<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript">
	function validateForm() {
    var x = document.forms["myForm"]["key"].value;
    if (x == null || x == "") {
        alert("MasterKey must be filled out");
        return false;
    }
}
</script>
 </head>
  
  
  
  <body background="./images/vv3.jpg" >
       <jsp:include page="Header.jsp"></jsp:include>
    	
  <form action="./Mkey" method="get" name="myForm" onsubmit="return validateForm()" >
  <center>
		
            <td>
            <td colspan="10">
           Enter master key: <input type="text" name="key"/> 
           <input type="hidden" name="s1" value="two"/>
            </td>
            </td>   
              <br/><br/>
               <input type="submit" name="Submit" value="Submit"/>
  </center></tr>
 
</form>
</table>
  
  
  
  </body>
</html>
