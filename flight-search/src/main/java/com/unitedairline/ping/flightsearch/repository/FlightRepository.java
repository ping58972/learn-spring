package com.unitedairline.ping.flightsearch.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.unitedairline.ping.flightsearch.entity.Flight;

@CrossOrigin(origins = "http://localhost:4200")
public interface FlightRepository extends JpaRepository<Flight, String> {

	Flight findByFlightNumber(String numStr);
	
	List<Flight> findByAircraft(String aircraft);
	
	List<Flight> findByCarrier(String carrier);
	
	List<Flight> findByOrigin(String origin);
	
	List<Flight> findByDeparture(Date departure);
	
	List<Flight> findByDestination(String destination);
	
	List<Flight> findByArrival(Date arrival);
	
	List<Flight> findByDistance(Integer distance);
	
	List<Flight> findByTravelTime(String travelTime);
	
	List<Flight> findByStatus(String status);
	
	@Query("select f from Flight f where f.departure between :departure and :departureEnd ")
	List<Flight> findAllWithDepartureBefore(@Param("departure") Date departure, @Param("departureEnd") Date departureEnd);
	
	@Query("select f from Flight f where f.flightNumber = :flightNumber and f.departure = :departure")
	Flight findWithFlightNumberAndDate(@Param("flightNumber") String flightNumber, @Param("departure") Date departure);
	
}
