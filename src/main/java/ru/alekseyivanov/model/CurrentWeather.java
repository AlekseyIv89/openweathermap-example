package ru.alekseyivanov.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Класс, содержащий текущие значения погодных данных, таких как: температура, давление, влажность
 * Можно расширять в зависмости от потребности
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {
    private double temp;
    private double feels_like;

    @JsonSetter("grnd_level") // С помощью этой аннотации можем сопоставить поле в строке json с нашим полем
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
