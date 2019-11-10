<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">

<title>Checkout</title>

</head>
<style>
	body {
		text-align: center;
	}
    a {
    	font-size: 20px;
    	background: white;
        text-decoration: none;
        color: black;
        padding: 10px;
        margin: 30px;
    }
    #total {
    	margin: 30px 230px;
    	background-color: white;
    	padding: 30px;
    	font-size: 30px;
    	width: 1000px;
    	
    }
</style>

<body>
	<div id=total>
		<h1>Total Amount</h1>		
			<c:set var="total" value="0" scope="page" />
			<c:forEach var="item" items="${shoppingCart}">
				<c:set var="total" value="${total + item.getPrice()}" />
			</c:forEach>
			<p>
				Before Tax <br> <strong><c:out value = "${total}"/> </strong> <br>
				
				<%-- 13% tax rate in Ontario --%>
				<c:set var="total" value="${total + (total*0.13)}" />
				After 13% HST <br> <strong><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${total}" /> </strong> 
			</p>
	</div>
	<a href=Home.html>Continue Shopping</a>
</body>
</html>