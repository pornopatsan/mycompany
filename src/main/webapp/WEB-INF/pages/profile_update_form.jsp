<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Изменения Профиля</title>
</head>
<input type="button" onclick="history.back();" value="Назад"/><br>
<form:form modelAttribute="personalData" method="post" action="profile_update">
    <form:hidden path="id"/>

    <b>Имя</b><br>
    <form:input path="firstName" value="${personalData.firstName}"/><br>

    <b>Фамилия</b><br>
    <form:input path="lastName" value="${personalData.lastName}"/><br>

    <b>Телефон</b><br>
    <form:input path="phone" value="${personalData.phone}"/><br>

    <b>Email</b><br>
    <form:input path="email" value="${personalData.email}"/><br>

    <b>Адрес</b><br>
    <form:input path="address" value="${personalData.address}"/><br>

    <b>Образование</b><br>
    <form:input path="education" value="${personalData.education}"/><br>

    <b>О себе</b><br>
    <form:textarea path="selfDescription" value="${personalData.selfDescription}"/><br>

    <form:button value="profile_update">Изменить</form:button>
</form:form>
<body>

</body>
</html>
