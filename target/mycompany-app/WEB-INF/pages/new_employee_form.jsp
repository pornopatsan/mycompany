<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Новый Работник</title>
</head>
<body>
<input type="button" onclick="history.back();" value="Назад"/><br>
<form:form modelAttribute="personaldata" method="post" action="new_employee_personaldata">
    <form:hidden path="id"/>

    <b>Имя</b><br>
    <form:input path="firstName" value="${personaldata.firstName}"/><br>

    <b>Фамилия</b><br>
    <form:input path="lastName" value="${personaldata.lastName}"/><br>

    <b>Телефон</b><br>
    <form:input path="phone" value="${personaldata.phone}"/><br>

    <b>Email</b><br>
    <form:input path="email" value="${personaldata.email}"/><br>

    <b>Адрес</b><br>
    <form:input path="address" value="${personaldata.address}"/><br>

    <b>Образование</b><br>
    <form:input path="education" value="${personaldata.education}"/><br>

    <b>О себе</b><br>
    <form:textarea path="selfDescription" value="${personaldata.selfDescription}"/><br>

    <form:button value="new_employee_personaldata">Готово!</form:button>
</form:form>
</body>
</html>