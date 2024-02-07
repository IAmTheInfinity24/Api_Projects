package com.psa.flights_reservation_app_5.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.psa.flights_reservation_app_5.dto.ReservationRequest;
import com.psa.flights_reservation_app_5.entities.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.flights_reservation_app_5.entities.Flight;
import com.psa.flights_reservation_app_5.repository.FlightRepoInf;

@Controller
public class FlightController {

    @Autowired
    private FlightRepoInf fri;

    @RequestMapping("/findFlights")
    public String findFlights(@RequestParam("origin") String from, @RequestParam("destination") String to,
                              @RequestParam("date") @DateTimeFormat(pattern = "yyyy-dd-MM") Date date,
                              ModelMap modelMap) {
        List<Flight> findFlights = fri.findByDepartureCityAndArrivalCityAndDateOfDeparture(from, to, date);
        modelMap.addAttribute("findFlights", findFlights);
        return "displayFlights";
    }

    @RequestMapping("/showCompleteReservation")
    private String showCompleteReservation(@RequestParam("flightId") Long id, ModelMap modelMap) {
        Optional<Flight> findById = fri.findById(id);
        Flight flight = findById.get();
        modelMap.addAttribute("flight", flight);
        return "showReservation";
    }
}
