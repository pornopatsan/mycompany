<%@ page  language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Отделение</title>
</head>
<body>
<h2>Страница Отделения:
    <c:out value="${department.name}"/>
</h2>
<h3><a href="${pageContext.request.contextPath}/company/main">На главную</a></h3>

<table>
    <tr>
        <th>Данные Об Отделении</th>
        <th></th>
    </tr>
    <tr>
        <td>Id</td>
        <td><c:out value="${department.id}"/></td>
    </tr>
    <tr>
        <td>Название</td>
        <td><c:out value="${department.name}"/></td>
    </tr>
    <tr>
        <td>Под управлением</td>
        <td>
            <a href="${pageContext.request.contextPath}/company/department/${department.departmentByHeadId.id}">
                <c:out value="${department.departmentByHeadId.name}"/>
            </a>
        </td>
    </tr>
    <tr>
        <td>Адрес Офиса</td>
        <td>
            <span><c:out value="${department.officeByOfficeId.address}"/></span>
            <span><c:out value="${department.officeByOfficeId.locationByLocationId.region}"/></span>
            <span><c:out value="${department.officeByOfficeId.locationByLocationId.country}"/></span>
        </td>
    </tr>
</table>

<table border="1" width="50%">
    <tr>
        <th>Отделения под управлением</th>
    </tr>
    <c:forEach items="${departments}" var="item">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/company/department/${item.id}">
                    <c:out value="${item.name}"/>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<table border="1" width="50%">
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Фамилия</th>
    </tr>
    <c:forEach items="${employee}" var="item">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/company/profile/${item.id}">
                    <c:out value="${item.id}"/>
                </a>
            </td>
            <td>
                <c:out value="${item.personaldataByPersonalId.firstName}"/>
            </td>
            <td>
                <c:out value="${item.personaldataByPersonalId.lastName}"/>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
