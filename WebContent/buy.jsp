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
	
	<title>Checkout</title>
	</head>
<body style="background-color:powderblue;">

<div class="space50"></div>


      <div class="card blue-grey darken-1"  style="width: 355px; margin: auto;">
        <div class="card-content white-text" style="width:350px;">
          <span class="card-title">Checkout</span>
          <form action="TransactionServlet" method="post">
                

                <div class="form-group">
  
                	<label for="carDescription"  style="font-size:18px;">Car Description</label>
                    <!-- <label for="car description"><h5>Car Description</h5></label> -->
                    <!-- student.setFirstName(request.getParameter("firstName")); -->
                    <input type="text" class="form-control" name="carDescription" id="car descripton" placeholder="">
                    
                </div>

                <div class="form-group">
                    <label for="price"  style="font-size:18px;">Price</label>
                    <!-- student.setFirstName(request.getParameter("firstName")); -->
                    <input type="text" class="form-control" name="price" id="price" placeholder="$">
                </div>

                <div class="form-group">
                    <label for="customerName" style="font-size:18px;">Customer Name</label>
                    <!-- student.setFirstName(request.getParameter("firstName")); -->
                    <input type="text" class="form-control" name="customerName" id="customerName" placeholder="">
                </div>

                <div class="form-group">
                    <label for="email" style="font-size:18px;">Email</label>
                    <!-- student.setFirstName(request.getParameter("firstName")); -->
                    <input type="text" class="form-control" name="email" id="email" placeholder="">
                </div>

                <div class="form-group" >
                    <label for="date" style="font-size:18px;">Date</label>
                    <!-- student.setFirstName(request.getParameter("firstName")); -->
                    <input type="text" class="form-control" name="date" id="date" placeholder="">
                </div>

                <button type="submit" class="btn btn-primary" name="buy">Submit</button>
            </form>
        </div>
        
      </div>
      
      <div class="space50"></div>
   
  		<span class="right100"></span>
		<span class="right100"></span>
		<span class="right100"></span>
		<span class="right100"></span>
		<span class="right100"></span>
		<span class="right100"></span>
		<span class="right100"></span>
  		
  		<a class="big" href="index.jsp">HOME</a>
  	
		<h6 class="right100">Note to admin : since our tech staff is still learning... </h6>
		<h5 class="right100">Click here to manually delete this car if purchased please!</h5>
		<span class="right100"></span>
		<a class="big" href="deleteCar.jsp">DELETE</a>
	  	
	
	
  	<div class="space50"></div>
 
  

</body>
</html>