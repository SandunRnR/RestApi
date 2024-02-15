package com.rnrsolutions.greenbless.forecast.repository;

import com.rnrsolutions.greenbless.forecast.entity.ForecastingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ForecastingRepo extends JpaRepository<ForecastingEntity, Integer> {

}
