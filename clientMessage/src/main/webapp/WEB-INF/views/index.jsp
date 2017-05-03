<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" Content="text/html; Charset=UTF-8">
        <title>Отправитель</title>
        <link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/css/style.css' />" rel="stylesheet"></link>
    </head>

    <body>
        <div class="generic-container">
            <div class="well lead">Добро пожаловать на страницу уведомлений</div>
            <div class="row">
                <div class="form-actions floatRight">
                    <input type="button" value="Написать уведомление" onclick="location.href = '<c:url value="/newOrder" />';" class="btn btn-primary btn-sm"/>
                </div>
                <div class="form-actions floatRight">
                    <input type="button" value="Проверить состояние" onclick="location.href = '<c:url value="/checkStatus" />';" class="btn btn-primary btn-sm"/>
                </div>
            </div>
        </div>
    </body>
</html>