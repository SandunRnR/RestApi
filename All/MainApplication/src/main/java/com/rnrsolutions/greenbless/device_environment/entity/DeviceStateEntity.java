package com.rnrsolutions.greenbless.device_environment.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "DeviceStateTable")
public class DeviceStateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String deviceID;
    private String state;
    private String command;

    public DeviceStateEntity (String pDeviceID, String pState, String pCommand){
        this.deviceID = pDeviceID;
        this.state = pState;
        this.command = pCommand;
    }
}
