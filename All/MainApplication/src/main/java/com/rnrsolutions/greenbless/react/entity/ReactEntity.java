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

    private String p_id;
    private double product_version;
    private String name;
    private String category;
    private String model;
    private String brand;
    private String data_area;
    private String product_rec_id;

    public ReactEntity(
            String p_p_id,
            double p_product_version,
            String p_name,
            String p_category,
            String p_model,
            String p_brand,
            String p_data_area,
            String p_product_rec_id
    ) {
        this.p_id = p_p_id;
        this.product_version = p_product_version;
        this.name = p_name;
        this.category = p_category;
        this.model = p_model;
        this.brand = p_brand;
        this.data_area = p_data_area;
        this.product_rec_id = p_product_rec_id;

    }

}
