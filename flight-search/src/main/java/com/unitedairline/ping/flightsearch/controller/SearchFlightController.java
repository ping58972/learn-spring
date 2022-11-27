package com.unitedairline.ping.flightsearch.controller;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unitedairline.ping.flightsearch.entity.Flight;
import com.unitedairline.ping.flightsearch.service.FlightService;

@RestController
@RequestMapping("/search")
public class SearchFlightController {

	@Autowired
	private FlightService flightService;

	@GetMapping(path = "")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Flight> getAllFlight() {
		return flightService.getAllFlights();
	}

	@GetMapping(path = "/{flightNumber}")
	public Flight searchByFlightNumber(@PathVariable("flightNumber") String flightNumber) throws Exception {
		Flight flight = flightService.searchByFlightNumber(flightNumber);
		if (flight == null) {

			throw new Exception("flightNumber- " + flightNumber);
		}
		return flight;
	}

	@PostMapping(value = "/date")
	//@ResponseBody
	public List<Flight> searchFlightByDateBefore(
			@RequestBody Flight flight)
			throws Exception {
		List<Flight> list = flightService.searchByDepartureDate(flight.getDeparture());
		if (list == null) {
			throw new Exception("departure- " + flight);
		}
		//SimpleDateFormat dtDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		//Date date = dtDateFormat.format(flight.getDeparture());
		//System.out.println(dtDateFormat.format(flight.getDeparture()));
		//return null;
		return list;
	}

	@GetMapping(path = "/date/{departure}")
	public List<Flight> searchByDepartureDate(@Param("departure") @DateTimeFormat() Date departure) throws Exception {
		// List<Flight> list = flightService.searchByDepartureDate(departure);
		List<Flight> list = flightService.findByDeparture(departure);
		if (list == null) {
			throw new Exception("departure- " + departure);
		}
		System.out.println(departure);
		return list;
	}

	@GetMapping(path = "/{flightNumber}/{departure}")
	public Flight searchWithFlightNumberAndDeparture(@Param("flightNumber") String flightNumber,
			@Param("departure") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date departure) throws Exception {
		Flight flight = flightService.searchWithFlightNumberAndDate(flightNumber, departure);
		if (flight == null) {

			throw new Exception("flightNumber- " + flightNumber);
		}
		return flight;
	}
}
