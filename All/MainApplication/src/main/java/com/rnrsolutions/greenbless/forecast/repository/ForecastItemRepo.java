package com.rnrsolutions.greenbless.forecast.repository;

import com.rnrsolutions.greenbless.forecast.entity.ForecastItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForecastItemRepo extends JpaRepository<ForecastItemEntity, Integer> {

}
