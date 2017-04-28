<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Клиент</title>
    <link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/css/style.css' />" rel="stylesheet"></link>
</head>

<body>
    <div class="generic-container">
        <div class="well lead">Информация из базы</div>
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Статус</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="entry">
                <tr>
                    <td>${entry.key}</td>
                    <td>${entry.value.productName}</td>
                    <td>${entry.value.status}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>