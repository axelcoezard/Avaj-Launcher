package com.acoezard.avaj_launcher.aircrafts;

import java.util.HashMap;

import com.acoezard.avaj_launcher.WeatherProvider;
import com.acoezard.avaj_launcher.WeatherTower;
import com.acoezard.avaj_launcher.utils.Coordinates;
import com.acoezard.avaj_launcher.utils.Logger;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    private final HashMap<String, String> messages = new HashMap<>() {{
        put(WeatherProvider.WEATHER_SUN, "");
        put(WeatherProvider.WEATHER_RAIN, "It's raining. Better watch out for lightings.");
        put(WeatherProvider.WEATHER_FOG, "");
        put(WeatherProvider.WEATHER_SNOW, "OMG! Winter is coming!");
    }};
    
    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch(weather) {
            case WeatherProvider.WEATHER_SUN:
                this.coordinates.increaseLatitude(10);
                this.coordinates.increaseHeight(2);
            case WeatherProvider.WEATHER_RAIN:
                this.coordinates.increaseLatitude(5);
            case WeatherProvider.WEATHER_FOG:
                this.coordinates.increaseLatitude(1);
            case WeatherProvider.WEATHER_SNOW:
                this.coordinates.decreaseHeight(7);
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
        return "JetPlane#" + name + "(" + id + ")";
    }
}