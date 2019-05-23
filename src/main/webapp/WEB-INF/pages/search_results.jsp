<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<body>
<a href="${pageContext.request.contextPath}/company/search">Назад</a><br>
<h2> (DEMO) Результаты поиска </h2>
<h4>Наши Сотрудники</h4>
<table width="80%" border="1" cellpadding="4" cellspacing="1" valign="top">
        <tr>
            <th>Id</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Должность</th>
            <th>Зарплата</th>
            <th></th>
        </tr>
        <c:forEach items="${resList}" var="item">
        <tr>
            <td><c:out value="${item.id}"/></td>
            <td><c:out value="${item.personaldataByPersonalId.firstName}"/></td>
            <td><c:out value="${item.personaldataByPersonalId.lastName}"/></td>
            <td><c:out value="${item.jobsByJobId.function}"/></td>
            <td><c:out value="${item.salary}"/></td>
            <td><a href="profile/${item.id}">Профиль</a></td>
        </tr>
        </c:forEach>
</table>
</body>
</html>
