<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Новый Работник</title>
</head>
<input type="button" onclick="history.back();" value="Назад"/><br>
<form:form modelAttribute="employee" method="post" action="new_employee">
    <form:hidden path="id"/>
    <form:hidden path="tmpPersonalId"/>

    <b>Зарплата</b><br>
    <form:input path="salary" value="${employee.salary}"/><br>

    <b>Должность</b><br>
    <form:select path="tmpJobId">
        <form:option value="${null}" label="--Please Select"/>
        <form:options items="${jobsList}" itemValue="id" itemLabel="function"/>
    </form:select><br>

    <form:button value="new_employee">Готово!</form:button>
</form:form>
<body>
</body>
</html>