<%--
  Created by IntelliJ IDEA.
  User: tm1c14
  Date: 26/06/2015
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create a User</title>
    <jsp:include page="_cssTemplate.jsp" />
</head>
<body>
    <h1><spring:message code="user.create" /> </h1>

    <a href="<spring:url value="/user/user_list.html" />">User list</a>

    <form:form method="POST" action="/user/user_save.html" modelAttribute="form">
      <form:errors element="DIV" path="" />

      <div>
          <form:label path="username">
              <spring:message code="user.id"/>
          </form:label>
          <form:input path="username" />
          <form:errors path="username" />
      </div>

      <div>
        <form:label path="password1">
          <spring:message code="user.password1" />
        </form:label>
        <form:password path="password1"/>
        <form:errors path="password1" />
      </div>

      <div>
        <form:label path="password2">
          <spring:message code="user.password2"/>
        </form:label>
        <form:password  path="password2"/>
        <form:errors  path="password2"/>
      </div>

      <div>
        <input type="submit" value="Submit"/>
      </div>

    </form:form>
</body>
</html>
