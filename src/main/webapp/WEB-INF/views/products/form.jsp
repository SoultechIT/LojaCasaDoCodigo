<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<title>Cadastro de Produtos</title>
</head>
<body>

	<%-- <spring:hasBindErrors name="product">
	<ul>
		<c:forEach var="error" items="${errors.allErrors}">
			<li class="list-group-item-danger">
				<spring:message code="${error.code }" text="${error.defaultMessage }"/>
			</li>
		</c:forEach>
	</ul>
	</spring:hasBindErrors> --%>

    <form:form method="post" action="${spring:mvcUrl('PC#save').build()}" commandName="product">
    	<div class="form-group">
    		<label for="title">Título</label>
    		<!-- <input type="text" class="form-control" name="title" id="title"> -->
    		<form:input class="form-control" path="title"/>
    		<div class="text-danger"><form:errors path="title"/></div>
    	</div>
    	<div class="form-group">
    		<label for="description">Descrição</label>
    		<!-- <textarea rows="4" cols="20" class="form-control" name="description" id="description"></textarea> -->
    		<form:textarea class="form-control" path="description" rows="4" cols="20"/>
    		<div class="text-danger"><form:errors path="description"/></div>
    	</div>
    	<div class="form-group">
    		<label for="pages">Numero de Páginas</label>
    		<!-- <input type="text" class="form-control" name="pages" id="pages"> -->
    		<form:input class="form-control" path="pages"/>
    		<div class="text-danger"><form:errors path="pages"/></div>
    	</div>
    	<div class="form-group">
    		<c:forEach items="${types}" var="bookType" varStatus="status">
    		<div>
    			<label for="price_${bookType }">${bookType}</label>
    			<input type="text" class="form-control" name="prices[${status.index}].value" id="preco_${bookType}"/>
				<input type="hidden" name="prices[${status.index}].bookType" value="${bookType}"/>
    		</div>
    		</c:forEach>
    	</div>
    	<div>
    		<input type="submit" value="enviar">
    	</div>
    </form:form>
</body>
</html>