<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>

<h2 style="color:maroon; text-align: center"> Employee Registration Page</h2>

   <frm:form  modelAttribute="info" enctype="multipart/form-data">
       <table border="0" bgcolor="cyan"  align="center">
           <tr>
              <td>Name ::</td>
              <td><frm:input path="jsname"/></td>
           </tr>
           <tr>
              <td>Addrs ::</td>
              <td><frm:input path="jsadd"/></td>
           </tr>
           <tr>
              <td>select resume ::</td>
              <td><frm:input type="file" path="resumePath"/></td>
           </tr>
           <tr>
              <td>select photo ::</td>
              <td><frm:input type="file" path="photoPath"/></td>
           </tr>
           <tr>
             <td><input type="submit" value="register"></td>
           </tr>
           
       </table>       
   </frm:form>

