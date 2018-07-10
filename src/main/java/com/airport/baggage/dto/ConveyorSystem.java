package com.airport.baggage.dto;

import java.io.Serializable;

/**
 * 
 * @author Kishore Reddy
 *
 */
public class ConveyorSystem implements Serializable{
	
	private static final long serialVersionUID = -9054345920969204237L;
	private String firstNode;
	private String secondNode;
	private int travelTime;

	public String getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(String firstNode) {
		this.firstNode = firstNode;
	}

	public String getSecondNode() {
		return secondNode;
	}

	public void setSecondNode(String secondNode) {
		this.secondNode = secondNode;
	}

	public int getTravleTime() {
		return travelTime;
	}

	public void setTravleTime(int travleTime) {
		this.travelTime = travleTime;
	}
}
