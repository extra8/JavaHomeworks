<!DOCTYPE html>



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

<body background="https://i.imgur.com/R3cpQ9R.gif" style="font-family:'Rubik'">
<a href="http://localhost:8080/VehicleRental/start.html" class="button"><<</a>	

<br>



<h1 style="color:white;" align="center">New contract:</h1>

<center>
<table>
<form action="http://localhost:8080/VehicleRental/nc2.html">

<tr><td>
<h3 style="color:#0080ff;">Rent start :</h3>
<tr><td>
<input name="rents" type="text">
<tr><td>

<h3 style="color:#0080ff;">Rent end :</h3>
<tr><td>
<input name="rente" type="text">
<tr><td>

<h3 style="color:#0080ff;">Mileage :</h3>
<tr><td>
<input name="mileage" type="text">
<tr><td>

<h3 style="color:#0080ff;">CNP :</h3>
<tr><td>
<input name="cnp" type="text">
<tr><td>

<h3 style="color:#0080ff;">Registration # :</h3>
<tr><td>
<input name="regnr" type="text">
<tr><td align="center">

<br><br>

<input type="submit" value="Add">
</form>
</table>
 
</body>

</html>
