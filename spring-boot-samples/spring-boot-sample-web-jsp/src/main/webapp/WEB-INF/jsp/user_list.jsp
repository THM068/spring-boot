<%--
  Created by IntelliJ IDEA.
  User: tm1c14
  Date: 26/06/2015
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
    <title>User List</title>
</head>
<body>
  <h1><spring:message code="user.list"/> </h1>
  
  <ul>
    <c:forEach items="${users}" var="user">
      <li>
        <c:out value="${user.getUsername()}" />
      </li>
    </c:forEach>
  </ul>

  <a href="<spring:url value="/user/user_create.html?new" /> ">
    <spring:message code="user.create" />
  </a>
</body>
</html>
