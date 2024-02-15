package com.rnrsolutions.greenbless.device_environment.service;

import com.rnrsolutions.greenbless.device_environment.entity.DeviceStateEntity;

import java.util.List;

public interface DeviceStateService {
    public String saveDeviceState(String pDeviceID, String pState, String pCommand) throws Exception;

    public void deleteDeviceStateById(int id) throws Exception;

    public List<DeviceStateEntity> getAllDeviceStateEntities();

    public String updateDeviceState(int id,String deviceID, String state, String command) throws Exception;

}
