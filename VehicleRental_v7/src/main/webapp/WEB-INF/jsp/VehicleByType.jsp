<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %> 
<%@ page import="java.util.List" %> 
<%@ page import="com.siemens.ctbav.internship.vehicle.implementation.Vehicle" %> 
<%@ page isELIgnored="false" %>

 
<html>
<style>
a.button {
    -webkit-appearance: button;
    border: 2px;
	border-radius: 5%;
	background: #0080ff;
    color: white;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    font-size: 16px;
    cursor: pointer;
}
</style>
<head>
<title>Vehicle Rental</title>
</head>
<body background="https://i.imgur.com/R3cpQ9R.gif" style="font-family:'Rubik'">
<a href="http://localhost:8080/VehicleRental/start.html" class="button"><<</a>	
<h1 style="color:#0080ff;" align="center">Vehicles by Type :</h1>

<br>

<table align="center" style="color:white" cellpadding="10" border = "3" borderolor = "white">
    <tr>
        <td style="color:#0080ff;">Registration #</td>
        <td style="color:#0080ff;">Type</td>
        <td style="color:#0080ff;">Brand</td>
        <td style="color:#0080ff;">Manufacturing year</td>
        <td style="color:#0080ff;">Color</td>
    </tr>
<c:forEach items="${VehicleList}" var="Vehicle">
    <tr>
        <td>${Vehicle.registrationNumber}</td>
        <td>${Vehicle.type}</td>
        <td>${Vehicle.carMaker}</td>
        <td>${Vehicle.manufacturingYear}</td>
        <td>${Vehicle.color}</td>
    </tr>
</c:forEach>
</table>
 
</body>
</html>