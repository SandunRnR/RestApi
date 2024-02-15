package com.rnrsolutions.greenbless.device_environment.service;

import com.rnrsolutions.greenbless.device_environment.entity.DeviceEnvironmentEntity1;
import com.rnrsolutions.greenbless.device_environment.repository.DeviceEnvironmentRepo1;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DeviceEnvironmentServiceImp1 implements DeviceEnvironmentService1{
    @Autowired
    private DeviceEnvironmentRepo1 deviceEnvironmentRepo1;

    @Override
    public String saveDeviceEnvironment1(String pDeviceID, String pDeviceType) throws Exception {

        LocalDateTime currentDateTime = LocalDateTime.now();

        DeviceEnvironmentEntity1 newObjectDeviceEnvironmentEntity1 = new DeviceEnvironmentEntity1(pDeviceID, pDeviceType);

        try {
            deviceEnvironmentRepo1.save(newObjectDeviceEnvironmentEntity1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Successfully Inserted!";
    }



    @Override
    public void deleteDeviceEnvironment1ById(int id) throws Exception {
        deviceEnvironmentRepo1.deleteById(id);
    }

    @Override
    public List<DeviceEnvironmentEntity1> getAllDeviceEnvironments() {
        return deviceEnvironmentRepo1.findAll();
    }

    @Override
    public String updateDeviceEnvironment1(int pId,String pDeviceId, String pDeviceType) throws Exception{
        Optional<DeviceEnvironmentEntity1> existingItem = deviceEnvironmentRepo1.findById(pId);
        if (existingItem.isPresent()) {
            DeviceEnvironmentEntity1 updatedItem = existingItem.get();
            updatedItem.setId(pId);
            updatedItem.setDeviceID(pDeviceId);
            updatedItem.setDeviceType(pDeviceType);
            deviceEnvironmentRepo1.save(updatedItem);
            return "Successfully Updated!";
        } else {
            throw new Exception("ForecastItemEntity with ID " + pId + " not found");
        }
    }
}
