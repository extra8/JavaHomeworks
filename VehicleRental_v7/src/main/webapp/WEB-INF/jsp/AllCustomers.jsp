<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %> 
<%@ page import="java.util.List" %> 
<%@ page import="com.siemens.ctbav.internship.person.implementation.Person" %> 
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
<h1 style="color:#0080ff;" align="center">All customers :</h1>

<br>

<table align="center" style="color:white" cellpadding="10" border = "3" borderolor = "white">
    <tr>
        <td style="color:#0080ff;">CNP</td>
        <td style="color:#0080ff;">Last Name</td>
        <td style="color:#0080ff;">First Name</td>
        <td style="color:#0080ff;">Gender</td>
        <td style="color:#0080ff;">License Year</td>
    </tr>
<c:forEach items="${CustomerList}" var="Person">
    <tr>
        <td>${Person.personalIdentificationNumber}</td>
        <td>${Person.lastName}</td>
        <td>${Person.firstName}</td>
        <td>${Person.gender}</td>
        <td>${Person.drivingLicenseYear}</td>
    </tr>
</c:forEach>
</table>
 
</body>
</html>