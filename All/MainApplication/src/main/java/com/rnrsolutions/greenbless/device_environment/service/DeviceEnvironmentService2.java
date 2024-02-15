package com.rnrsolutions.greenbless.device_environment.service;

import com.rnrsolutions.greenbless.device_environment.entity.DeviceEnvironmentEntity2;

import java.time.LocalDateTime;
import java.util.List;

public interface DeviceEnvironmentService2 {
    void deleteDeviceEnvironment2ById(int id) throws Exception;

    List<DeviceEnvironmentEntity2> getAllDeviceEnvironments();


    String updateDeviceEnvironment2(int id, String deviceID, double currentValue, LocalDateTime uploadDateAndTime) throws Exception;

    String saveDeviceEnvironment2(String deviceID, double currentValue, LocalDateTime uploadDateAndTime) throws Exception;

}
