<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservation Confirmation</title>
    <style>
        /* Reset CSS */
        *, *::before, *::after {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        /* Global Styles */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f2f2f2;
            color: #333;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            max-width: 600px;
            width: 100%;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 40px;
        }

        h1 {
            font-size: 28px;
            margin-bottom: 20px;
            text-align: center;
            color: #333;
        }

        h2 {
            font-size: 24px;
            margin-bottom: 15px;
            color: #444;
        }

        p {
            margin-bottom: 15px;
            color: #666;
        }

        ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        li {
            margin-bottom: 20px;
        }

        strong {
            font-weight: bold;
            color: #333;
        }

        /* Button Styles */
        .button {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            margin-right: 10px;
        }

        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Reservation Confirmation</h1>

        <h2>Flight Details</h2>
        <strong>Flight Number:</strong> ${reservation.flight.flightNumber}<br>
        <strong>Operation Airlines:</strong> ${reservation.flight.operationAirline} <br>
        <strong>Departure City:</strong> ${reservation.flight.departureCity}<br>
        <strong>Arrival City:</strong> ${reservation.flight.arrivalCity}<br>
        <strong>Departure Date:</strong> ${reservation.flight.dateOfDeparture}<br>

        <h2>Passenger Details</h2>
        <ul>
            <!-- Loop through passengers and display details -->
            <c:forEach items="${reservation.passengers}" var="passenger">
                <li>
                    <strong>Name:</strong> ${passenger.firstName} ${passenger.lastName}<br>
                    <strong>Email:</strong> ${passenger.email}<br>
                    <strong>Phone:</strong> ${passenger.phone}<br>
                    <!-- Display other passenger details as needed -->
                </li>
            </c:forEach>
        </ul>

        <h2>Payment Details</h2>
        <!-- Display other payment details as needed -->

        <h2>Confirmation Message</h2>
        <p>Your reservation has been successfully confirmed. Thank you!</p>

        <!-- Print Confirmation Button -->
        <a href="#" class="button">Print Confirmation</a>

        <!-- Back to Home Button -->
        <a href="dashboard" class="button">Back to Home</a>
    </div>
</body>
</html>
