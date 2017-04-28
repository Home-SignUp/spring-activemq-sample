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
        <div class="row">
            <table>
                <tr>
                    <th>msg:</th>
                    <td>${msg}</td>
                </tr>
                <tr>
                    <th>user:</th>
                    <td>${user}</td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>