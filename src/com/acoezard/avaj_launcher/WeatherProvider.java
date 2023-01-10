package com.acoezard.avaj_launcher;

public class WeatherProvider {
    private static final WeatherProvider weatherProvider = new WeatherProvider();
    private static final String[] weather = new String[]{ "", "", "", "" };

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int sum = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        int mod = WeatherProvider.weather.length;
        return WeatherProvider.weather[sum & mod];
    }
}