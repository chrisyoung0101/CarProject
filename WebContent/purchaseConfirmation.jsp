<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <!-- import jstl if we need to use jstl on the same page  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- import object  -->
<%@ page import="com.user.Car" %>

<!-- import ArrayList  -->
<%@page import="java.util.ArrayList" %>

<% ArrayList<Car> carCards = (ArrayList<Car>) session.getAttribute("carCards"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./styles/styles.css">
<title>Insert title here</title>
</head>
<body>

	<div class="space250"></div>

			<h1 class="center">Thanks for your purchase!</h1>
			<h3 class="center">Order Confirmed</h3>
			<br><br>
			
	<div class="center">

	<a class="big" href="index.jsp">HOME</a>
	
	</div>
	
	
	<h4 class="right100">Note to admin : since our tech staff is still learning... </h4>
	<h3 class="right100">Click here to manually delete this car now please!</h3>
	<span class="right100"></span>
	<a class="big" href="deleteCar.jsp">DELETE</a>
	
	

</body>
</html>