package com.acoezard.avaj_launcher.utils;


public class Coordinates {
    private final int longitude;
    private final int latitude;
    private final int height;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public String toString() {
        return this.longitude + "," + this.latitude + "," + this.height;
    }
}
