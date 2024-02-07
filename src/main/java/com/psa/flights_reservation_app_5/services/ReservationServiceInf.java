package com.psa.flights_reservation_app_5.services;

import com.psa.flights_reservation_app_5.dto.ReservationRequest;
import com.psa.flights_reservation_app_5.entities.Reservation;

public interface ReservationServiceInf {
	Reservation bookFlight(ReservationRequest request) throws Exception;
}
