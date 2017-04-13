<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Product Order System</title>
	<link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/css/style.css' />" rel="stylesheet"></link>
</head>

<body>

	<div class="generic-container">
	<div class="well lead">Dobro poshalovat v systemu zakazov</div>
			<span class="well floatRight">
				<a href="<c:url value='/newOrder' />">Oformit zakaz</a>
			</span>
	</div>

</body>
</html>