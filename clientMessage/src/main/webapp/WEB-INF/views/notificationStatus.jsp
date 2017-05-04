<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Отправитель</title>
	<link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/css/style.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div class="generic-container">
		<div class="well lead">Состояние уведомлений</div>
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th>Получатель (ID)</th>
                    <th>Публичный-ID</th>
					<th>Уведомление</th>
					<th>Состояние</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="entry">
				<tr>
					<td>${entry.key}</td>
                    <td>${entry.value.publicId}</td>
					<td>${entry.value.message}</td>
					<td>${entry.value.status}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
        <div class="row">
            <div class="form-actions floatRight">
                <input type="button" value="Написать уведомление" onclick="location.href = '<c:url value="/newNotification" />';" class="btn btn-primary btn-sm"/>
            </div>
            <div class="form-actions floatRight">
                <input type="button" value="Проверить состояние" onclick="location.href = '<c:url value="/checkStatus" />';" class="btn btn-primary btn-sm"/>
            </div>
        </div>
	</div>
</body>
</html>