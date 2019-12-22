<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
	<div align="center">
		<h1>Product List</h1>
		<table>
			<tr>
				<th>No</th>
				<th>Image</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Sale</th>
				<th>Price</th>
				<th>Old_price</th>
				<th>Offer</th>
				<th>Total_rating</th>


			</tr>
			<c:forEach items="${listProduct}" var="product" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td><img src="${product.img_url}"></td>
					<td>${product.name}</td>
					<td>${product.brand}</td>
					<td>${product.sale}</td>
					<td>${product.price}</td>
					<td>${product.old_price}</td>
					<td>${product.offer}</td>
					<td>${product.total_rating}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>