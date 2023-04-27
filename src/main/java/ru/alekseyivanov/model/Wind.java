package ru.alekseyivanov.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс, содержащий текущие значения по скорости ветра
 * Можно расширять в зависмости от потребности, например добавить направление ветра
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Getter
@Setter
public class Wind {
    private double speed;
    private double gust;
}
