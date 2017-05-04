<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Получатель</title>
        <link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/css/style.css' />" rel="stylesheet"></link>
    </head>

    <body>
        <div class="generic-container">
            <div class="alert alert-success lead">
                Уведомления успешно доставлены!
            </div>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>Публичный-ID</th>
                    <th>Уведомление</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="entry">
                    <tr>
                        <td>${entry.value.publicId}</td>
                        <td>${entry.value.message}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="row">
                <div class="form-actions floatRight">
                    <input type="button" value="Проверить" onclick="location.href = '<c:url value="/" />';" class="btn btn-primary btn-sm"/>
                </div>
            </div>
        </div>
    </body>
</html>