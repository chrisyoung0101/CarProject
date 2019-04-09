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

<title>Inventory</title>

</head>

<body style="background-color:powderblue;" >

<div class="space50"></div>

<img src="/Users/chrisyoung/Documents/shark.JPEG/">



	<c:if test="${carToShow != null}">
		
	<!-- CARD TO RENDER FOR SEARCH  -->
	
	      <div class="card blue-grey darken-1" style="width: 400px; margin: auto;">
	        <div class="card-content white-text">
	          <span class="card-title">Car Details</span>
	          <ul>
				  <li>MAKE :&nbsp;<c:out value="${carToShow.make}"/></li>
				  <li>MODEL :&nbsp;<c:out value="${carToShow.model}"/></li>
				  <li>YEAR :&nbsp;<c:out value="${carToShow.year}"/></li>
				  <li>CONDITION :&nbsp;<c:out value="${carToShow.condition}"/></li>
				  <li>PURCHASED :&nbsp;<c:out value="${carToShow.purchaseDate}"/></li>
				  <li>COST :&nbsp;$<c:out value="${carToShow.purchasePrice}"/></li>
				  <li>SELL :&nbsp;$<c:out value="${carToShow.sellPrice}"/></li>
				  <li>ID :&nbsp;<c:out value="${carToShow.ID}"/></li>
				</ul>
				
				<h7>Description</h7>
	          	<p><c:out value="${carToShow.description}"/></p>
	        </div>
	        
	        <div class="card-action"> 
	        	
	        	<a href="buy.jsp"><button type="button">Purchase</button></a>
	        	
	        	<c:if test="${car.isExpired(car.getPurchaseDate()) == true}">
		 			<a href="offer.jsp"><button type="button">Make an offer!</button></a>
				</c:if>	
				
			</div>
	        </div>
	         <br>
	   
		
	</c:if>




	<div class="space50"></div>
	
	<!-- ************** Search box ************** -->
	
	<div class="card blue-grey darken-1" style="width: 400px; height: 150px; margin: auto;">
	        <div class="card-content white-text">
	        	<form class="container" action="SearchMakeResultServlet" method="post">
				  	SEARCH MAKE<br>
				  	<input type="text" name="makeInput" placeholder="Honda">
				  	<br>
				  	<input type="submit" value="Submit">
				</form> 
			</div>
	</div>
	
	<div class="space50"></div>
	
	<!--  class seems to have not direct effect -->
	<span class="right100"></span>
	<span class="right100"></span>
	
	
	
	
	<a class="big" href="index.jsp">HOME</a>
	

	<div class="space50"></div>
	
	
	
	
	
		<form class="container" action="ShowInventoryServlet" method="post">
			<button type="submit">Show Full Inventory</button>
			
			
			
					<c:forEach var="car" items="${carCards}">
	
	      <div class="card blue-grey darken-1" style="width: 400px; margin: auto;">
	        <div class="card-content white-text">
	          <span class="card-title">Card Title</span>
	          <ul>
	         	
				  <li>MAKE :&nbsp;<c:out value="${car.make}"/></li>
				  <li>MODEL :&nbsp;<c:out value="${car.model}"/></li>
				  <li>YEAR :&nbsp;<c:out value="${car.year}"/></li>
				  <li>CONDITION :&nbsp;<c:out value="${car.condition}"/></li>
				  <li>PURCHASED :&nbsp;<c:out value="${car.purchaseDate}"/></li>
				  <li>COST :&nbsp;$<c:out value="${car.purchasePrice}"/></li>
				  <li>SELL :&nbsp;$<c:out value="${car.sellPrice}"/></li>
				  <li>ID :&nbsp;<c:out value="${car.ID}"/></li>
				</ul>
				<h7>Description</h7>
	          <p><c:out value="${car.description}"/></p>
	        </div>
	        
	        <div class="card-action">
	        	<!-- <button type="button" onclick="alert('Hello world!')">Purchase</button> -->
	        	
	        	<a href="buy.jsp"><button type="button">Purchase</button></a>
	        	
	        	 <c:if test="${car.isExpired(car.getPurchaseDate()) == true}">
		 			<a href="offer.jsp"><button type="button">Make an offer!</button></a>
				</c:if>	
			</div>
	       			
	        </div>
	        <br>
	      
	 
</c:forEach>
			
			
			
		</form>
	

	

	
	
	

<!-- <h1>Current Inventory</h1> -->

  
  
  

</body>
</html>