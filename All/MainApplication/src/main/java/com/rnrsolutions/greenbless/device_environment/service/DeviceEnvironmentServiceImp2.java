package com.rnrsolutions.greenbless.device_environment.service;

import com.rnrsolutions.greenbless.device_environment.entity.DeviceEnvironmentEntity2;
import com.rnrsolutions.greenbless.device_environment.repository.DeviceEnvironmentRepo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceEnvironmentServiceImp2 implements DeviceEnvironmentService2{
    @Autowired
    private DeviceEnvironmentRepo2 deviceEnvironmentRepo2;

//    @Value("${upload.image.path}")
//    private String uploadImagePath;

    @Override
    public String saveDeviceEnvironment2(String pDeviceID, double pCurrentValue , LocalDateTime uploadDateAndTime) throws Exception {

        LocalDateTime currentDateTime = LocalDateTime.now();

        DeviceEnvironmentEntity2 newObjectDeviceEnvironmentEntity2 = new DeviceEnvironmentEntity2(pDeviceID, pCurrentValue, uploadDateAndTime);

        try {
            deviceEnvironmentRepo2.save(newObjectDeviceEnvironmentEntity2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Successfully Inserted!";
    }


    @Override
    public void deleteDeviceEnvironment2ById(int id) throws Exception {
        deviceEnvironmentRepo2.deleteById(id);
    }

    @Override
    public List<DeviceEnvironmentEntity2> getAllDeviceEnvironments() {
        return deviceEnvironmentRepo2.findAll();
    }


    @Override
    public String updateDeviceEnvironment2(int pId,String pDeviceId, double pCurrentValue, LocalDateTime pUploadDateTime) throws Exception{
        Optional<DeviceEnvironmentEntity2> existingItem = deviceEnvironmentRepo2.findById(pId);
        if (existingItem.isPresent()) {
            DeviceEnvironmentEntity2 updatedItem = existingItem.get();

            updatedItem.setId(pId);
            updatedItem.setDeviceID(pDeviceId);
            updatedItem.setCurrentValue(pCurrentValue);
            updatedItem.setUploadDateAndTime(pUploadDateTime);

            deviceEnvironmentRepo2.save(updatedItem);
            return "Successfully Updated!";
        } else {
            throw new Exception("ForecastItemEntity with ID " + pId + " not found");
        }
    }
}
