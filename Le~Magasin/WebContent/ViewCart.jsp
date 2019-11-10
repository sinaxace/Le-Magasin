<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">

<title>View Cart</title>

</head>
<style>
    td {
        border: black, 5px, solid;
        font-size: 25px;
    }

    table {
        margin: 10px;
        position: relative;
        left: 350px;
    }

    a {
    	font-size: 20px;
    	background: white;
        text-decoration: none;
        color: black;
        padding: 10px;
        margin: 30px;
    }
    
    nav {
    	position: relative;
    	left: 550px;
    	top: 10px;
    }
</style>
<body>
	<h1 style="text-align:center">Cart Items</h1>
	
	<table>
		<tr><td><strong>Outfit</strong></td><td><strong>Price</strong></td></tr>
		<c:forEach var="item" items="${shoppingCart}">
			<tr>
				<td>${ item.getName() }</td><td>${ item.getPrice() }</td>
			</tr>
		</c:forEach>
	</table>
	<nav>
		<a href=Home.html>Continue Shopping</a>
		<a href=Checkout.jsp>Checkout</a>
	</nav>
</body>
</html>