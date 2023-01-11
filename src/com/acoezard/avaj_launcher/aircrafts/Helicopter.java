package com.acoezard.avaj_launcher.aircrafts;

import com.acoezard.avaj_launcher.WeatherProvider;
import com.acoezard.avaj_launcher.WeatherTower;
import com.acoezard.avaj_launcher.utils.Coordinates;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch(weather) {
            case WeatherProvider.WEATHER_SUN:
                this.coordinates.increaseLatitude(10);
                this.coordinates.increaseHeight(2);
            case WeatherProvider.WEATHER_RAIN:
                this.coordinates.increaseLongitude(5);
            case WeatherProvider.WEATHER_FOG:
                this.coordinates.increaseLongitude(1);
            case WeatherProvider.WEATHER_SNOW:
                this.coordinates.decreaseHeight(12);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }



    @Override
    public String toString() {
        return "Helicopter#" + name + "(" + id + ")";
    }
}