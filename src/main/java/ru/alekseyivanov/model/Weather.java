package ru.alekseyivanov.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Основной класс, содержащий погодные данные
 * Можно расширять в зависмости от потребности
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Getter
@Setter
public class Weather {
    private String name;
    private CurrentWeather main;
    private Coordinates coord;
    private Wind wind;

    @Override
    public String toString() {
        return "Погода в г. " + name + " (координаты: " + coord.getLat() + ", " + coord.getLon() + ")\n" +
                "\tТемпература: " + main.getTemp() + " \u00B0C (по ощущениям: " + main.getFeels_like() + " \u00B0C)\n" +
                "\tВлажность: " + main.getHumidity() + " %\n" +
                "\tДавление: " + main.getPressure() + " мм рт.ст.\n" +
                "\tСкорость ветра: " + wind.getSpeed() + " м/с (порывы до: " + wind.getGust() + " м/с)";
    }
}
