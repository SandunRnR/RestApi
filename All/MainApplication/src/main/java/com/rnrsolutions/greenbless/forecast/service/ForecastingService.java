package com.rnrsolutions.greenbless.forecast.service;

import com.rnrsolutions.greenbless.forecast.entity.ForecastingEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface ForecastingService {
    public String saveForecasting(int forecastItemID, int forecastingTypeID, double forecastingValue, LocalDateTime forecastDateTime, LocalDateTime createdDateTime, LocalDateTime updatedDateTime, char isActive) throws Exception;

    public void deleteForecastingById(int id) throws Exception;

    public List<ForecastingEntity> getAllForecastingEntities() throws Exception;


    String updateForecasting(int id, int forecastItemID, int forecastingTypeID, double forecastingValue, LocalDateTime forecastDateTime, LocalDateTime createdDateTime, LocalDateTime updatedDateTime, char isActive) throws Exception;

}
