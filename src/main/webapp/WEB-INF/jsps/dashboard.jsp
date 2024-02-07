<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>SkyBound - Flight Ticket Booking</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Add your custom CSS styles -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header class="bg-primary text-white text-center py-4">
   <div class="d-flex justify-content-between align-items-center container">
       <h1>Welcome to SkyBound - Flight Ticket Booking</h1>
       <p class="btn btn-light text-primary">${message}</p>
   </div>

</header>

<div class="container mt-4">
    <section>
        <h2>Search for Flights</h2>
        <!-- Bootstrap Form -->
        <form action="findFlights" method="post" class="mb-4">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="origin">Origin:</label>
                    <input type="text" class="form-control" id="origin" name="origin" required>
                </div>
                <div class="form-group col-md-4">
                    <label for="destination">Destination:</label>
                    <input type="text" class="form-control" id="destination" name="destination" required>
                </div>
                <div class="form-group col-md-4">
                    <label for="date">Date:</label>
                    <input type="date" class="form-control" id="date" name="date" required>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Search Flights</button>
        </form>
    </section>

    <section>
        <h2>Available Flights</h2>
        <!-- Bootstrap Table -->
        <table class="table">
            <thead>
            <tr>
                <th>Flight Number</th>
                <th>Departure Time</th>
                <th>Arrival Time</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <!-- Sample Flight -->
            <tr>
                <td>FL123</td>
                <td>10:00 AM</td>
                <td>12:00 PM</td>
                <td>$200</td>
                <td><a href="/book?flightNumber=FL123" class="btn btn-success">Book Now</a></td>
            </tr>
            <!-- Add more rows as needed -->
            </tbody>
        </table>
    </section>
</div>

<footer class="bg-dark text-white text-center py-3">
    <p>&copy; 2024 SkyBound - Flight Ticket Booking</p>
<a href="index" class="btn btn-light text-primary">Log Out</a>

</footer>

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
