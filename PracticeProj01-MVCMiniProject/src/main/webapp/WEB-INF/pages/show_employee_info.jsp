<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
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
<h1 style="color: maroon; text-align: center;">All Employee Information</h1>
<c:choose>

    <c:when test="${not empty empList}">
        <table>
            <tr>
                <th>EmpId</th>
                <th>empName</th>
                <th>dept</th>
                <th>job</th>
                <th>salary</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="emp" items="${empList}">
                <tr>
                    <td>${emp.empid}</td>
                    <td>${emp.ename}</td>
                    <td>${emp.dept}</td>
                    <td>${emp.job}</td>
                    <td>${emp.salary }</td>
                    <td>${emp.status}</td>
                    <td>
                        <a href="edit?no=${emp.empid}">Edit</a>
                        <a href="delete?no=${emp.empid}" onclick="return confirm('Are you sure you want to delete the employee?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div style="text-align: center;">
            <a href="add_emp">Add Employee</a>
        </div>
    </c:when>
    
    <c:otherwise>
        <h1 style="color: red; text-align: center;">Records not found</h1>
        <div style="text-align: center;">
            <a href="add_emp">Add Employee</a>
        </div>
    </c:otherwise>

</c:choose>
</body>
</html>
