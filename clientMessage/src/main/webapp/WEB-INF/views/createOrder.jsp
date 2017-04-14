<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<div class="well lead">Страница нового заказа</div>
 	<form:form method="POST" modelAttribute="order" class="form-horizontal">
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="productName">Название</label>
				<div class="col-md-7">
					<form:input type="text" path="productName" id="productName" class="form-control input-sm" required="required"/>
					<div class="has-error">
						<form:errors path="productName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="quantity">Количество</label>
				<div class="col-md-7">
					<form:input type="text" path="quantity" id="quantity" class="form-control input-sm" required="required"/>
					<div class="has-error">
						<form:errors path="quantity" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-actions floatRight">
                <input type="submit" value="Разместить заказ" class="btn btn-primary btn-sm"/>
                <input type="button" value="Отменить" onclick="location.href = '<c:url value="/home" />';" class="btn btn-primary btn-sm"/>
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>