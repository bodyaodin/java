<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Add User</title>
   </head>

   <body>
      <h2>User Information</h2>
      <form:form method = "POST" action = "postUser">
         <table>
            <tr>
               <td><form:label path = "id">ID</form:label></td>
               <td><form:input path = "id" /></td>
            </tr>
            <tr>
               <td><form:label path = "username">Username</form:label></td>
               <td><form:input path = "username" /></td>
            </tr>
            <tr>
               <td><form:label path = "firstname">Firstname</form:label></td>
               <td><form:input path = "firstname" /></td>
            </tr>
            <tr>
               <td><form:label path = "lastname">Lastname</form:label></td>
               <td><form:input path = "lastname" /></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>
      </form:form>
   </body>

</html>