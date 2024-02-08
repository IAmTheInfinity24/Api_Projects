package com.psa.flights_reservation_app_5.services;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import com.psa.flights_reservation_app_5.utilities.EmailDetails;
import com.psa.flights_reservation_app_5.utilities.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psa.flights_reservation_app_5.dto.ReservationRequest;
import com.psa.flights_reservation_app_5.entities.Flight;
import com.psa.flights_reservation_app_5.entities.Passenger;
import com.psa.flights_reservation_app_5.entities.Reservation;
import com.psa.flights_reservation_app_5.repository.FlightRepoInf;
import com.psa.flights_reservation_app_5.repository.PassengerRepoInf;
import com.psa.flights_reservation_app_5.repository.ReservationRepoInf;
import com.psa.flights_reservation_app_5.utilities.PDFGenerator;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationServiveImpl implements ReservationServiceInf {

    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    EmailService EmailService;

    @Autowired
    private PassengerRepoInf pri;

    @Autowired
    private FlightRepoInf fri;

    @Autowired
    private ReservationRepoInf rri;

    @Override
    @Transactional
    public Reservation bookFlight(ReservationRequest request) throws Exception {

        List<Passenger> passengers = request.getPassengers();
        System.err.println(passengers.isEmpty());
        for (Passenger p : passengers) {
            System.err.println(p.getFirstName());
            // Create and save passenger details
            Passenger passenger = new Passenger();
            passenger.setFirstName(p.getFirstName());
            passenger.setLastName(p.getLastName());
            passenger.setMiddleName(p.getMiddleName());
            passenger.setEmail(p.getEmail());
            passenger.setPhone(p.getPhone());
            pri.save(passenger);
        }


        // Retrieve flight details based on the provided flightId
        long flightId = request.getFlightId();
        System.err.println(flightId);
        Optional<Flight> optionalFlight = fri.findById(flightId);

        if (!optionalFlight.isPresent()) {
            throw new Exception("Flight with id " + flightId + " not found");
        }

        Flight flight = optionalFlight.get();

        // Create and save reservation details
        Reservation reservation = new Reservation();
        reservation.setPassengers(passengers);
        reservation.setFlight(flight);
        reservation.setNumberOfBags(0);
        rri.save(reservation);

        // Generate and send itinerary
        String filePath = "src/main/resources/tickets/reservation" + reservation.getId() + ".pdf";
        pdfGenerator.generateItinerary(reservation, filePath);
        Passenger passenger = passengers.get(0);
        String msg = "Hey " + passenger.getFirstName() + " this is your Tickets For Upcoming journey Please Find attached pdf";
        EmailService.sendMailWithAttachment(new EmailDetails(passenger.getEmail(), msg, "Itinerary Of Flight", filePath));

        return reservation;
    }


}
