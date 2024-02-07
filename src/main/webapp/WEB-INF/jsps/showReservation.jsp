<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Reservation</title>
    <style>
        /* Your CSS styles here */
    </style>
</head>
<body>

<fieldset>
    <legend><h2>Flight Details</h2></legend>
    <div style="color: #008080">
        Flight Number: ${flight.flightNumber} <br>
        Operation Airlines: ${flight.operationAirline} <br>
        Departure City: ${flight.departureCity} <br>
        Arrival City: ${flight.arrivalCity} <br>
        Departure Date: ${flight.dateOfDeparture}
    </div>
</fieldset>

<fieldset>
    <legend><h2>Enter Passenger Details</h2></legend>
    <form action="confirmReservation" method="post" >

        <!-- Number of Passengers input -->
        <label for="passengerCount">Number of Passengers:</label>
        <input type="number" id="passengerCount" name="passengerCount" min="1" value="1" oninput="generatePassengerFields(this.value)">

        <!-- Container for Passenger Fields -->
        <div id="passengerFieldsContainer">
            <!-- At least one passenger input initially -->
            <div class="passenger-container" id="passengerContainer1">
                <h3>Passenger 1</h3>
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" required>

                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" name="lastName" required>

                <label for="middleName">Middle Name:</label>
                <input type="text" id="middleName" name="middleName">

                <label for="email">Email:</label>
                <input type="text" id="email" name="email" required>

                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="phone" required>

                <button type="button" onclick="deletePassenger">Delete Passenger</button>
            </div>
        </div>

        <!-- Button to add more passengers dynamically -->
        <button type="button" onclick="addPassenger()">Add Passenger</button>

        <!-- Hidden input to store the total number of passengers -->
        <input type="hidden" id="totalPassengers" name="totalPassengers" value="1">

<input type="hidden" id="flightId" name="flightId" value="${flight.id}">
        <!-- Your other form inputs here -->

        <br>
        <input type="submit" value="Complete Reservation">
    </form>
</fieldset>
<script>
    let passengerCount = 1; // Initial passenger count

    function addPassenger() {
        passengerCount++;
        generatePassengerFields(passengerCount);
    }

    function deletePassenger(e) {
        const container = document.getElementById('passengerFieldsContainer');

        // Check if the clicked element is a delete button
        if (e.target.tagName === 'BUTTON' && e.target.classList.contains('delete-passenger')) {
            const passengerContainer = e.target.closest('.passenger-container');

            if (passengerContainer) {
                container.removeChild(passengerContainer);
                passengerCount--;
                updateTotalPassengers();
            }
        }
    }

    function generatePassengerFields(count) {
        const container = document.getElementById('passengerFieldsContainer');
        container.innerHTML = '';

        for (let i = 1; i <= count; i++) {
            const passengerDiv = document.createElement('div');
            passengerDiv.className = 'passenger-container';
            passengerDiv.innerHTML = `
                <h3>Passenger ${i}</h3>
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" required>

                <label for="lastName${i}">Last Name:</label>
                <input type="text" id="lastName${i}" name="lastName${i}" required>

                <label for="middleName${i}">Middle Name:</label>
                <input type="text" id="middleName${i}" name="middleName${i}">

                <label for="email${i}">Email:</label>
                <input type="text" id="email${i}" name="email${i}" required>

                <label for="phone${i}">Phone:</label>
                <input type="text" id="phone${i}" name="phone${i}" required>

                <button type="button" class="delete-passenger">Delete Passenger</button>
            `;

            container.appendChild(passengerDiv);
        }

        updateTotalPassengers();
    }

    function updateTotalPassengers() {
        // Update the totalPassengers hidden input value
        document.getElementById('totalPassengers').value = passengerCount;
    }

    // Attach the click event to the parent container
    const container = document.getElementById('passengerFieldsContainer');
    container.addEventListener('click', deletePassenger);

    // Initially, generate one passenger input
    generatePassengerFields(passengerCount);
</script>

</body>
</html>
