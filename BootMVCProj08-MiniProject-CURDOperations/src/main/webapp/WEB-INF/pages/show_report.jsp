<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1  style="color:red;text-align:center"> Employee Report Page  </h1>
<c:choose>
  <c:when test="${!empty resultList}">
     <table  border="1" bgcolor="cyan"  align="center">
       
        <tr>  <th>Empid  </th> <th>EmpName  </th> <th>Emp Desg  </th> <th> Employee salary </th><th>operations </th> </tr>
       
         <c:forEach var="emp" items="${resultList}">
           <tr>
              <td>${emp.empid} </td>
               <td>${emp.ename} </td>
               <td>${emp.job} </td>
               <td>${emp.salary} </td>
               <td>${emp.status} </td>
               <td>${emp.dept} </td>
               <td><a href="edit?no=${emp.empid}"><img src=" images/edit.png" width="25" height="25"></a>
                       <a href="delete?no=${emp.empid}" onclick="return confirm(' Are U sure delete the employee ')"><img src=" images/delete.jpg" width="25" height="25"></a>
                  </td>
           </tr>
         </c:forEach>
     
     </table>
  
  </c:when>
  <c:otherwise>
      <h1  style="color:red;text-align:center"> Records  not found  </h1>
  </c:otherwise>
 </c:choose>
   <center>
             <h1  style="color:green;text-align:center">${resultMsg}</h1>
   </center>
<center>
<a href="./">home <img src="images/home.jfif" width="70" height="70"></a>  
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="add">Add Employee<img src="images/add.jpg" width="70" height="70"></a>  
</center>
