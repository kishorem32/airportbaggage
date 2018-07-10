package airport.baggage.airportbaggage;

import java.util.List;

import com.airport.baggage.service.BaggageRouteService;

/**
 * 
 * @author Kishore Reddy
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Welcome to Airport Baggage System!");
		BaggageRouteService baggageRouteService = new BaggageRouteService();
		List<String> pathForListOfBags = baggageRouteService.getBagShortestRouteInfo();
		pathForListOfBags.forEach(path -> {
			System.out.println(path);
		});
	}
}
