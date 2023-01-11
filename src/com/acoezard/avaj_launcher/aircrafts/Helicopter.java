package com.acoezard.avaj_launcher.aircrafts;

import java.util.HashMap;

import com.acoezard.avaj_launcher.WeatherProvider;
import com.acoezard.avaj_launcher.WeatherTower;
import com.acoezard.avaj_launcher.utils.Coordinates;
import com.acoezard.avaj_launcher.utils.Logger;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    private final HashMap<String, String> messages = new HashMap<>() {{
        put(WeatherProvider.WEATHER_SUN, "This is hot.");
        put(WeatherProvider.WEATHER_RAIN, "");
        put(WeatherProvider.WEATHER_FOG, "");
        put(WeatherProvider.WEATHER_SNOW, "My rotor is going to freeze!");
    }};

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch(weather) {
            case WeatherProvider.WEATHER_SUN:
                this.coordinates.increaseLongitude(10);
                this.coordinates.increaseHeight(2);
            case WeatherProvider.WEATHER_RAIN:
                this.coordinates.increaseLongitude(5);
            case WeatherProvider.WEATHER_FOG:
                this.coordinates.increaseLongitude(1);
            case WeatherProvider.WEATHER_SNOW:
                this.coordinates.decreaseHeight(12);
        }
        Logger.log(this + ": " + this.messages.get(weather));
        if (this.coordinates.getHeight() == 0) {
            Logger.log(this + " is landing at " + this.coordinates);
            this.weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }



    @Override
    public String toString() {
        return "Helicopter#" + name + "(" + id + ")";
    }
}