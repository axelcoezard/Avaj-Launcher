package com.acoezard.avaj_launcher.aircrafts;

import com.acoezard.avaj_launcher.WeatherProvider;
import com.acoezard.avaj_launcher.WeatherTower;
import com.acoezard.avaj_launcher.utils.Coordinates;
import com.acoezard.avaj_launcher.utils.Logger;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch(weather) {
            case WeatherProvider.WEATHER_SUN:
                this.coordinates.increaseLongitude(2);
                this.coordinates.increaseHeight(4);
            case WeatherProvider.WEATHER_RAIN:
                this.coordinates.decreaseHeight(5);
            case WeatherProvider.WEATHER_FOG:
                this.coordinates.decreaseHeight(3);
            case WeatherProvider.WEATHER_SNOW:
                this.coordinates.decreaseHeight(15);
        }
        if (this.coordinates.getHeight() == 0) {
            Logger.log(this + " is landing at " + this.coordinates);
            this.weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    @Override
    public String toString() {
        return "Baloon#" + name + "(" + id + ")";
    }
}