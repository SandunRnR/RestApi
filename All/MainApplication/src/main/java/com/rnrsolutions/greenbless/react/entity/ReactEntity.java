package com.rnrsolutions.greenbless.react.entity;


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
@Table(name = "React")
public class ReactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;
    private String item;
    private LocalDateTime uploadDateAndTime;

    public ReactEntity(
            int pQuantity,
            String pItem,
            LocalDateTime pUploadDateTime
    ) {
        this.quantity = pQuantity;
        this.item = pItem;
        this.uploadDateAndTime = pUploadDateTime;

    }

}
