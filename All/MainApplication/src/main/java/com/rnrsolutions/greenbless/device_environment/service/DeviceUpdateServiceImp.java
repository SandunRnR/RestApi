package com.rnrsolutions.greenbless.device_environment.service;

import com.rnrsolutions.greenbless.device_environment.entity.DeviceStateEntity;
import com.rnrsolutions.greenbless.device_environment.entity.DeviceUpdateEntity;
import com.rnrsolutions.greenbless.device_environment.repository.DeviceUpdateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceUpdateServiceImp implements DeviceUpdateService{
    @Autowired
    private DeviceUpdateRepo deviceUpdateRepo;

    @Override
    public String saveDeviceUpdate(String pUpdatedValue){

        LocalDateTime pUpdatedDateAndTime = LocalDateTime.now();

        DeviceUpdateEntity newObjectDeviceUpdateEntity = new DeviceUpdateEntity(pUpdatedValue,pUpdatedDateAndTime);

        try{
            deviceUpdateRepo.save(newObjectDeviceUpdateEntity);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Successfully Inserted";
    }

    @Override
    public void deleteDeviceUpdateById(int id) throws Exception{
        deviceUpdateRepo.deleteById(id);
    }

    @Override
    public List<DeviceUpdateEntity> getAllDeviceUpdateEntities() throws Exception{
        return deviceUpdateRepo.findAll();
    }

    @Override
    public String updateDeviceUpdate(int id ,String updatedValue, LocalDateTime updatedDateAndTime) throws Exception {
        Optional<DeviceUpdateEntity> existingItem = deviceUpdateRepo.findById(id);
        if (existingItem.isPresent()) {
            DeviceUpdateEntity updatedItem = existingItem.get();
            updatedItem.setUpdatedValue(updatedValue);
            updatedItem.setUpdatedDateAndTime(updatedDateAndTime);
            deviceUpdateRepo.save(updatedItem);
            return "Successfully Updated!";
        } else {
            throw new Exception("ForecastTypeEntity with ID " + id + " not Found!");
        }

    }
}
