<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>



<h1 style="color:red;text-align:center"> Employee registration page</h1>

<frm:form    modelAttribute="emp">
  <table border="0"  align="center" bgcolor="cyan">
    <tr>
      <td>Employee name::  </td>
      <td><frm:input path="ename"/> </td>
    </tr>
      <tr>
      <td>Employee JOB::  </td>
      <td><frm:input path="job"/> </td>
    </tr>
       <tr>
      <td>Employee Salary::  </td>
      <td><frm:input path="sal"/> </td>
    </tr>
    
      <tr>
      <td colspan="2"><input type="submit" value="register"></td>
    </tr>
  </table>
  
</frm:form>