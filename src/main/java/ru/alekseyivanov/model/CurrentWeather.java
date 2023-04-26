package ru.alekseyivanov.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Класс, содержащий текущие значений погодных данных, таких как: температура, давление, влажность
 * Можно расширять в зависмости от потребности
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {
    private double temp;
    private double feels_like;
    private int pressure;
    private int humidity;

    public CurrentWeather() {
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = (int) (pressure * 0.75);
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
