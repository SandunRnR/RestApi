package com.rnrsolutions.greenbless.device_environment.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DeviceUpdateDTO {
    private int id;

    private String updatedValue;
    private LocalDateTime updatedDateAndTime;

}
