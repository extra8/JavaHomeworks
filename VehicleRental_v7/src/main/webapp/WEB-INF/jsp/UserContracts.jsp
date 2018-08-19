<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %> 
<%@ page import="java.util.List" %> 
<%@ page import="com.siemens.ctbav.internship.contract_Implementation.Contract" %> 
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
<a href="http://localhost:8080/VehicleRental/coa.html" class="button"><<</a>	

<br>

<table align="center" style="color:white" cellpadding="10" border = "3" borderolor = "white">
    <tr>
        <td style="color:#0080ff;">Contract ID</td>
        <td style="color:#0080ff;">Rent Start</td>
        <td style="color:#0080ff;">Rent End</td>
        <td style="color:#0080ff;">Mileage</td>
        <td style="color:#0080ff;">CNP</td>
        <td style="color:#0080ff;">Registration #</td>
    </tr>
<c:forEach items="${ContractList}" var="Contract">
    <tr>
        <td>${Contract.contractID}</td>
        <td>${Contract.rentingDateStart}</td>
        <td>${Contract.rentingDateEnd}</td>
        <td>${Contract.mileage}</td>
        <td>${Contract.personalIdentificationNumber}</td>
        <td>${Contract.registrationNumber}</td>
    </tr>
</c:forEach>
</table>
 
</body>
</html>