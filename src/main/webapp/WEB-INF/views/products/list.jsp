<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" >

<title>Lista de Produtos</title>
</head>
<body>

	<div>
		${sucesso}
	</div>

	<table class="table">
		<thead>
		<tr>
			<th>Título</th>
			<th>Valores</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.title }</td>
				<td>
					<c:forEach items="${product.prices }" var="price">
						[${price.value } - ${price.bookType }]
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
    <div>
    	
    </div>
    <div>
    	<a href="./form">Novo Produto</a>
    </div>
    
</body>
</html>