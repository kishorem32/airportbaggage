package com.airport.baggage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airport.baggage.dto.ConveyorSystem;
import com.airport.baggage.dto.Departures;
import com.airport.baggage.sample.data.SampleData;

import es.usc.citius.hipster.algorithm.Algorithm.SearchResult;
import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.graph.GraphSearchProblem;
import es.usc.citius.hipster.graph.HashBasedHipsterDirectedGraph;
import es.usc.citius.hipster.graph.HipsterDirectedGraph;
import es.usc.citius.hipster.model.impl.WeightedNode;
import es.usc.citius.hipster.model.problem.SearchProblem;
/**
 * 
 * @author Kishore Reddy
 *
 */
public class BaggageRouteService {
	
	/**
	 * This method for finding the bag route from entry point to destinationnpoint
	 */
	public static  List<String> getBagShortestRouteInfo() {
		BaggageRouteService baggageRouteService = new BaggageRouteService();
		List<String> output = new ArrayList<>();
		SampleData.getBagsSampleData().stream().forEach(bag -> {

			SearchResult searchResult = baggageRouteService.getBagRoutePathSearchResult(SampleData.getConveyorSystemSampleData(),
					bag.getEntryPoint(), getFlightGate(bag.getFlightId()));
			Optional<WeightedNode> wieghtedNodeOpt = searchResult.getGoalNodes().stream().findAny();
			Double cost = 0d;
			if (wieghtedNodeOpt.isPresent()) {
				cost = (Double) wieghtedNodeOpt.get().getCost();
			}
			output.add(bag.getBagNumber() + " "
					+ searchResult.getOptimalPaths().get(0).toString() + " "
					+ String.valueOf(cost).replaceAll(".0", ""));
		});
		
		return output;
	}

	/**
	 * 
	 * @param flightId
	 * @return
	 */
	private static String getFlightGate(String flightId) {
		if ("ARRIVAL".equals(flightId))
			return "BaggageClaim";
		return SampleData.getDeparturesSampleData().stream().filter(flight -> flight.getFlightId().equals(flightId))
				.map(Departures::getFlightGate).findAny().get();
	}
	
	/**
	 * 
	 * @param conveyorSystems
	 * @param entryPoint
	 * @param destinationPoint
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public SearchResult getBagRoutePathSearchResult(List<ConveyorSystem> conveyorSystems, String entryPoint,
			String destinationPoint) {
		// connect the vertixes
		HipsterDirectedGraph<String, Integer> graph = connectVertexes(conveyorSystems);
		// create starting point
		SearchProblem p = GraphSearchProblem.startingFrom(entryPoint).in(graph).takeCostsFromEdges().build();

		// Search the shortest path from entryPoint to destinationPoint and return
		// result
		return Hipster.createDijkstra(p).search(destinationPoint);
	}

	/**
	 * This method is for connecting vertexes
	 * 
	 * @return
	 */
	private static HipsterDirectedGraph<String, Integer> connectVertexes(List<ConveyorSystem> conveyorSystems) {
		HashBasedHipsterDirectedGraph<String, Integer> graph = new HashBasedHipsterDirectedGraph<String, Integer>();

		for (ConveyorSystem conveyorSystemDTO : conveyorSystems) {
			graph.add(conveyorSystemDTO.getFirstNode());
			graph.add(conveyorSystemDTO.getSecondNode());
			graph.connect(conveyorSystemDTO.getFirstNode(), conveyorSystemDTO.getSecondNode(),
					conveyorSystemDTO.getTravleTime());
		}

		return graph;
	}

}
