package com.rnrsolutions.greenbless.forecast.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForecastItemDTO {
    private int id;
    private String itemName;
    private int forecastingInterval;
}
