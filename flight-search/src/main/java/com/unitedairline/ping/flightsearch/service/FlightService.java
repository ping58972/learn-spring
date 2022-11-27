package com.unitedairline.ping.flightsearch.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.unitedairline.ping.flightsearch.entity.Flight;
import com.unitedairline.ping.flightsearch.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}
	public Iterable<Flight> list() {
		return flightRepository.findAll();
	}
	
	public Iterable<Flight> save(List<Flight> flights){
		return flightRepository.saveAll(flights);
	}
	public Flight searchByFlightNumber(String numStr) {
		return flightRepository.findByFlightNumber(numStr);
	}
	public List<Flight> searchByDepartureDate(Date departure) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(departure);
		calendar.add(Calendar.DATE, 1);
		Date departureEnd = calendar.getTime();
		System.out.println(departureEnd);
		return flightRepository.findAllWithDepartureBefore(departure, departureEnd);
		
	}
	public Flight searchWithFlightNumberAndDate(String flightNumber, Date departure) {
		return flightRepository.findWithFlightNumberAndDate(flightNumber, departure);
	}
	public List<Flight> findByDeparture(Date departure) {
		// TODO Auto-generated method stub
		return flightRepository.findByDeparture(departure);
	}
	
}
