package com.airport.baggage.sample.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.airport.baggage.dto.Bags;
import com.airport.baggage.dto.ConveyorSystem;
import com.airport.baggage.dto.Departures;

/**
 * This class is for creating sample data
 * 
 * @author Kishore Reddy
 *
 */
public class SampleData {

	public static List<ConveyorSystem> getConveyorSystemSampleData() {
		return readFileData("sample_conveyorsystem_data.txt", ConveyorSystem.class);
	}

	public static List<Departures> getDeparturesSampleData() {
		return readFileData("sample_departure_data.txt", Departures.class);
	}

	public static List<Bags> getBagsSampleData() {
		return readFileData("sample_bags_data.txt", Bags.class);
	}

	private static <T> List<T> readFileData(String fileName, Class<T> clz) {
		File file = null;
		List<T> listOfDTOs = new ArrayList<>();
		try {

			ClassLoader classLoader = new SampleData().getClass().getClassLoader();
			String filePath = classLoader.getResource("config/" + fileName).getPath().replaceAll("%20", " ");
			file = new File(filePath);

			BufferedReader bufferReader = new BufferedReader(new FileReader(file));

			String readLine = "";
			while ((readLine = bufferReader.readLine()) != null) {
				if (clz.isAssignableFrom(ConveyorSystem.class)) {
					ConveyorSystem conveyorSystem = new ConveyorSystem();
					String[] values = readLine.split(" ");
					conveyorSystem.setFirstNode(values[0]);
					conveyorSystem.setSecondNode(values[1]);
					conveyorSystem.setTravleTime(Integer.valueOf(values[2]));
					listOfDTOs.add((T) conveyorSystem);
				} else if (clz.isAssignableFrom(Departures.class)) {
					Departures departures = new Departures();
					String[] values = readLine.split(" ");
					departures.setFlightId(values[0]);
					departures.setFlightGate(values[1]);
					departures.setDestination(values[2]);
					departures.setFlightTime(LocalTime.parse(values[3]));
					listOfDTOs.add((T) departures);
				} else {
					Bags bags = new Bags();
					String[] values = readLine.split(" ");
					bags.setBagNumber(values[0]);
					bags.setEntryPoint(values[1]);
					bags.setFlightId(values[2]);
					listOfDTOs.add((T) bags);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listOfDTOs;
	}
}
