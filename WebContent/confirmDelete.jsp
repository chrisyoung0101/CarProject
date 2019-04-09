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
<style> 
#grad1 {
  height: 700px;
  background-color: #cccccc;
  background-image: linear-gradient(red, yellow);
}
</style>
</head>
<body id="grad1">
	
	
	<div class="space250"></div>

			<h1 class="center">Delete confirmed!</h1>
			
	<div class="center">

	<a class="big" href="index.jsp">HOME</a>
	
	
	
	
	
	
	

</body>
</html>