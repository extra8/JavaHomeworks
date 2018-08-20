<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %> 
<%@ page import="java.util.List" %> 
<%@ page import="com.siemens.ctbav.internship.contract.implementation.Contract" %> 
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

input[type=submit] {
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

<br>



<h1 style="color:white;" align="center">Find contract</h1>
<br>

<center>
<table>
<form action="http://localhost:8080/VehicleRental/uc.html">
<tr><td>
<h3 style="color:#0080ff;">Enter CNP :</h3>
<tr><td>
<input name="cnp" type="text">
<tr><td align="center">
<br>
<br>
<input type="submit" value="Find">
</form>
</table>
 
</body>
</html>