package com.rnrsolutions.greenbless.forecast.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "Forecasting")
public class ForecastingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int forecastItemID;
    private int forecastingTypeID;
    private double forecastingValue;
    private LocalDateTime forecastDateTime;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
    private char isActive;

    public ForecastingEntity(
            int pForecastingItemID,
            int pForecastingTypeID,
            double pForecastingValue,
            LocalDateTime pForecastDateTime,
            LocalDateTime pCreatedDateTime,
            LocalDateTime pUpdateDateTime,
            char pIsActive
    ) {
        this.forecastItemID = pForecastingItemID;
        this.forecastingTypeID = pForecastingTypeID;
        this.forecastingValue = pForecastingValue;
        this.forecastDateTime = pForecastDateTime;
        this.createdDateTime = pCreatedDateTime;
        this.updatedDateTime = pUpdateDateTime;
        this.isActive = pIsActive;
    }
}
