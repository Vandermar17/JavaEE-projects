<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 14.02.2020
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>${title}</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/" method="post">
    <div>
      <input type="text" placeholder="Enter Username" name="uname" required>
      <input type="password" placeholder="Enter Password" name="psw" required>
      <button type="submit">Login</button>
  </div>
  </form>
  </body>
</html>
