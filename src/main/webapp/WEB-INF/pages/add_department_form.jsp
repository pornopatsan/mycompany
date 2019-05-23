<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Новое Отеделение</title>
</head>
<body>
<input type="button" onclick="history.back();" value="Назад"/><br>
<form:form modelAttribute="department" method="post" action="add_department?headId=${headId}">
    <form:hidden path="id"/>

    <b>Название</b><br>
    <form:input path="name" value="${department.name}"/><br>

    <b>Офис</b><br>
    <form:select path="tmpOfficeId">
        <form:option value="${null}" label="--Please Select"/>
        <form:options items="${offices}" itemValue="id" itemLabel="address"/>
    </form:select><br>

    <b>Описание</b><br>
    <form:textarea path="description" value="${department.description}"/><br>

    <form:button value="add_department?headId=${headId}">Готово!</form:button>
</form:form>
</body>
</html>