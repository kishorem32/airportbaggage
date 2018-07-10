package com.airport.baggage.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BaggageRouteServiceTest {
	@Test
	public void testGetBagShortestRouteInfo() {
		BaggageRouteService baggageRouteService = new BaggageRouteService();
		List<String> pathForListOfBags = baggageRouteService.getBagShortestRouteInfo();
		Assert.assertEquals(pathForListOfBags.get(0), "0001 [Concourse_A_Ticketing, A5, A1] 11");
		Assert.assertEquals(pathForListOfBags.get(1), "0002 [A5, A1, A2, A3, A4] 9");
	}
}
