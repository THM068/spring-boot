<%--
  Created by IntelliJ IDEA.
  User: thandomafela
  Date: 28/06/15
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Employee</title>
</head>
<body>
  <h3><spring:message code="employee.header.message"/></h3>

  <form:form action="/employee/save_emp.html" modelAttribute="employee">
    <form:errors path="" element="DIV" />
      <div>
        <form:label path="name">
          <spring:message code="employee.name.title" />
        </form:label>
        <form:input path="name" />
        <form:errors path="name" />
      </div>
      <div>
        <form:label path="lastName">
          <spring:message code="employee.lastName.title"/>
          <form:input path="lastName"/>
          <form:errors path="lastName" />
        </form:label>
      </div>
      <div>
        <form:label path="socialSecurity">
          <spring:message code="employee.socialSecurity.title" />
          <form:input path="socialSecurity"/>
          <form:errors path="socialSecurity" />
        </form:label>
      </div>
    <div>
      <form:label path="age">
        <spring:message code="employee.age.title" />
        <form:input path="age"/>
        <form:errors path="age" />
      </form:label>
    </div>
    <div>
      <input type="submit" value="Submit"/>
    </div>

  </form:form>

  <form:form action="/employee/upload" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit" value="Upload">
  </form:form>
</body>
</html>
