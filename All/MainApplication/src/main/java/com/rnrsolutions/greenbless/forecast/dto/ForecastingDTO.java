package com.rnrsolutions.greenbless.forecast.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ForecastingDTO {
    private int ID;

    private int forecastItemID;
    private int forecastingTypeID;
    private double forecastingValue;
    private LocalDateTime forecastDateTime;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
    private char isActive;
}
