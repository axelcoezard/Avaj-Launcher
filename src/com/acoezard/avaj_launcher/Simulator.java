package com.acoezard.avaj_launcher;

import java.io.IOException;

import com.acoezard.avaj_launcher.aircrafts.Flyable;
import com.acoezard.avaj_launcher.exceptions.SimulatorException;
import com.acoezard.avaj_launcher.utils.Parser;

class Simulator {
	private final WeatherTower weatherTower;
	private int simulationCount;

	public Simulator() {
		this.weatherTower = new WeatherTower();		
	}

	public void parse(String filename) throws IOException, SimulatorException {
		Parser parser = new Parser();
		parser.parse(filename);

		this.simulationCount = parser.getSimulationCount();
		for (Flyable flyable : parser.getAircrafts()) {
			this.weatherTower.register(flyable);
		}
	}

	public void simulate() {
		while (simulationCount > 0) {
			weatherTower.conditionsChanged();
			simulationCount--;
		}
	}

	public static void main(String[] args) {
		if (args.length == 1) {			
			Simulator main = new Simulator();

			try {
				main.parse(args[0]);
				main.simulate();
			} catch(IOException | SimulatorException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
