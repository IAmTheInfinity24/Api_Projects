package com.psa.flights_reservation_app_5.controller;

import com.psa.flights_reservation_app_5.entities.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psa.flights_reservation_app_5.dto.ReservationRequest;
import com.psa.flights_reservation_app_5.entities.Reservation;
import com.psa.flights_reservation_app_5.services.ReservationServiceInf;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReservationController {

    List<Passenger> passengers;
    @Autowired
    ReservationServiceInf rsi;

    @RequestMapping("/confirmReservation")
    @Transactional
    public String confirmReservation(ModelMap map, @RequestParam("firstName") String[] firstName, @RequestParam("lastName") String[] lastName,
                                     @RequestParam("email") String[] email, @RequestParam("flightId") long flightId, @RequestParam("phone") String[] phone, @RequestParam("passengerCount") int passengerCount
    ) throws Exception {

        ReservationRequest reservationRequest = new ReservationRequest();

        List<Passenger> passengers = new ArrayList<>();

        reservationRequest.setFlightId(flightId);

        System.out.println(firstName);
        for (int i = 0; i < passengerCount; i++) {
            System.out.println(firstName[i]);
            passengers.add(new Passenger(firstName[i], lastName[i], null, email[i], phone[i]));
            passengers.forEach(System.out::print);

        }


        // Set the passengers in the ReservationRequest
        reservationRequest.setPassengers(passengers);

        // Assuming rsi.bookFlight returns a Reservation object
        Reservation reservation = rsi.bookFlight(reservationRequest);

        System.out.println(reservation.getPassengers().get(0).getFirstName());
        // Add the reservation to the model
        map.addAttribute("reservation", reservation);

        return "confirmReservation";
    }

}
