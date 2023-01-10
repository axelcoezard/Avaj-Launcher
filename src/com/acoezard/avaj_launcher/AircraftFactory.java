package com.acoezard.avaj_launcher;

public class AircraftFactory {

    public static final String TYPE_HELICOPTER = "helicopter";
    public static final String TYPE_BALOON = "baloon";
    public static final String TYPE_JETPLANE = "jetplane";

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception {
        // Check coordinates
        if (longitude < 0 || latitude < 0 || height < 0) {
            throw new Exception("Wrong coordinates");
        }
        // Create Coordinates object
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        // Check type and create Flyable object
        switch (type) {
            case TYPE_HELICOPTER: return new Helicopter(name, coordinates);
            case TYPE_BALOON: return new Baloon(name, coordinates);
            case TYPE_JETPLANE: return new JetPlane(name, coordinates);
            default: throw new Exception("Wrong type");
        }
    }
}