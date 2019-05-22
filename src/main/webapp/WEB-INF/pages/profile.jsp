<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Профиль</title>
</head>

<body>
<h2>Страница Работника:
    <c:out value="${personaldata.lastName}"/>
    <c:out value="${personaldata.firstName}"/>
</h2>
<h3><a href="${pageContext.request.contextPath}/company/main">На главную</a></h3>
<table>
    <tr>
        <th>Данные Сотрудника</th>
        <th><a href="${pageContext.request.contextPath}/company/employee_promote_form?id=${employee.id}">Повысить</a></th>
    </tr>
    <tr>
        <td>Id Работника</td>
        <td><c:out value="${employee.id}"/></td>
    </tr>
    <tr>
        <td>Должность</td>
        <td><c:out value="${employee.jobsByJobId.function}"/></td>
    </tr>
    <tr>
        <td>Зарплата</td>
        <td><c:out value="${employee.salary}"/></td>
    </tr>
    <tr>
        <td>Работает с</td>
        <td><c:out value="${employee.hireDate}"/></td>
    </tr>
</table>

<table border="1" width="50%">
    <tr>
        <th>Персональные Данные</th>
        <th><a href="${pageContext.request.contextPath}/company/profile_update_form?id=${personaldata.id}">Изменить</a></th>
    </tr>
    <tr>
        <td>Имя</td>
        <td><c:out value="${personaldata.firstName}"/></td>
    </tr>
    <tr>
        <td>Фамилия</td>
        <td><c:out value="${personaldata.lastName}"/></td>
    </tr>
    <tr>
        <td>Дата Рождения</td>
        <td><c:out value="${personaldata.birthDate}"/></td>
    </tr>
    <tr>
        <td>Телефон</td>
        <td><c:out value="${personaldata.phone}"/></td>
    </tr>
    <tr>
        <td>e-mail</td>
        <td><c:out value="${personaldata.email}"/></td>
    </tr>
    <tr>
        <td>Адрес</td>
        <td><c:out value="${personaldata.address}"/></td>
    </tr>
    <tr>
        <td>Образование</td>
        <td><c:out value="${personaldata.education}"/></td>
    </tr>
</table>
<p spellcheck="true">О себе: <c:out value="${personaldata.selfDescription}"/></p>

<table border="0" width="50%">
    <caption>Отделения, в которых работает сотрудник</caption>
    <c:forEach items="${employee.employeeDepartmentsById}" var="item">
        <tr>
            <td><c:out value="${item.departmentByDepartmentId.name}"/></td>
        </tr>
    </c:forEach>
</table>

<table border="1" width="50%">
    <caption>История Должностей</caption>
    <tr>
        <th>Должность</th>
        <th>Дата Назначения</th>
        <th>Дата Снятия</th>
        <th>Зарплата</th>
    </tr>
    <c:forEach items="${jobsHistory}" var="item">
        <tr>
            <td><c:out value="${item.jobsByJobId.function}"/></td>
            <td><c:out value="${item.appointment}"/></td>
            <td><c:out value="${item.removal}"/></td>
            <td><c:out value="${item.salary}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
