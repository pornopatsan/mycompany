<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<body>
<h2> (DEMO) Поиск по сотрудникам </h2>
<h3><a href="${pageContext.request.contextPath}/company/main">На главную</a></h3>
<a href="${pageContext.request.contextPath}/company/search_results">Вперед!</a><br>
<form:form modelAttribute="params" method="post" action="search">
    <b>Id</b><br>
    <form:input path="id" value="-1"/><br>
    <b>jobId</b><br>
    <form:input path="jobId" value="-1"/><br>
    <b>salaryDownLimit</b><br>
    <form:input path="salaryDownLimit" value="-0.0"/><br>
    <b>salaryUpLimit</b><br>
    <form:input path="salaryUpLimit" value="999999.0"/><br>
    <form:button value="search">Готово</form:button>
</form:form>
</body>
</html>
