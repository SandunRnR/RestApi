package com.rnrsolutions.greenbless.forecast.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "ForecastingItem")
public class ForecastItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String itemName;
    private int forecastingInterval;

    public ForecastItemEntity(String pItemName, int pForecastingInterval) {
        this.itemName = pItemName;
        this.forecastingInterval = pForecastingInterval;
    }
}
