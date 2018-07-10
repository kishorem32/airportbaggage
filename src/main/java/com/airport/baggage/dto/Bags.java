package com.airport.baggage.dto;

import java.io.Serializable;

/**
 * 
 * @author Kishore Reddy
 *
 */
public class Bags implements Serializable {

	private static final long serialVersionUID = -8478738655441900339L;
	private String bagNumber;
	private String entryPoint;
	private String flightId;

	public String getBagNumber() {
		return bagNumber;
	}

	public void setBagNumber(String bagNumber) {
		this.bagNumber = bagNumber;
	}

	public String getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
