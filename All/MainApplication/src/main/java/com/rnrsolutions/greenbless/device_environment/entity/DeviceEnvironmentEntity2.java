package com.rnrsolutions.greenbless.device_environment.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "DeviceEnvironmentTable2")
public class DeviceEnvironmentEntity2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String deviceID;
    private double currentValue;
    private LocalDateTime uploadDateAndTime;

    public DeviceEnvironmentEntity2(
            String pDeviceID,
            double pCurrentValue,
            LocalDateTime pUploadDateTime) {
        this.deviceID = pDeviceID;
        this.currentValue = pCurrentValue;
        this.uploadDateAndTime = pUploadDateTime;
    }
}
