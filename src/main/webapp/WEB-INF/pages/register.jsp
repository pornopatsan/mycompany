<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Регистрация</title>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
</head>
<body>
<h3><a href="main">Отмена</a></h3>
<form:form id="formCreate" modelAttribute="newPersonaldata" method="post" action="registersubmit">
    ИМЯ:
    <form:input path="firstName"/><br>
    ФАМИЛИЯ:
    <form:input path="lastName"/><br>
    <%--Дата Рождения:--%>
    <%--<form:input path="birthDate"/><br>--%>
    Телефон:
    <form:input path="phone"/><br>
    Email:
    <form:input path="email"/><br>
    Адрес:
    <form:input path="address"/><br>
    Образование:
    <form:input path="education"/><br>
    <form:button value="registersubmit"/>
</form:form>
</body>
</html>
