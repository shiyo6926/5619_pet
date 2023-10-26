package com.example.petback.entity;

public class WeatherResponse {
    private double temperature;
    private double windSpeed;
    private String weatherClear;

    public WeatherResponse() {
        // 默认构造函数
    }

    public WeatherResponse(double temperature, double windSpeed, String weatherClear) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.weatherClear = weatherClear;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWeatherClear() {
        return weatherClear;
    }

    public void setWeatherClear(String weatherClear) {
        this.weatherClear = weatherClear;
    }
}

/*public class WeatherResponse {
    private double temperature;
    private double humidity;
    private String description;

    public WeatherResponse() {
        // 默认构造函数
    }

    public WeatherResponse(double temperature, double humidity, String description) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
*/