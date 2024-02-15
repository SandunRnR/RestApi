package com.rnrsolutions.greenbless.device_environment.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DeviceEnvironmentEntity2DTO {
    private int id;

    private String deviceID;
    private double currentValue;
    private LocalDateTime uploadDateAndTime;

}
