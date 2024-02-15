package com.rnrsolutions.greenbless.device_environment.service;

import com.rnrsolutions.greenbless.device_environment.entity.DeviceStateEntity;
import com.rnrsolutions.greenbless.device_environment.repository.DeviceStateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceStateServiceImp implements DeviceStateService{
    @Autowired
    private DeviceStateRepo deviceStateRepo;

    @Override
    public String saveDeviceState(String pDeviceID,String pState, String pCommand) throws Exception{

        DeviceStateEntity newObjectDeviceStateEntity = new DeviceStateEntity(pDeviceID,pState,pCommand);

        try {
            deviceStateRepo.save(newObjectDeviceStateEntity);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Successfully Inserted!";
    }

    @Override
    public void deleteDeviceStateById(int id) throws Exception{
        deviceStateRepo.deleteById(id);
    }

    @Override
    public List<DeviceStateEntity> getAllDeviceStateEntities(){
        return deviceStateRepo.findAll();
    }

    @Override
    public String updateDeviceState(int id ,String deviceID, String state, String command) throws Exception {
        Optional<DeviceStateEntity> existingItem = deviceStateRepo.findById(id);
        if (existingItem.isPresent()) {
            DeviceStateEntity updatedItem = existingItem.get();
            updatedItem.setDeviceID(deviceID);
            updatedItem.setState(state);
            updatedItem.setCommand(command);
            deviceStateRepo.save(updatedItem);
            return "Successfully Updated!";
        } else {
            throw new Exception("ForecastTypeEntity with ID " + id + " not Found!");
        }

    }

}
