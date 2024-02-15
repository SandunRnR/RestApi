package com.rnrsolutions.greenbless.device_environment.controller;

import com.rnrsolutions.greenbless.device_environment.dto.DeviceStateDTO;
import com.rnrsolutions.greenbless.device_environment.dto.DeviceUpdateDTO;
import com.rnrsolutions.greenbless.device_environment.entity.DeviceUpdateEntity;
import com.rnrsolutions.greenbless.device_environment.service.DeviceUpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/deviceUpdate")
public class DeviceUpdateController {
    private static final Logger logger = LoggerFactory.getLogger(DeviceUpdateController.class);

    @Autowired
    private DeviceUpdateService deviceUpdateService;

    @PostMapping("/saveDTO")
    public String saveDeviceUpdate(@RequestBody DeviceUpdateDTO deviceUpdateDTO) throws Exception {
        return deviceUpdateService.saveDeviceUpdate(deviceUpdateDTO.getUpdatedValue());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDeviceUpdateById(@PathVariable int id) throws Exception {
        deviceUpdateService.deleteDeviceUpdateById(id);
        return "Successfully Deleted!";
    }

    @GetMapping("/getAll")
    public List<DeviceUpdateEntity> getAllDeviceUpdateEntities() throws Exception {
        return deviceUpdateService.getAllDeviceUpdateEntities();
    }

    @PutMapping("update")
    public String updateDeviceUpdate(@RequestBody DeviceUpdateDTO pDeviceUpdateDTO) throws Exception{
        logger.info("DeviceUpdateDTO.getId()       value:" + pDeviceUpdateDTO.getId());
        logger.info("DeviceUpdateDTO.getDeviceID() value:" + pDeviceUpdateDTO.getUpdatedValue());
        logger.info("DeviceUpdateDTO.getState()    value:" + pDeviceUpdateDTO.getUpdatedDateAndTime());
        return deviceUpdateService.updateDeviceUpdate(pDeviceUpdateDTO.getId(),pDeviceUpdateDTO.getUpdatedValue()
                ,pDeviceUpdateDTO.getUpdatedDateAndTime());
    }

}
