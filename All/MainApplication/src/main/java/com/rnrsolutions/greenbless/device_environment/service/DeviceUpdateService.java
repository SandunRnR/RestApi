package com.rnrsolutions.greenbless.device_environment.service;

import com.rnrsolutions.greenbless.device_environment.entity.DeviceUpdateEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface DeviceUpdateService {
    public String saveDeviceUpdate(String pUpdatedValue);

    public void  deleteDeviceUpdateById(int id) throws Exception;

    public List<DeviceUpdateEntity> getAllDeviceUpdateEntities() throws Exception;

    public String updateDeviceUpdate(int id, String updatedValue, LocalDateTime updatedDateAndTime) throws Exception;
}
