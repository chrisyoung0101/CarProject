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

	 	<!--Import Google Icon Font-->
      	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	
		<!-- Compiled and minified CSS -->
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<title>Transaction Report</title>

<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>

<style> 
#grad1 {
  height: 700px;
  background-color: #cccccc;
  background-image: linear-gradient(magenta, red);
	}
</style>


</head>

<!-- background-color:powderblue;  -->

<body style="margin:50px;" id="grad1">

<img src="./shark.JPEG" style="width:100px;height:60px;">

<form action="ShowTransactions" method="get">
  <input type="submit" value="Submit">
</form>
  
  
  
  				<!-- <h2>Transaction Report Generated!</h2> -->

<table>
  <tr>
  	<th>Date Purchased</th>
    <th>Car Description</th>
    <th>Sell Price</th>
    <th>Customer Name</th>
    <th>Customer Email</th>
  </tr>
  
  <c:forEach var="transaction" items="${transactionReport}">
  
	  <tr>
	  	<td><c:out value="${transaction.date}"/></td>
	    <td><c:out value="${transaction.carDescription}"/></td>
	    <td><c:out value="${transaction.price}"/></td>
	    <td><c:out value="${transaction.customerName}"/></td>
	    <td><c:out value="${transaction.email}"/></td>
	  </tr>
  
  </c:forEach>
  
  
</table>
  
<a class="big" href="index.jsp">HOME</a>

</body>
</html>