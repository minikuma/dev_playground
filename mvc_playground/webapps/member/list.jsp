<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>Member List</title>
</head>

<body>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>memberId</th>
        <th>name</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${members}" var="member" varStatus="status">
        <td>
            <th scope="row">${status.count}</th>
            <td>${member.memberId}</td>
            <td>${member.name}</td>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>