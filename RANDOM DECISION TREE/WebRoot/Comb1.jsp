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
	

  </head>
  
       <body background="./images/vv3.jpg" >
       <jsp:include page="Header.jsp"></jsp:include>
    <%String s1 = (String) request.getAttribute("status200");if(s1!=null){%>
		<center>
	  <font color=red><b><%=s1 %> <%} 
	    %> 	
  <form action="./ConstructVTreeAction2" method="get" name="register" >
  
   
   <center> <font color="red" size="3"><b>Vertical Decision Tree Construction</b></font><br/>
  
<br><br>
       <tr>
           <center> 
                
                <input type="hidden" name="s2" value="another"/>
                 <td>
                           <font color=green><b>WIND<select name="wind">
                                          <option  value="weak">weak</option>
                                          <option  value="strong">strong</option>
                           </select>
                </td> 
                <br/><br/><br/>
                 <td  colspan="10">
                           <font color=green><b>TEMERATURE  <select name="tmp">
                                          <option  value="hot">hot</option>
                                          <option  value="cool">cool</option>
                                           <option  value="mild">mild</option>
                           </select>
                  </td>
                  
                   
                  </tr>
                
                
                    
                
                
                
                
                
              
                
                
                
                
                 
                
                
                
          
          <br><br><br><br>
                <tr> <td> 
   
                   <input type=submit name=submit value= " Construct Random Tree">
               </td></tr><br><br>
  </center></tr>
 
</form>
</table>
  
  
  
  </body>
</html>
