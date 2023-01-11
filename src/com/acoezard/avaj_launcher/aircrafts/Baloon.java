package com.acoezard.avaj_launcher.aircrafts;

import com.acoezard.avaj_launcher.WeatherTower;
import com.acoezard.avaj_launcher.utils.Coordinates;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    @Override
    public String toString() {
        return "Baloon#" + name + "(" + id + ")";
    }
}