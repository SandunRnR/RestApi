package com.rnrsolutions.greenbless.react.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReactDTO {

    private int id;

    private int quantity;
    private String item;
    private LocalDateTime uploadDateAndTime;
}
