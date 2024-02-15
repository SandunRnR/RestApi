package com.rnrsolutions.greenbless.doctor.entity;

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
@Table(name = "DoctorApp")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String phoneNumber;

    public DoctorEntity(
            String pName,
            String pPhoneNumber) {
        this.name = pName;
        this.phoneNumber = pPhoneNumber;
    }
}