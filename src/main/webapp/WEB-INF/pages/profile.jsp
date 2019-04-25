<%@ page  language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
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

<div>
    <table>
        <tr><th>Данные Сотрудника</th><th></th></tr>
        <tr><td>Id Работника</td><td><c:out value="${employee.id}"/></td></tr>
        <tr><td>Должность</td><td><c:out value="${job.function}"/></td></tr>
        <tr><td>Должность ??</td><td><c:out value="${employee.jobsByJobId.function}"/></td></tr>
        <tr><td>Зарплата</td><td><c:out value="${employee.salary}"/></td></tr>
        <tr><td>Работает с</td><td><c:out value="${employee.hireDate}"/></td></tr>
    </table>
</div>

<div>
    <table>
        <tr><th>Персональные Данные</th><th></th></tr>
        <tr><td>Имя</td><td><c:out value="${personaldata.firstName}"/></td></tr>
        <tr><td>Фамилия</td><td><c:out value="${personaldata.lastName}"/></td></tr>
        <tr><td>Дата Рождения</td><td><c:out value="${personaldata.birthDate}"/></td></tr>
        <tr><td>Телефон</td><td><c:out value="${personaldata.phone}"/></td></tr>
        <tr><td>e-mail</td><td><c:out value="${personaldata.email}"/></td></tr>
        <tr><td>Адрес</td><td><c:out value="${personaldata.address}"/></td></tr>
        <tr><td>Образование</td><td><c:out value="${personaldata.education}"/></td></tr>
    </table>
    <p>О себе: <c:out value="${personaldata.selfDescription}"/></p>
</div>

<div>
    <h6>История Должностей:</h6>
    <table>
        <tr><th>Должность</th><th>Дата Назначения</th><th>Дата Снятия</th></tr>
        <%--<c:forEach items="${jobsHistory}" var="item">--%>
            <%--<tr>--%>
                <%--<td><c:out value="${item.jobsByJobId.function}"/></td>--%>
                <%--<td><c:out value="${item.appointment}"/></td>--%>
                <%--<td><c:out value="${item.removal}"/></td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    </table>
</div>

</body>
</html>
