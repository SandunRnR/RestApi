package com.rnrsolutions.greenbless.forecast.service;

import com.rnrsolutions.greenbless.forecast.entity.ForecastTypeEntity;
import com.rnrsolutions.greenbless.forecast.repository.ForecastTypeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ForecastTypeServiceImp implements ForecastTypeService{
    @Autowired
    private ForecastTypeRepo forecastTypeRepo;

    @Override
    public String saveForecastType(String pName, char pContributionOrder) {

        ForecastTypeEntity newObjectForecastTypeEntity = new ForecastTypeEntity(pName, pContributionOrder);

        try {
            forecastTypeRepo.save(newObjectForecastTypeEntity);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Successfully Inserted!";
    }

    @Override
    public void deleteForecastTypeById(int Id) throws Exception {
        forecastTypeRepo.deleteById(Id);
    }

    @Override
    public List<ForecastTypeEntity> getAllForecastTypeEntity() {
        return forecastTypeRepo.findAll();
    }

    @Override
    public String updateForecastType(int id, String name, char contributionOrder) throws Exception {
        Optional<ForecastTypeEntity> existingItem = forecastTypeRepo.findById(id);
        if (existingItem.isPresent()) {
            ForecastTypeEntity updatedItem = existingItem.get();
            updatedItem.setId(id);
            updatedItem.setName(name);
            updatedItem.setContributionOrder(contributionOrder);
            forecastTypeRepo.save(updatedItem);
            return "Successfully Updated!";
        } else {
            throw new Exception("ForecastTypeEntity with ID " + id + " not Found!");
        }

    }
}
