package com.acoezard.avaj_launcher;

import java.io.IOException;

import com.acoezard.avaj_launcher.aircrafts.Flyable;
import com.acoezard.avaj_launcher.exceptions.SimulatorException;
import com.acoezard.avaj_launcher.utils.Logger;
import com.acoezard.avaj_launcher.utils.Parser;

class Simulator {
	private final Logger logger;
	private final WeatherTower weatherTower;
	private int simulationCount;

	public Simulator() throws IOException {
		this.logger = new Logger("simulation.txt");
		this.weatherTower = new WeatherTower();		
	}

	public void parse(String filename) throws IOException, SimulatorException {
		Parser parser = new Parser();
		parser.parse(filename);

		this.simulationCount = parser.getSimulationCount();
		for (Flyable flyable : parser.getAircrafts()) {
			flyable.registerTower(this.weatherTower);
			this.weatherTower.register(flyable);
		}
	}

	public void simulate() {
		while (simulationCount > 0) {
			weatherTower.changeWeather();
			simulationCount--;
		}
	}

	public static void main(String[] args) {
		if (args.length == 1) {			
			try {
				Simulator main = new Simulator();
				main.parse(args[0]);
				main.simulate();
				Logger.close();
			} catch(IOException | SimulatorException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
