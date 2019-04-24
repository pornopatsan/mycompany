<%@ page  language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
<h2> Hello, Table! </h2>
<table>
    <tr>
        <th>Id</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>birthDate</th>
        <th>phone</th>
        <th>email</th>
        <th>address</th>
        <th>education</th>
        <th>selfDescription</th>
    </tr>
    <c:forEach items="${list}" var="item">
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
