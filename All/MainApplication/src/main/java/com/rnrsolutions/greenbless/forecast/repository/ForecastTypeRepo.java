package com.rnrsolutions.greenbless.forecast.repository;

import com.rnrsolutions.greenbless.forecast.entity.ForecastTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForecastTypeRepo extends JpaRepository<ForecastTypeEntity, Integer> {
}
