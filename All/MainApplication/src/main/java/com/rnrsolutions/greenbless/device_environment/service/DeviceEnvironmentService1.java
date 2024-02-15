package com.rnrsolutions.greenbless.device_environment.service;

import com.rnrsolutions.greenbless.device_environment.entity.DeviceEnvironmentEntity1;

import java.util.List;

public interface DeviceEnvironmentService1 {
    public String saveDeviceEnvironment1(String pDeviceID, String pDeviceType) throws Exception;

    public void deleteDeviceEnvironment1ById(int id) throws Exception;

    public List<DeviceEnvironmentEntity1> getAllDeviceEnvironments();

    public String updateDeviceEnvironment1(int pId,String pDeviceId, String pDeviceType) throws Exception;

}
