<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Добавить отделение</title>
</head>
<input type="button" onclick="history.back();" value="Назад"/><br>
<form:form modelAttribute="employee" method="post" action="add_employee_department">
    <form:hidden path="id"/>

    <b>Новое Отделение</b><br>
    <form:select path="tmpJobId">
        <form:option value="-1" label="--Please Select"/>
        <form:options items="${departmentList}" itemValue="id" itemLabel="name"/>
    </form:select><br>

    <form:button value="add_employee_department">Готово!</form:button>
</form:form>
<body>
</body>
</html>
