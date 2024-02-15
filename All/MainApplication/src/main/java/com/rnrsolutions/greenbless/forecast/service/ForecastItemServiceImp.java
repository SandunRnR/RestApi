package com.rnrsolutions.greenbless.forecast.service;

import com.rnrsolutions.greenbless.forecast.entity.ForecastItemEntity;
import com.rnrsolutions.greenbless.forecast.repository.ForecastItemRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ForecastItemServiceImp implements ForecastItemService{
    @Autowired
    private ForecastItemRepo forecastItemRepo;

    @Override
    public String saveForecastItem(String pItemName, int pForecastingInterval) throws Exception {

//        LocalDateTime currentDateTime = LocalDateTime.now();

        ForecastItemEntity newObjectForecastItemEntity = new ForecastItemEntity(pItemName, pForecastingInterval);

        try {
            forecastItemRepo.save(newObjectForecastItemEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Successfully Inserted!";
    }

    @Override
    public void deleteForecastItemById(int id) throws Exception {
        forecastItemRepo.deleteById(id);
    }

    @Override
    public List<ForecastItemEntity> getAllDeviceForecastItems() throws Exception {
        return forecastItemRepo.findAll();
    }

    @Override
    public String updateForecastItem(int id, String pItemName, int pForecastingInterval) throws Exception {
        Optional<ForecastItemEntity> existingItem = forecastItemRepo.findById(id);
        if (existingItem.isPresent()) {
            ForecastItemEntity updatedItem = existingItem.get();
            updatedItem.setId(id);
            updatedItem.setItemName(pItemName);
            updatedItem.setForecastingInterval(pForecastingInterval);
            forecastItemRepo.save(updatedItem);
            return "Successfully Updated!";
        } else {
            throw new Exception("ForecastItemEntity with ID " + id + " not found");
        }
    }
}
