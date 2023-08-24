package com.psa.flights_reservation_app_5.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date dateOfDeparture,
			ModelMap modelMap) {
		List<Flight> findFlights = fri.findByDepartureCityAndArrivalCityAndDateOfDeparture(from, to, dateOfDeparture);
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
