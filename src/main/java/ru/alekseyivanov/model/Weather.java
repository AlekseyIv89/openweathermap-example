package ru.alekseyivanov.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Основной класс, содержащий погодные данные
 * Можно расширять в зависмости от потребности
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private String name;
    private CurrentWeather main;
    private Coordinates coord;

    private Wind wind;

    public Weather() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrentWeather getMain() {
        return main;
    }

    public void setMain(CurrentWeather main) {
        this.main = main;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "Погода в г. " + name + " (координаты: " + coord.getLat() + ", " + coord.getLon() + ")\n" +
                "\tТемпература: " + main.getTemp() + " \u00B0C (по ощущениям: " + main.getFeels_like() + " \u00B0C)\n" +
                "\tВлажность: " + main.getHumidity() + " %\n" +
                "\tДавление: " + main.getPressure() + " мм рт.ст.\n" +
                "\tСкорость ветра: " + wind.getSpeed() + " м/с";
    }
}
