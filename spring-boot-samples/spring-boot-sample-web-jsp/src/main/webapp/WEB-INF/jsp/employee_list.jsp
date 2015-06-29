<%--
  Created by IntelliJ IDEA.
  User: thandomafela
  Date: 28/06/15
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee List</title>
    <jsp:include page="_cssTemplate.jsp" />
</head>
<body>
  <h3><spring:message code="employee.list.title" /> </h3>

  <ul>
    <c:forEach items="${employeeList}" var="emp">
      <li>
        <c:out value="${emp.getName()}" />
        &nbsp;<c:out value="${emp.getLastName()}" />
        &nbsp;<c:out value="${emp.getAge()}" />
      </li>
    </c:forEach>
  </ul>

</body>
</html>
