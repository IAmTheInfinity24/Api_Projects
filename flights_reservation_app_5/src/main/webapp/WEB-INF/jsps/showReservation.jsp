<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Reservation</title>
</head>
<body bgcolor="rgb 100,100,100">
	<fieldset>
		<legend>
			<h2>Flight Details</h2>
		</legend>
		<div style="color: hotpink">
			Flight Number:${flight.flightNumber} <br> <br> Operation
			Airlines:${flight.operationAirline}<br> <br> Departure
			City:${flight.departureCity}<br> <br> Arrival
			City:${flight.arrivalCity}<br> <br> Departure
			Date:${flight.dateOfDeparture}
		</div>
	</fieldset>
	<fieldset>
		<legend>
			<h2>Enter Passenger Details</h2>
		</legend>
		<form action="confirmReservation">

			First Name:<input style="" type="text" name="firstName"><br>
			<br> Last Name:<input type="text" name="lastName"><br>
			<br> Middle Name:<input type="text" name="middleName"><br>
			<br> Email:<input type="text" name="email"><br>
			<br> Phone:<input type="text" name="phone"><br>
			<br> <input type="hidden" name="flightId" value="${flight.id}">

			Card Number:<input type="text" name="cardNumber"><br>
			<br> Card Holder Name:<input type="text" name="cardHolderName"><br>
			<br> Expiry Date:<input type="text" name="expiryDate"><br>
			<br> CVV :<input type="text" name="cvv"><br>
			<br> <input type="submit" value="Complete Reservation">





		</form>
	</fieldset>
</body>
</html>