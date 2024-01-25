package com.psa.flights_reservation_app_5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psa.flights_reservation_app_5.dto.ReservationRequest;
import com.psa.flights_reservation_app_5.entities.Reservation;
import com.psa.flights_reservation_app_5.services.ReservationServiceInf;

@Controller
public class ReservationController {
	@Autowired
	ReservationServiceInf rsi;
	
	@RequestMapping("/confirmReservation")
	public String confirmReservation(ReservationRequest reservationRequest, ModelMap map) {
		Reservation reservation = rsi.bookFlight(reservationRequest);
		map.addAttribute("reservation", reservation);
		return"confirmReservation";
		
		
	}
	
}
