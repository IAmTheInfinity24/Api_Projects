package com.psa.flights_reservation_app_5.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.psa.flights_reservation_app_5.entities.Flight;

public interface FlightRepoInf extends JpaRepository<Flight, Long> {
//	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
//	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to,@Param("dateOfDeparture") Date dateOfDeparture);


	List<Flight> findByDepartureCityAndArrivalCityAndDateOfDeparture(String from, String to, Date dateOfDeparture);
}
