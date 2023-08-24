package com.psa.flights_reservation_app_5.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psa.flights_reservation_app_5.dto.ReservationRequest;
import com.psa.flights_reservation_app_5.entities.Flight;
import com.psa.flights_reservation_app_5.entities.Passenger;
import com.psa.flights_reservation_app_5.entities.Reservation;
import com.psa.flights_reservation_app_5.repository.FlightRepoInf;
import com.psa.flights_reservation_app_5.repository.PassengerRepoInf;
import com.psa.flights_reservation_app_5.repository.ReservationRepoInf;
import com.psa.flights_reservation_app_5.utilities.EmailUtil;
import com.psa.flights_reservation_app_5.utilities.PDFGenerator;

@Service
public class ReservationServiveImpl implements ReservationServiceInf {
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;

	@Autowired
	private PassengerRepoInf pri;
	
	@Autowired
	private FlightRepoInf fri;
	
	@Autowired
	private ReservationRepoInf rri;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		
		pri.save(passenger);
		
		long id=request.getFlightId();
		Optional<Flight> findById = fri.findById(id);
		Flight flight = findById.get();
		
		Reservation reservation =new Reservation();
		reservation.setPassenger(passenger);
		reservation.setFlight(flight);
		reservation.setNumberOfBags(0);
		
		rri.save(reservation);
		
		String filePath="C:\\Users\\mayur-pc\\Documents\\SpringPsa\\flights_reservation_app_5\\tickets\\reservation"+reservation.getId()+".pdf";
		pdfGenerator.generateItinerary(reservation,filePath);
		emailUtil.sendItinerary(passenger.getEmail(),filePath);
		
		
		return reservation;
	}

}
