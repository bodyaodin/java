<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>User</title>
   </head>

   <body>
      <h2>Submitted User Information</h2>
      <table>
         <tr>
            <td>Username</td>
            <td>${username}</td>
         </tr>
         <tr>
            <td>Firstname</td>
            <td>${firsname}</td>
         </tr>
         <tr>
            <td>Lastname</td>
            <td>${lastname}</td>
         </tr>
      </table>
   </body>

</html>