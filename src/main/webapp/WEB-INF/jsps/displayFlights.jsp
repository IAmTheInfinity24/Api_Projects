<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Display Flights</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }

        fieldset {
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 20px;
            background-color: #fff;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
        }

        .pagination {
            display: flex;
            justify-content: center;
        }

        .page-item {
            margin: 0 5px;
        }
    </style>
</head>
<body>
    <div class="container mt-4">
        <div class="fieldset">
            <h2>Flight Search Results</h2>
        </div>

        <table class="table">
            <thead>
                <tr>
                    <th>Airlines</th>
                    <th>Departure City</th>
                    <th>Arrival City</th>
                    <th>Departure Time</th>
                    <th>Select Flight</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${findFlights}" var="flight">
                    <tr>
                        <td>${flight.operationAirline}</td>
                        <td>${flight.departureCity}</td>
                        <td>${flight.arrivalCity}</td>
                        <td>
                            <fmt:formatDate value="${flight.estimatedDepartureTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                        </td>
                        <td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Pagination -->
        <div class="pagination">
            <c:if test="${not empty findFlights}">
                <ul class="pagination">
                    <c:forEach begin="1" end="${totalPages}" var="page">
                        <li class="page-item">
                            <a class="page-link" href="?page=${page}">${page}</a>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>

        <!-- No Results Message -->
        <c:if test="${empty findFlights}">
            <div class="alert alert-info" role="alert">
                No flights found.
            </div>
        </c:if>
    </div>

    <!-- Add Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</body>
</html>
