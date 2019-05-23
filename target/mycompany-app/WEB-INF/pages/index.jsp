<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head><title>Главная</title></head>
<body>
<h2> (DEMO) Пользователи </h2>
<a href="${pageContext.request.contextPath}/company/new_employee_form">Новый Работник</a><br>
<a href="${pageContext.request.contextPath}/company/search">Искать работников</a><br>

<table width="60%">
    <tr>
        <th>Наши Оффисы</th>
    </tr>
    <tr>
        <th>
            <table width="100%" border="1" cellpadding="4" valign="top">
                <tr>
                    <th>Адрес</th>
                    <th>Телефон</th>
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
    </tr>
</table>

<table width="60%">
    <tr>
        <th>Наши Отделения</th>
    </tr>
    <tr>
        <th>
            <table width="100%" border="1" cellpadding="4" valign="top">
                <tr>
                    <th>Название</th>
                    <th>Офис</th>
                    <th>Описание</th>
                </tr>
                <c:forEach items="${departments}" var="item">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/company/department/${item.id}">
                        <c:out value="${item.name}"/><br>
                        </a></td>
                        <td><c:out value="${item.officeByOfficeId.address}"/><br></td>
                        <td><c:out value="${item.description}"/><br></td>
                    </tr>

                </c:forEach>
            </table>
        </th>
    </tr>
</table>

<table width="60%">
    <tr>
        <th>Наши Руководители</th>
    </tr>
    <tr>
        <th>
            <table width="100%" border="1" cellpadding="4" valign="top">
                <tr>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Почта</th>
                </tr>
                <c:forEach items="${presidents}" var="item">
                <tr>
                    <td><c:out value="${item.personaldataByPersonalId.firstName}"/><br></td>
                    <td><c:out value="${item.personaldataByPersonalId.lastName}"/><br></td>
                    <td><c:out value="${item.personaldataByPersonalId.email}"/><br></td>
                    <td><a href="${pageContext.request.contextPath}/company/profile/${item.id}">
                        <c:out value="${item.id}"/><br>
                    </a></td>
                </tr>

                </c:forEach>
            </table>
        </th>
    </tr>
</table>
</body>
</html>
