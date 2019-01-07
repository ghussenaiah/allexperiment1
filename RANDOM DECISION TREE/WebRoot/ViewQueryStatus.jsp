

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>


    <style type="text/css">
<!--
.style1 {
	font-size: 50px
}
-->
    </style>
    </head><body background="./images/bbgg2.jpg">
    
    
    
 
<jsp:include page="Header.jsp"></jsp:include>

		<br/><br/><br/>
   
			<center><h2><font color=child>Queries Status</h2></center>
		  <div class="hr"> </div>
          <p></p> 
                    <form method="post" action="ViewSolutionAction?req=vsolution" >
 
    <table width="637" border="0" align="center"background="./images/b12.jpeg" >
    
      <tr bgcolor="#509Ccc">
     
        <%--<td width="18"><div align="center">
            
        </div></td>
        --%><td width="233"><div align="center" class="style8">Query ID</div></td>
        <td width="372"><div align="center" class="style8">Query Date</div></td>
        <td width="372"><div align="center" class="style8">Status</div></td>
        <td width="372"><div align="center" class="style8">Solution</div></td>
      </tr>
      
      <c:if test="${not empty Statusvector}">
      <c:forEach var="Statusvector" items="${Statusvector}">
     
         
      <tr bgcolor="#CEC9FA">
      <%--<td bgcolor="#C3D7BA"><input name="ch" type="checkbox" id="checkbox2" onclick="check1()" value="${Statusvector. qid}"/></td> 
      
      
      --%><td font color=yellow><div align="center"><span class="style7">${Statusvector.qid }</span></div></td>
      <td ><div align="center"><span class="style7">${Statusvector.rdate }</span></div></td>
      <td><div align="center"><span class="style7">${Statusvector.status }</span></div></td>
      <td ><div align="center"><span class="style7"><a href="UserQuerySolutionAction?qid=${Statusvector. qid}&from=${sessionScope.user}">View</a></span></div></td>
        <td >&nbsp;<div align="center" class="style7">
       
       
        </div></td>
        
      </tr>
      </c:forEach>
      </c:if>
      
     
   
          <tr>
        <td colspan="6"><div align="center">
         
          
        </div></td>
      </tr>
     
    </table>
     <br/><br/> <br/><br/><br/>
			
                  <jsp:include page="Footer.jsp"></jsp:include>

</body></html>