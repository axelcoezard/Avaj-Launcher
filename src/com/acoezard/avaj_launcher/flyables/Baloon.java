package com.acoezard.avaj_launcher.flyables;

import com.acoezard.avaj_launcher.Aircraft;
import com.acoezard.avaj_launcher.Coordinates;
import com.acoezard.avaj_launcher.Flyable;
import com.acoezard.avaj_launcher.WeatherTower;

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
}