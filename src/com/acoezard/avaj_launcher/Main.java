package com.acoezard.avaj_launcher;

class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
		try {
			AircraftFactory.newAircraft(AircraftFactory.TYPE_BALOON, "test", 10, 5, 6);
			AircraftFactory.newAircraft(AircraftFactory.TYPE_HELICOPTER, "test", 10, 5, 6);
			AircraftFactory.newAircraft(AircraftFactory.TYPE_JETPLANE, "test", 10, 5, 6);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			AircraftFactory.newAircraft("lol", "test", 10, 5, 6);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			AircraftFactory.newAircraft(AircraftFactory.TYPE_BALOON, "test", -10, 5, 6);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
