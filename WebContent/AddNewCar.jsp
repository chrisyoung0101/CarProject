<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <!-- import jstl  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- import object  -->
<%@ page import="com.user.Car" %>

<!-- import ArrayList  -->
<%@page import="java.util.ArrayList" %>


<% ArrayList<Car> carList = (ArrayList<Car>) session.getAttribute("carList"); %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./styles/styles.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 				integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 			
		crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

<!-- Enter New Car Form -->

<!-- USER HITS BUTTON AND ALL DATA ENTERED IN FORM GETS SUBMITTED AS AN HTTP REQUEST AND THE DATA HITS RegistrationServlet  -->
 
 
 
 <form class="container" action="CreateCarServlet" method="post">
 	
 
        <div class="form-group">
            <label for="make">Make</label>
            <!-- student.setFirstName(request.getParameter("firstName")); -->
            <input type="text" class="form-control" name="make" id="make" placeholder="Make">
        </div>
        
		
        <div class="form-group">
            <label for="model">Model</label>
            <input type="text" class= "form-control" name="model" id="model" placeholder="Model">
        </div>
        
        <div class="form-group">
            <label for="year">Year</label>
            <input type="text" class="form-control" name="year" id="year" placeholder="Year">
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <input type="text" class="form-control" name="condition" id="condition" placeholder="Condition">
        </div>
        
        <div class="form-group">
            <label for="miles">Miles</label>
            <input type="text" class="form-control" name="miles" id="condition" placeholder="Miles">
        </div>
        
        <div class="form-group">
            <label for="purchaseDate">Purchase Date</label>
            <input type="text" class="form-control" name="purchaseDate" id="purchaseDate" placeholder="2019-03-05" >
        </div>
        
        <div class="form-group">
            <label for="purchasePrice">Purchase Price</label>
            <input type="text" class="form-control" name="purchasePrice" id="purchasePrice" placeholder="Purchase Price" >
        </div>
        
         <div class="form-group">
            <label for="sellPrice">Sell Price</label>
            <input type="text" class="form-control" name="sellPrice" id="sellPrice" placeholder="Sell Price" >
        </div>
        <div class="form-froup">
        <label for="description">Description</label>
        	<textarea rows="4" cols="50"  class="form-control" name="description" id="description" placeholder="Enter Vehicle Description">
				This is a vehicle.</textarea> <br><br>
        </div>
        <input type="file" name="fileToUpload">
        
       	<span></span>
        
        <button type="submit" class="big right100">Submit</button>
        

        
	
        
    </form>
    
    <div class="space300"></div>
    <div class="space300"></div>
    
    <div class="center">
		<a class="big" href="index.jsp">HOME</a>
	</div>
    
	<div class="space100"></div>
	
		<table class="table">
			<thead>
				<tr>
					<th>Car Successfully Added</th>
				</tr>
			</thead>
				<tbody>
				<c:forEach var="car" items="${carList}">
	
                    <tr>
                      <td><c:out value="${car.make}"/></td>
                      <td><c:out value="${car.model}"/></td>
                      <td><c:out value="${car.year}"/></td>
                      <td><c:out value="${car.condition}"/></td>
                      <td><c:out value="${car.miles}"/></td>
                      <td><c:out value="${car.purchaseDate}"/></td>
                      <td><c:out value="${car.purchasePrice}"/></td>
                      <td><c:out value="${car.sellPrice}"/></td>
                      <td><c:out value="${car.description}"/></td>
                    </tr>                           
                    
                </c:forEach>
			</tbody>
		</table>

	<div class="space100"></div>

</body>
</html>