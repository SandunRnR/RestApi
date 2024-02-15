package com.rnrsolutions.greenbless.device_environment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceStateDTO {
    private int id;

    private String deviceID;
    private String state;
    private String command;
}
