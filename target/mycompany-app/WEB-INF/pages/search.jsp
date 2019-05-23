<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<body>
<h2> Поиск по сотрудникам </h2>
<h3><a href="${pageContext.request.contextPath}/company/main">На главную</a></h3>
<a href="${pageContext.request.contextPath}/company/search_results">Показать Всех!</a><br>
<form:form modelAttribute="params" method="post" action="search">
    <b>Id</b><br>
    <form:input path="id" value="-1"/><br>
    <b>jobId</b><br>
    <form:input path="jobId" value="-1"/><br>
    <b>departmentId</b><br>
    <form:input path="departmentId" value="-1"/><br>

    <b>Минимальная зарплата</b><br>
    <form:input path="salaryDownLimit" value="-0.0"/><br>
    <b>Максимальная зарплата</b><br>
    <form:input path="salaryUpLimit" value="999999.0"/><br>

    <b>Имя</b><br>
    <form:input path="firstName" value=""/><br>
    <b>Фамилия</b><br>
    <form:input path="lastName" value=""/><br>

    <form:button value="search">Готово</form:button>
</form:form>
</body>
</html>
