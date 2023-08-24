<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Flights</title>
</head>
<body>
	<fieldset>
		<h2>Flight Search Results</h2>
	</fieldset>
	<table border="1">
		<tr>
			<th>Airlines</th>
			<th>DepartureCity</th>
			<th>Arrival City</th>
			<th>DepartureTime</th>
			<th>Select Flight</th>
		</tr>
 		<c:forEach items="${findFlights}" var="findFlights">
			<tr>
				<td>${findFlights.operationAirline}</td>
				<td>${findFlights.departureCity}</td>
				<td>${findFlights.arrivalCity}</td>
				<td>${findFlights.estimatedDepartureTime}</td>
				<td><a href="showCompleteReservation?flightId=${findFlights.id}">Select</a></td> 
			</tr>
		</c:forEach>		
			</table>

</body>
</html>