package com.rnrsolutions.greenbless.device_environment.controller;

import com.rnrsolutions.greenbless.device_environment.dto.DeviceEnvironmentEntity1DTO;
import com.rnrsolutions.greenbless.device_environment.entity.DeviceEnvironmentEntity1;
import com.rnrsolutions.greenbless.device_environment.service.DeviceEnvironmentService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deviceEnvironment1")
public class DeviceEnvironmentController1 {
    private static final Logger logger = LoggerFactory.getLogger(DeviceEnvironmentController1.class);


    @Autowired
    private DeviceEnvironmentService1 deviceEnvironmentService1;


    @PostMapping("/saveDTO")
    public String saveEnvironmentWithDTO(
            @RequestBody DeviceEnvironmentEntity1DTO pDeviceEnvironmentEntity1DTO) throws Exception {
        return deviceEnvironmentService1.saveDeviceEnvironment1(pDeviceEnvironmentEntity1DTO.getDeviceID(),
                pDeviceEnvironmentEntity1DTO.getDeviceType()
        );
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDeviceEnvironmentById(@PathVariable int id) throws Exception {
        deviceEnvironmentService1.deleteDeviceEnvironment1ById(id);
        return "Successfully Deleted!";
    }

    @GetMapping("/getAll")
    public List<DeviceEnvironmentEntity1> getAllDeviceEnvironments() {
        return deviceEnvironmentService1.getAllDeviceEnvironments();
    }

    @PutMapping("/update")
    public String updateDeviceEnvironment1(@RequestBody DeviceEnvironmentEntity1DTO pDeviceEnvironmentEntity1DTO) throws Exception{

        logger.info("DeviceEnvironmentEntity1DTO.getId            value:" + pDeviceEnvironmentEntity1DTO.getId());
        logger.info("pDeviceEnvironmentEntity1DTO.getDeviceID()   value:" + pDeviceEnvironmentEntity1DTO.getDeviceID());
        logger.info("pDeviceEnvironmentEntity1DTO.getDeviceType() value:" + pDeviceEnvironmentEntity1DTO.getDeviceType());

        return deviceEnvironmentService1.updateDeviceEnvironment1(pDeviceEnvironmentEntity1DTO.getId(),
                pDeviceEnvironmentEntity1DTO.getDeviceID(),pDeviceEnvironmentEntity1DTO.getDeviceType());
    }

}
