package com.rnrsolutions.greenbless.device_environment.controller;

import com.rnrsolutions.greenbless.device_environment.dto.DeviceStateDTO;
import com.rnrsolutions.greenbless.device_environment.entity.DeviceStateEntity;
import com.rnrsolutions.greenbless.device_environment.service.DeviceStateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/deviceState")
public class DeviceStateController {
    private static final Logger logger = LoggerFactory.getLogger(DeviceStateController.class);

    @Autowired
    private DeviceStateService deviceStateService;

    @PostMapping("/saveDTO")
    public String saveDeviceState(@RequestBody DeviceStateDTO deviceStateDTO) throws Exception{
        return deviceStateService.saveDeviceState(deviceStateDTO.getDeviceID(),deviceStateDTO.getState(),deviceStateDTO.getCommand());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDeviceStateById(@PathVariable int id) throws Exception{
        deviceStateService.deleteDeviceStateById(id);
        return "Successfully Deleted!";
    }

    @GetMapping("/getAll")
    public List<DeviceStateEntity> getAllDeviceStateEntities(){
        return deviceStateService.getAllDeviceStateEntities();
    }

    @PutMapping("/update")
    public String updateDeviceState(@RequestBody DeviceStateDTO pDeviceStateDTO) throws Exception{

        logger.info("pDeviceStateDTO.getId()       value:" + pDeviceStateDTO.getId());
        logger.info("pDeviceStateDTO.getDeviceID() value:" + pDeviceStateDTO.getDeviceID());
        logger.info("pDeviceStateDTO.getState()    value:" + pDeviceStateDTO.getState());
        logger.info("pDeviceStateDTO.getCommand()  value:" + pDeviceStateDTO.getCommand());

        return deviceStateService.updateDeviceState(pDeviceStateDTO.getId(),pDeviceStateDTO.getDeviceID(),pDeviceStateDTO.getState()
                ,pDeviceStateDTO.getCommand());
    }
}
