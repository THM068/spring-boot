<%--
  Created by IntelliJ IDEA.
  User: tm1c14
  Date: 26/06/2015
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
  <title>Internal Server Error</title>
</head>
<body>
<h1>Opps...</h1>
<p>Sorry, an error occurred.</p>
<p>An internal server error: </p>
    <pre>
        <% exception.printStackTrace(response.getWriter()); %>
    </pre>
</body>
</html>