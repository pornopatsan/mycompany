<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Регистрация</title>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
</head>
<body>
<form:form id="formCreate" modelAttribute="newPersonaldata" method="post" action="submit">
    ИМЯ:
    <form:input path="firstName"/>
    <%--ФАМИЛИЯ:--%>
    <%--<form:input path="lastName"/>--%>
    <%--<form:button value="submit" name="Готово!"/>--%>
</form:form>
</body>
</html>
