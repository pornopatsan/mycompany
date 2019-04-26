<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<body>
<h2> (DEMO) Пользователи </h2>
<h3><a href="register.jsp">Зарегистрироваться</a></h3>
<table width="100%">
    <tr>
        <th>Наши Оффисы</th>
        <th>Наши Сотрудники</th>
    </tr>
    <tr>
        <th>
            <table width="100%" border="1" cellpadding="4" valign="top">
                <tr>
                    <th>Телефон</th>
                    <th>Адрес</th>
                    <th>Описание</th>
                </tr>
                <c:forEach items="${offices}" var="item">
                    <td>
                        <c:out value="${item.address}"/><br>
                        <c:out value="${item.locationByLocationId.country}"/><br>
                        <c:out value="${item.locationByLocationId.region}"/><br>
                    </td>
                    <td><c:out value="${item.phone}"/></td>
                    <td><c:out value="${item.description}"/></td>
                </c:forEach>
            </table>
        </th>
        <th>
            <table width="100%" border="1" cellpadding="4" cellspacing="1" valign="top">
                <tr>
                    <th>Id</th>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Должность</th>
                    <th></th>
                </tr>
                <c:forEach items="${employee}" var="item">
                    <tr>
                        <td><c:out value="${item.id}"/></td>
                        <td><c:out value="${item.personaldataByPersonalId.firstName}"/></td>
                        <td><c:out value="${item.personaldataByPersonalId.lastName}"/></td>
                        <td><c:out value="${item.jobsByJobId.function}"/></td>
                        <td><a href="profile/${item.id}">Профиль</a></td>
                    </tr>
                </c:forEach>
            </table>
        </th>
    </tr>
</table>
<br>
<table width="80%" border="2" cellpadding="4" cellspacing="1">
    <caption>Убрать, пока для дебага</caption>
    <tr>
        <th>Id</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>birthDate</th>
        <th>phone</th>
        <th>email</th>
        <th>address</th>
        <th>education</th>
        <th>О себе</th>
    </tr>
    <c:forEach items="${persons}" var="item">
        <tr>
            <td><c:out value="${item.id}"/></td>
            <td><c:out value="${item.firstName}"/></td>
            <td><c:out value="${item.lastName}"/></td>
            <td><c:out value="${item.birthDate}"/></td>
            <td><c:out value="${item.phone}"/></td>
            <td><c:out value="${item.email}"/></td>
            <td><c:out value="${item.address}"/></td>
            <td><c:out value="${item.education}"/></td>
            <td><c:out value="${item.selfDescription}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
