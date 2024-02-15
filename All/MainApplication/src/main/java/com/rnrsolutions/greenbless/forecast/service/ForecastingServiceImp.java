package com.rnrsolutions.greenbless.forecast.service;

import com.rnrsolutions.greenbless.forecast.entity.ForecastingEntity;
import com.rnrsolutions.greenbless.forecast.repository.ForecastingRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ForecastingServiceImp implements ForecastingService{
    @Autowired
    private ForecastingRepo forecastingRepo;

    @Override
    public String saveForecasting(int pForecastItemID, int pForecastingTypeID, double pForecastingValue, LocalDateTime pForecastDateTime, LocalDateTime pCreatedDateTime, LocalDateTime pUpdateDateTime, char pIsActive) throws Exception {

        ForecastingEntity newObjectForecastingEntity = new ForecastingEntity(pForecastItemID, pForecastingTypeID, pForecastingValue, pForecastDateTime, pCreatedDateTime, pUpdateDateTime, pIsActive);

        try {
            forecastingRepo.save(newObjectForecastingEntity);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Successfully Inserted!";
    }

    @Override
    public void deleteForecastingById(int id) throws Exception {
        forecastingRepo.deleteById(id);
    }

    @Override
    public List<ForecastingEntity> getAllForecastingEntities(){
        return forecastingRepo.findAll();
    }


    @Override
    public String updateForecasting(int id, int forecastItemID, int forecastingTypeID, double forecastingValue, LocalDateTime forecastDateTime, LocalDateTime createdDateTime, LocalDateTime updatedDateTime, char isActive) throws Exception {

        Optional<ForecastingEntity> existingItem = forecastingRepo.findById(id);
        if (existingItem.isPresent()) {
            ForecastingEntity updatedItem = existingItem.get();
            updatedItem.setId(id);
            updatedItem.setForecastItemID(forecastItemID);
            updatedItem.setForecastingTypeID(forecastingTypeID);
            updatedItem.setForecastingValue(forecastingValue);
            updatedItem.setForecastDateTime(forecastDateTime);
            updatedItem.setCreatedDateTime(createdDateTime);
            updatedItem.setUpdatedDateTime(updatedDateTime);
            updatedItem.setIsActive(isActive);

            forecastingRepo.save(updatedItem);

            return "Successfully Updated!";

        } else {
            throw new Exception("ForecastItemEntity with ID " + id + " not found");
        }
    }
}
