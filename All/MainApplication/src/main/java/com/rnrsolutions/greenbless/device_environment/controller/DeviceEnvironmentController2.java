package com.rnrsolutions.greenbless.device_environment.controller;

import com.rnrsolutions.greenbless.device_environment.dto.DeviceEnvironmentEntity2DTO;
import com.rnrsolutions.greenbless.device_environment.entity.DeviceEnvironmentEntity2;
import com.rnrsolutions.greenbless.device_environment.service.DeviceEnvironmentService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deviceEnvironment2")
public class DeviceEnvironmentController2 {
    private static final Logger logger = LoggerFactory.getLogger(DeviceEnvironmentController2.class);

    @Autowired
    private DeviceEnvironmentService2 deviceEnvironmentService2;


    @PostMapping("/saveDTO")
    public String saveEnvironmentWithDTO(
            @RequestBody DeviceEnvironmentEntity2DTO pDeviceEnvironmentEntity2DTO) throws Exception {
        return deviceEnvironmentService2.saveDeviceEnvironment2(pDeviceEnvironmentEntity2DTO.getDeviceID(),
                pDeviceEnvironmentEntity2DTO.getCurrentValue(),pDeviceEnvironmentEntity2DTO.getUploadDateAndTime()
        );
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDeviceEnvironmentById(@PathVariable int id) throws Exception {
        deviceEnvironmentService2.deleteDeviceEnvironment2ById(id);
        return "Successfully Deleted!";
    }

    @GetMapping("/getAll")
    public List<DeviceEnvironmentEntity2> getAllDeviceEnvironments() {
        return deviceEnvironmentService2.getAllDeviceEnvironments();
    }

    @PutMapping("/update")
    public String updateDeviceEnvironment2(@RequestBody DeviceEnvironmentEntity2DTO pDeviceEnvironmentEntity2DTO) throws Exception{

        logger.info("pDeviceEnvironmentEntity2DTO.getId()                value:" + pDeviceEnvironmentEntity2DTO.getId());
        logger.info("pDeviceEnvironmentEntity2DTO.getDeviceID()          value:" + pDeviceEnvironmentEntity2DTO.getDeviceID());
        logger.info(" pDeviceEnvironmentEntity2DTO.getCurrentValue()     value:" + pDeviceEnvironmentEntity2DTO.getCurrentValue());
        logger.info("pDeviceEnvironmentEntity2DTO.getUploadDateAndTime() value:" + pDeviceEnvironmentEntity2DTO.getUploadDateAndTime());

        return deviceEnvironmentService2.updateDeviceEnvironment2(pDeviceEnvironmentEntity2DTO.getId(),pDeviceEnvironmentEntity2DTO.getDeviceID(),
                pDeviceEnvironmentEntity2DTO.getCurrentValue(),pDeviceEnvironmentEntity2DTO.getUploadDateAndTime());
    }
}
