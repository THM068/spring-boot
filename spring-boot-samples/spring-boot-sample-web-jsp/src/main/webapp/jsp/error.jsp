
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
  <title>Internal Server Error</title>
</head>
<body>
<h1>Opps...</h1>
<p>Sorry, an error occurred.</p>
<p>General  error: </p>
    <pre>
        <% exception.printStackTrace(response.getWriter()); %>
    </pre>
</body>
</html>