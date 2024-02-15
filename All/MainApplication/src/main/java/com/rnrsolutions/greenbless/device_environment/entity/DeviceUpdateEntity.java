package com.rnrsolutions.greenbless.device_environment.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Data
@Table(name = "DeviceUpdateTable")
public class DeviceUpdateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String updatedValue;
    private LocalDateTime updatedDateAndTime;

    public DeviceUpdateEntity(String pUpdatedValue, LocalDateTime pUpdatedDateAndTime){
        this.updatedValue = pUpdatedValue;
        this.updatedDateAndTime = pUpdatedDateAndTime;
    }
}
