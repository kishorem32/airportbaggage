package com.airport.baggage.dto;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * 
 * @author Kishore Reddy
 *
 */
public class Departures implements Serializable {

	private static final long serialVersionUID = 2961098990612295681L;
	private String flightId;
	private String flightGate;
	private String destination;
	private LocalTime flightTime;

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightGate() {
		return flightGate;
	}

	public void setFlightGate(String flightGate) {
		this.flightGate = flightGate;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalTime getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}
}
