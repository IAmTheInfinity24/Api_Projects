package com.psa.flights_reservation_app_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psa.flights_reservation_app_5.entities.Reservation;

public interface ReservationRepoInf extends JpaRepository<Reservation, Long> {

}
