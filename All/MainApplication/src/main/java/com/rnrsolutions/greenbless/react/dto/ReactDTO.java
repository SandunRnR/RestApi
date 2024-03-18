package com.rnrsolutions.greenbless.react.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReactDTO {

    private int id;

    private String p_id;
    private double product_version;
    private String name;
    private String category;
    private String model;
    private String brand;
    private String data_area;
    private String product_rec_id;
}
