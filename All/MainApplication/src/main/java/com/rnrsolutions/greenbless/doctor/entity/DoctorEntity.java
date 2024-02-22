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
    private String token;
    private String chatText;

    public DoctorEntity(
            String pName,
            String pPhoneNumber,
            String pToken,
            String pChatText) {
        this.name = pName;
        this.phoneNumber = pPhoneNumber;
        this.token = pToken;
        this.chatText = pChatText;
    }
}