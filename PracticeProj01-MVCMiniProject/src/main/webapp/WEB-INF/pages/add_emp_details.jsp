<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>


<h2 style="text-align: center; color: navy;">Employee registration</h2>

<frm:form modelAttribute="emp" >
<table style="border-style: solid; background-color: cyan; border:1" >
  <tr>
    <td>Name</td>
    <td><frm:input path="ename" /></td>
  </tr>
  <tr>
    <td>Salary</td>
    <td><frm:input path="salary"/></td>
  </tr>
  <tr>
    <td>job</td>
    <td><frm:input path="job"/></td>
  </tr>
  <tr>
    <td>department</td>
    <td><frm:input path="dept"/></td>
  </tr>
  <tr>
    <td>Status</td>
    <td><frm:input path="status"/></td>
  </tr>
  <tr>
    <td> <input type="submit" value="register"></td>
    <td><input type="reset" value="clear"></td>
  </tr>




</table>
</frm:form>