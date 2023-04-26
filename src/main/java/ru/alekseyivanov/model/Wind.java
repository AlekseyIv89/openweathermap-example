package ru.alekseyivanov.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Класс, содержащий текущие значения по скорости ветра
 * Можно расширять в зависмости от потребности, например добавить направление ветра
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {
    private double speed;

    public Wind() {
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
