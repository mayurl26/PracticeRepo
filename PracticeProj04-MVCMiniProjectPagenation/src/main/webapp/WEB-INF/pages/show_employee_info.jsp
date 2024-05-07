<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>

<h1 style="color: maroon; text-align: center;"> All Employee Information</h1>
<link rel="styalesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></link>
<c:choose>

<c:when test="${!empty EMpData}">
  <table style="border-width:10px ;border-color:black;align-content: center;">
     
     <tr>
        <th>EmpId</th><th>empName</th><th>dept</th><th>job</th><th>salary</th><th>Status</th>
     </tr>
     <c:forEach var="emp" items="${EmpData}">
     <tr>
        <td>${emp.empid}</td>
        <td>${emp.ename}</td>
        <td>${emp.dept}</td>
        <td>${emp.job}</td>
        <td>${emp.salary }</td>
        <td>${emp.status}</td>
        <td><a href="edit?no=${emp.empid}">Edit </a>
                       <a href="delete?no=${emp.empid}" onclick="return confirm(' Are U sure delete the employee ')">Delete</a>
                  </td>
        
     </tr>
     </c:forEach>
     
       </table> 
       <a href="add_emp" style="text-align: center; ">Add Employee</a>
          	
          	
       
       
<p> 
<c:if test="${EmpData.hasPrivious()}">
<a href="All_page?page=${EmpData.getPageable().getPageNumber()-1}">previous</a>
</c:if>


<c:if test="${!EmpData.isFirst()}">
<a href="All_page?page=0">First </a>
</c:if>

<c:forEach var="i" begin="1" end="EmpData.getTotalPages()" step="1">
  [<a href="All_page?page=${i-1}">${i}</a>]
</c:forEach>

<c:if test="${EmpData.hasNext()}">
<a href="All_page?page=${EmpData.getPageable.getPageNumber+1}"> next</a>
</c:if>

<c:if test="${!EmpData.isLast()}">
<a href="All_page?page=${EmpData.hasTotalPages-1}">last</a>
</c:if>
</p>	
     
</c:when>



       <c:otherwise>
      <h1  style="color:red;text-align:center"> Records  not found  </h1>
      <a href="add_emp" style="text-align: center; ">Add Employee</a>
  </c:otherwise>
  

</c:choose> --%>




















<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>

<!DOCTYPE html>
<html>
<head>
    <title>All Employee Information</title>
    <style>
        h1 {
            color: maroon;
            text-align: center;
        }
        table {
            border: 1px solid black;
            margin: auto;
        }
        th, td {
            border: 1px solid black;
            padding: 5px;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>All Employee Information</h1>

    <c:choose>
        <c:when test="${!empty EmpData.getContent()}">
            <table>
                <tr>
                    <th>Empno</th><th>empName</th><th>dept</th><th>job</th><th>salary</th><th>mgr</th><th>hiredate</th>Company<th>
                </tr>
                <c:forEach var="emp" items="${EmpData.getContent()}">
                    <tr>
                        <td>${emp.empno}</td>
                        <td>${emp.ename}</td>
                        <td>${emp.deptno}</td>
                        <td>${emp.job}</td>
                        <td>${emp.sal }</td>
                        <td>${emp.mgr}</td>
                        <td>${emp.hiredate}</td>
                        <td>${emp.comm}</td>
                        <td>
                            <a href="edit?no=${emp.empno}">Edit</a>
                            <a href="delete?no=${emp.empno}" onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table> 
            <a href="add_emp" style="text-align: center;">Add Employee</a>
          
            <p> 
                <c:if test="${EmpData.hasPrevious()}">
                    <a href="All_page?page=${EmpData.getPageable().previousOrFirst().pageNumber}">Previous</a>
                </c:if>
                <c:if test="${!EmpData.first}">
                    <a href="All_page?page=0">First</a>
                </c:if>
                <c:forEach var="i" begin="1" end="${EmpData.totalPages}" step="1">
                    [<a href="All_page?page=${i-1}">${i}</a>]
                </c:forEach>
                <c:if test="${EmpData.hasNext()}">
                    <a href="All_page?page=${EmpData.getPageable().next().pageNumber}">Next</a>
                </c:if>
                <c:if test="${!EmpData.last}">
                    <a href="All_page?page=${EmpData.totalPages - 1}">Last</a>
                </c:if>
            </p>	
        </c:when>
        <c:otherwise>
            <h1 style="color:red;text-align:center">Records not found</h1>
            <a href="add_emp" style="text-align: center;">Add Employee</a>
        </c:otherwise>
    </c:choose>
</body>
</html>
