<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Регистрация</title>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
</head>
<body>
<input type="button" onclick="history.back();" value="Назад"/><br>
<form:form id="formCreate" modelAttribute="newPersonaldata" method="post" action="registersubmit">

    <b>Имя</b><br>
    <form:input path="firstName" value="${newPersonaldata.firstName}"/><br>

    <b>Фамилия</b><br>
    <form:input path="lastName" value="${newPersonaldata.lastName}"/><br>

    <b>Телефон</b><br>
    <form:input path="phone" value="${newPersonaldata.phone}"/><br>

    <b>Email</b><br>
    <form:input path="email" value="${newPersonaldata.email}"/><br>

    <b>Адрес</b><br>
    <form:input path="address" value="${newPersonaldata.address}"/><br>

    <b>Образование</b><br>
    <form:input path="education" value="${newPersonaldata.education}"/><br>

    <b>О себе</b><br>
    <form:textarea path="selfDescription" value="${newPersonaldata.selfDescription}"/><br>

    <form:button value="registersubmit">Готово</form:button>
</form:form>
</body>
</html>
