package com.psa.flights_reservation_app_5.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psa.flights_reservation_app_5.entities.Reservation;
import com.psa.flights_reservation_app_5.repository.ReservationRepoInf;

@RestController
public class ReservationRestController {
	
	@Autowired
	private ReservationRepoInf rri;
	
	@RequestMapping("reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		Optional<Reservation> findById = rri.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}
	
	@PostMapping("reservation")
	public Reservation updateResevation(@RequestBody Reservation reservation) {
		System.err.println(reservation);
		long id = reservation.getId();
		Optional<Reservation> findById = rri.findById(id);
		Reservation reservation1 = findById.get();
		System.err.println(reservation1);
		reservation.setFlight(reservation1.getFlight());
		reservation.setPassengers(reservation1.getPassengers());
		System.err.println(reservation1);
		System.err.println(reservation);
		return rri.save(reservation);
	}
	
//	@RequestMapping("/proceedCheckIn")
//	public String proceedCheckIn(@RequestParam("id") Long id){
//		return "proceedCheckIn";
//	}
}
