package com.rnrsolutions.greenbless.forecast.service;

import com.rnrsolutions.greenbless.forecast.entity.ForecastTypeEntity;

import java.util.List;

public interface ForecastTypeService {
    public String saveForecastType(String pName, char pContributionOrder);

    public void deleteForecastTypeById(int id) throws Exception;

    public List<ForecastTypeEntity> getAllForecastTypeEntity() throws Exception;

    public String updateForecastType(int id, String name, char contributionOrder) throws Exception;

}
